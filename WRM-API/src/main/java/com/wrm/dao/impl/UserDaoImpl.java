package com.wrm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.wrm.dao.DaoImpl;
import com.wrm.dao.DaoInterface;
import com.wrm.dao.model.User;

public class UserDaoImpl extends DaoImpl implements DaoInterface<User, String> {

	private static final String FIND_ALL_USERS = "from User";
	private static final String FIND_ALL_USERS_BY_GROUPID = "from User where group_id=:groupId";
	private static final String FIND_BY_USERID = "from User where name = :userId and group_id = :groupId";

	@Override
	public String persist(User entity) {
		getCurrentSessionWithTransaction().save(entity);
		return entity.getId();
	}

	@Override
	public void update(User entity) {
		getCurrentSessionWithTransaction().update(entity);
	}

	public void saveOrUpdate(User entity) {
		getCurrentSessionWithTransaction().saveOrUpdate(entity);
	}

	public void merge(User entity) {
		getCurrentSessionWithTransaction().merge(entity);
	}

	@Override
	public User findById(String id) {
		User entity = (User) getCurrentSessionWithTransaction().load(User.class, new String(id));
		return entity;
	}

	@Override
	public boolean delete(String id) {
		User entity = findById(id);
		if (entity != null) {
			getCurrentSessionWithTransaction().delete(entity);
		} else {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		List<User> entities = (List<User>) getCurrentSessionWithTransaction().createQuery(FIND_ALL_USERS).list();
		return entities;
	}
	
	public List<User> findAllByGroupId(String groupId) {
		List<User> entities = (List<User>) getCurrentSessionWithTransaction().createQuery(FIND_ALL_USERS_BY_GROUPID)
				.setParameter("groupId", groupId)
				.list();
		return entities;
	}

	@SuppressWarnings("unchecked")
	public List<User> findByUserId(String userId, String groupId) {
		List<User> entity = (List<User>) getCurrentSessionWithTransaction().createQuery(FIND_BY_USERID)
				.setParameter("userId", userId).setParameter("groupId", groupId).list();
		return entity;
	}
	
	@Override
	public void deleteAll() {
		// Method not implemented, Not sure
	}
}
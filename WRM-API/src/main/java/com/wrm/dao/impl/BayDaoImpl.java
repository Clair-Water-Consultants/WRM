package com.wrm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.wrm.dao.DaoImpl;
import com.wrm.dao.DaoInterface;
import com.wrm.dao.model.Bay;

public class BayDaoImpl extends DaoImpl implements DaoInterface<Bay, String> {

	private static final String FIND_ALL_BAYS = "from Bay";

	private static final String FIND_ALL_BY_GROUPID = "from Bay where group_id=:groupId";

	@Override
	public String persist(Bay entity) {
		getCurrentSessionWithTransaction().save(entity);
		return entity.getId();
	}

	@Override
	public void update(Bay entity) {
		getCurrentSessionWithTransaction().update(entity);
	}

	public void saveOrUpdate(Bay entity) {
		getCurrentSessionWithTransaction().saveOrUpdate(entity);
	}

	public void merge(Bay entity) {
		getCurrentSessionWithTransaction().merge(entity);
	}

	@Override
	public Bay findById(String id) {
		Bay entity = (Bay) getCurrentSessionWithTransaction().load(Bay.class, new String(id));
		return entity;
	}

	@Override
	public boolean delete(String id) {
		Bay entity = findById(id);
		if (entity != null) {
			getCurrentSessionWithTransaction().delete(entity);
		} else {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bay> findAll() {
		List<Bay> entities = (List<Bay>) getCurrentSessionWithTransaction().createQuery(FIND_ALL_BAYS).list();
		return entities;
	}

	@Override
	public void deleteAll() {
		// Method not implemented, Not sure
	}
}

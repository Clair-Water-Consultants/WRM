package com.wrm.dao.impl;

import java.util.List;

import com.wrm.dao.DaoImpl;
import com.wrm.dao.DaoInterface;
import com.wrm.dao.model.CompanyGroup;
import com.wrm.dao.model.User;

public class CompanyGroupDaoImpl extends DaoImpl implements DaoInterface<CompanyGroup, String> {

	private static final String FIND_ALL_ELEMENTS = "from CompanyGroup";
	private static final String FIND_BY_NAME = "from CompanyGroup where name = :userName and description = :description";

	@Override
	public String persist(CompanyGroup entity) {
		getCurrentSessionWithTransaction().save(entity);
		return entity.getId();
	}

	@Override
	public void update(CompanyGroup entity) {
		getCurrentSessionWithTransaction().update(entity);
	}

	public void saveOrUpdate(CompanyGroup entity) {
		getCurrentSessionWithTransaction().saveOrUpdate(entity);
	}

	public void merge(CompanyGroup entity) {
		getCurrentSessionWithTransaction().merge(entity);
	}

	@Override
	public CompanyGroup findById(String id) {
		CompanyGroup entity = (CompanyGroup) getCurrentSessionWithTransaction().load(CompanyGroup.class, new String(id));
		return entity;
	}

	@Override
	public boolean delete(String id) {
		CompanyGroup entity = findById(id);
		if (entity != null) {
			getCurrentSessionWithTransaction().delete(entity);
		} else {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompanyGroup> findAll() {
		List<CompanyGroup> entities = (List<CompanyGroup>) getCurrentSessionWithTransaction().createQuery(FIND_ALL_ELEMENTS).list();
		return entities;
	}
	
	@SuppressWarnings("unchecked")
	public List<CompanyGroup> findByName(String name, String description) {
		List<CompanyGroup> entity = (List<CompanyGroup>) getCurrentSessionWithTransaction().createQuery(FIND_BY_NAME)
				.setParameter("userName", name).setParameter("description", description).list();
		return entity;
	}

	@Override
	public void deleteAll() {
		// Method not implemented, Not sure
	}
}

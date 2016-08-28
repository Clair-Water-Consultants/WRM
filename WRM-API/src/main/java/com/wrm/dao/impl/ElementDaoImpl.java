package com.wrm.dao.impl;

import java.util.List;

import com.wrm.dao.DaoImpl;
import com.wrm.dao.DaoInterface;
import com.wrm.dao.model.Bay;
import com.wrm.dao.model.Element;

public class ElementDaoImpl extends DaoImpl implements DaoInterface<Element, String> {

	private static final String FIND_ALL_ELEMENTS = "from Element";

	@Override
	public String persist(Element entity) {
		getCurrentSessionWithTransaction().save(entity);
		return entity.getId();
	}

	@Override
	public void update(Element entity) {
		getCurrentSessionWithTransaction().update(entity);
	}

	public void saveOrUpdate(Element entity) {
		getCurrentSessionWithTransaction().saveOrUpdate(entity);
	}

	public void merge(Element entity) {
		getCurrentSessionWithTransaction().merge(entity);
	}

	@Override
	public Element findById(String id) {
		Element entity = (Element) getCurrentSessionWithTransaction().load(Element.class, new String(id));
		return entity;
	}

	@Override
	public boolean delete(String id) {
		Element entity = findById(id);
		if (entity != null) {
			getCurrentSessionWithTransaction().delete(entity);
		} else {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Element> findAll() {
		List<Element> entities = (List<Element>) getCurrentSessionWithTransaction().createQuery(FIND_ALL_ELEMENTS).list();
		return entities;
	}

	@Override
	public void deleteAll() {
		// Method not implemented, Not sure
	}
}

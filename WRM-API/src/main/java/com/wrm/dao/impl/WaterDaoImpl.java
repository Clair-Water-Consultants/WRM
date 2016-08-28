package com.wrm.dao.impl;

import java.util.List;

import com.wrm.dao.DaoImpl;
import com.wrm.dao.DaoInterface;
import com.wrm.dao.model.Water;
import com.wrm.dao.model.WaterBayAssociation;

public class WaterDaoImpl extends DaoImpl implements DaoInterface<Water, String> {

	private static final String FIND_ALL_ELEMENTS = "from WaterBayAssociation";
	private static final String FIND_ALL_ASSOCIATION = "select assoc from WaterBayAssociation assoc, Bay bay, Water water"
      + " where bay.id = assoc.primary.bay.id and  water.id = assoc.primary.water.id and assoc.primary.bay.groupId = :groupId  and assoc.primary.bay.id = :bayId";

	@Override
	public String persist(Water entity) {
		getCurrentSessionWithTransaction().save(entity);
		return entity.getId();
	}

	@Override
	public void update(Water entity) {
		getCurrentSessionWithTransaction().update(entity);
	}

	public void saveOrUpdate(Water entity) {
		getCurrentSessionWithTransaction().saveOrUpdate(entity);
	}

	public void merge(Water entity) {
		getCurrentSessionWithTransaction().merge(entity);
	}

	@Override
	public Water findById(String id) {
		Water entity = (Water) getCurrentSessionWithTransaction().load(Water.class, new String(id));
		return entity;
	}

	@Override
	public boolean delete(String id) {
		Water entity = findById(id);
		if (entity != null) {
			getCurrentSessionWithTransaction().delete(entity);
		} else {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Water> findAll() {
		List<Water> entities = (List<Water>) getCurrentSessionWithTransaction().createQuery(FIND_ALL_ELEMENTS).list();
		return entities;
	}
	
	@SuppressWarnings("unchecked")
	public List<WaterBayAssociation> findAll(String groupId, String bayId)
	{
		/* Criteria criteria = getCurrentSessionWithTransaction().createCriteria(WaterBayAssociation.class,"assoc");
		    criteria.add(Restrictions.eq("primary.bay.groupId", groupId));
		    criteria.add(Restrictions.eq("primary.bay.id", bayId));
		    List<WaterBayAssociation> entities = (List<WaterBayAssociation>) criteria.list();
		    return entities;*/
		List<WaterBayAssociation> entity = (List<WaterBayAssociation>) getCurrentSessionWithTransaction().createQuery(FIND_ALL_ASSOCIATION)
			        .setParameter("groupId", groupId).setParameter("bayId",bayId).list();
			    return entity;
	}

	@Override
	public void deleteAll() {
		// Method not implemented, Not sure
	}
}

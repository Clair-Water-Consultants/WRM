package com.wrm.dao.impl;

import java.util.List;

import com.wrm.dao.DaoImpl;
import com.wrm.dao.DaoInterface;
import com.wrm.dao.model.WrmData;

public class WrmDataDaoImpl extends DaoImpl implements DaoInterface<WrmData, String> {

	private static final String FIND_ALL_ELEMENTS = "from WrmData";
	private static final String FIND_BY_FILTER = "from WrmData "
			+ "where user_id=:userId "
			+ "and bay_id=:ctId "
			+ "and water_id=:waterId "
			+ "and element_id=:elementId "
			+ "created_time between now() - interval :timeperiod day and now() "
			+ "order by created_time desc";
			

	@Override
	public String persist(WrmData entity) {
		getCurrentSessionWithTransaction().save(entity);
		return "";
	}

	@Override
	public void update(WrmData entity) {
		getCurrentSessionWithTransaction().update(entity);
	}

	public void saveOrUpdate(WrmData entity) {
		getCurrentSessionWithTransaction().saveOrUpdate(entity);
	}

	public void merge(WrmData entity) {
		getCurrentSessionWithTransaction().merge(entity);
	}

	@Override
	public WrmData findById(String id) {
		return null;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WrmData> findAll() {
		List<WrmData> entities = (List<WrmData>) getCurrentSessionWithTransaction().createQuery(FIND_ALL_ELEMENTS).list();
		return entities;
	}
	
	@SuppressWarnings("unchecked")
	public List<WrmData> findByFilters(String userId, String ctId, String waterId, String elementId, int timeperiod) {
		List<WrmData> entities = (List<WrmData>) getCurrentSessionWithTransaction().createQuery(FIND_BY_FILTER)
				.setParameter("userId", userId)
				.setParameter("ctId", ctId)
				.setParameter("waterId", waterId)
				.setParameter("elementId", elementId)
				.setParameter("timeperiod", timeperiod)
				.list();
		return entities;
	}

	@Override
	public void deleteAll() {
		// Method not implemented, Not sure
	}
}

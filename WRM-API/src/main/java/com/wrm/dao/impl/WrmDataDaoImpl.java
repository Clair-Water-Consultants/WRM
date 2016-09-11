package com.wrm.dao.impl;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import com.wrm.dao.DaoImpl;
import com.wrm.dao.DaoInterface;
import com.wrm.dao.model.WrmData;

public class WrmDataDaoImpl extends DaoImpl implements DaoInterface<WrmData, String> {

	private static final String FIND_ALL_ELEMENTS = "from WrmData";
	private static final String FIND_BY_FILTER_HOURLY = "select id, user_id as userId, bay_id as bayId, water_id as waterId, element_id as elementId, "
			+ " avg(element_value) as elementValue, criteria, STR_TO_DATE(DATE_FORMAT(created_time, '%m-%d-%Y %H:%i'), '%m-%d-%Y %H:%i') as timeCreated, "
			+ " STR_TO_DATE(DATE_FORMAT(updated_time, '%m-%d-%Y %H:%i'),'%m-%d-%Y %H:%i') as timeUpdated "
			+ " from wrm_data where DATE_FORMAT(created_time, '%Y-%m-%d %H:%i:%s') between :startDate and :endDate and "
			+ " user_id=:userId and bay_id=:bayId and water_id=:waterId and element_id=:elementId "
			+ " group by DATE_FORMAT(created_time, '%m-%d-%Y %H') order by DATE_FORMAT(created_time, '%m-%d-%Y %H') desc";
	
	private static final String FIND_BY_FILTER_DAILY = "select id, user_id as userId, bay_id as bayId, water_id as waterId, element_id as elementId, "
			+ " avg(element_value) as elementValue, criteria, STR_TO_DATE(DATE_FORMAT(created_time, '%m-%d-%Y %H:%i'), '%m-%d-%Y %H:%i') as timeCreated, "
			+ " STR_TO_DATE(DATE_FORMAT(updated_time, '%m-%d-%Y %H:%i'),'%m-%d-%Y %H:%i') as timeUpdated "
			+ " from wrm_data where DATE_FORMAT(created_time, '%Y-%m-%d %H:%i:%s') between :startDate and :endDate and "
			+ " user_id=:userId and bay_id=:bayId and water_id=:waterId and element_id=:elementId "
			+ " group by DATE_FORMAT(created_time, '%m-%d-%Y') order by DATE_FORMAT(created_time, '%m-%d-%Y') desc";

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
	public List<WrmData> findByFiltersHourly(String userId, String bayId, String waterId, String elementId, String startDate, String endDate) {
		List<WrmData> entities = (List<WrmData>) getCurrentSessionWithTransaction().createSQLQuery(FIND_BY_FILTER_HOURLY)
				.setParameter("userId", userId)
				.setParameter("bayId", bayId)
				.setParameter("waterId", waterId)
				.setParameter("elementId", elementId)
				.setParameter("startDate", startDate)
				.setParameter("endDate", endDate)
				.setResultTransformer(Transformers.aliasToBean(WrmData.class))
				.list();
		return entities;
	}
	
	@SuppressWarnings("unchecked")
	public List<WrmData> findByFiltersDaily(String userId, String bayId, String waterId, String elementId, String startDate, String endDate) {
		List<WrmData> entities = (List<WrmData>) getCurrentSessionWithTransaction().createSQLQuery(FIND_BY_FILTER_DAILY)
				.setParameter("userId", userId)
				.setParameter("bayId", bayId)
				.setParameter("waterId", waterId)
				.setParameter("elementId", elementId)
				.setParameter("startDate", startDate)
				.setParameter("endDate", endDate)
				.setResultTransformer(Transformers.aliasToBean(WrmData.class))
				.list();
		return entities;
	}

	@Override
	public void deleteAll() {
		// Method not implemented, Not sure
	}
}

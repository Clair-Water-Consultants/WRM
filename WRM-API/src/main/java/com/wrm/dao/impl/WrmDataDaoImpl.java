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
	private static final String FIND_BY_FILTER_DAILY = "select Data.id, User.name as userId, Bay.name as bayId, Water.type as waterId, Element.name as elementId,  "
			+ " avg(element_value) as elementValue, criteria, STR_TO_DATE(DATE_FORMAT(Data.created_time, '%m-%d-%Y %H:%i'), '%m-%d-%Y %H:%i') as timeCreated, "
			+ " STR_TO_DATE(DATE_FORMAT(Data.updated_time, '%m-%d-%Y %H:%i'),'%m-%d-%Y %H:%i') as timeUpdated "
			+ " FROM clair_data AS Data "
            + " LEFT OUTER JOIN user AS User ON Data.user_id = User.id "
            + " LEFT OUTER JOIN ct AS Bay ON Data.CT_id = Bay.id "
            + " LEFT OUTER JOIN water AS Water ON Data.water_id = Water.id "
            + " LEFT OUTER JOIN element AS Element ON Data.element_id = Element.id "
            + " WHERE DATE_FORMAT( Data.created_time,  '%Y-%m-%d %H:%i:%s' ) between :startDate and :endDate and"
			+ " Data.user_id=:userId and (:bayId is null or Data.CT_id=:bayId) and (:waterId is null or Data.water_id=:waterId) and"
			+ " (:elementId is null or Data.element_id=:elementId) "
			+ " group by Data.created_time, Data.CT_id, Data.water_id, Data.element_id ";
			//+ " DATE_FORMAT(created_time, '%m-%d-%Y') order by DATE_FORMAT(created_time, '%m-%d-%Y') desc";
	
	private static final String FIND_BY_FILTER_HOURLY = FIND_BY_FILTER_DAILY;

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

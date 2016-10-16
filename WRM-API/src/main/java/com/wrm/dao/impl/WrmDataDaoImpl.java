package com.wrm.dao.impl;

import java.util.List;

import org.hibernate.transform.Transformers;

import com.wrm.dao.DaoImpl;
import com.wrm.dao.DaoInterface;
import com.wrm.dao.model.WrmData;

public class WrmDataDaoImpl extends DaoImpl implements DaoInterface<WrmData, String> {

	private static final String FIND_ALL_ELEMENTS = "from WrmData";

	private static final String FIND_BY_FILTER_YEARLY_USERID = "select Data.id, User.name as userId, Bay.name as bayId, Water.type as waterId, Element.name as elementId,  "
			+ " avg(element_value) as elementValue, criteria, STR_TO_DATE(DATE_FORMAT(Data.created_time, '%Y'), '%Y-%m-%d %H:%i') as timeCreated, "
			+ " STR_TO_DATE(DATE_FORMAT(Data.updated_time, '%Y'),'%Y-%m-%d %H:%i') as timeUpdated "
			+ " FROM clair_data AS Data "
			+ " LEFT OUTER JOIN user AS User ON Data.user_id = User.id "
			+ " LEFT OUTER JOIN ct AS Bay ON Data.CT_id = Bay.id "
			+ " LEFT OUTER JOIN water AS Water ON Data.water_id = Water.id "
			+ " LEFT OUTER JOIN element AS Element ON Data.element_id = Element.id "
			+ " WHERE DATE_FORMAT( Data.created_time,  '%Y-%m-%d %H:%i:%s' ) between :startDate and :endDate and"
			+ " Data.user_id=:userId and (:bayId is null or Data.CT_id=(select id from ct where name=:bayId)) and"
			+ " (:waterId is null or Data.water_id=(select id from water where type = :waterId)) and"
			+ " (:elementId is null or Data.element_id=(select id from element where name = :elementId)) "
			+ " group by timeCreated, Data.CT_id, Data.water_id, Data.element_id ";
	//+ " DATE_FORMAT(created_time, '%m-%d-%Y') order by DATE_FORMAT(created_time, '%m-%d-%Y') desc";

	private static final String FIND_BY_FILTER_YEARLY_GROUPID = "select Data.id, User.name as userId, Bay.name as bayId, Water.type as waterId, Element.name as elementId,  "
			+ " avg(element_value) as elementValue, criteria, STR_TO_DATE(DATE_FORMAT(Data.created_time, '%Y'), '%Y-%m-%d %H:%i') as timeCreated, "
			+ " STR_TO_DATE(DATE_FORMAT(Data.updated_time, '%Y'),'%Y-%m-%d %H:%i') as timeUpdated "
			+ " FROM clair_data AS Data "
			+ " LEFT OUTER JOIN user AS User ON Data.user_id = User.id "
			+ " LEFT OUTER JOIN ct AS Bay ON Data.CT_id = Bay.id "
			+ " LEFT OUTER JOIN water AS Water ON Data.water_id = Water.id "
			+ " LEFT OUTER JOIN element AS Element ON Data.element_id = Element.id "
			+ " WHERE DATE_FORMAT( Data.created_time,  '%Y-%m-%d %H:%i:%s' ) between :startDate and :endDate and"
			+ " Data.group_id=:groupId and (:bayId is null or Data.CT_id=(select id from ct where name=:bayId)) and"
			+ " (:waterId is null or Data.water_id=(select id from water where type = :waterId)) and"
			+ " (:elementId is null or Data.element_id=(select id from element where name = :elementId)) "
			+ " group by timeCreated, Data.CT_id, Data.water_id, Data.element_id ";

	private static final String FIND_BY_FILTER_MONTHLY_USERID = "select Data.id, User.name as userId, Bay.name as bayId, Water.type as waterId, Element.name as elementId,  "
			+ " avg(element_value) as elementValue, criteria, STR_TO_DATE(DATE_FORMAT(Data.created_time, '%Y-%m'), '%Y-%m-%d %H:%i') as timeCreated, "
			+ " STR_TO_DATE(DATE_FORMAT(Data.updated_time, '%Y-%m'),'%Y-%m-%d %H:%i') as timeUpdated "
			+ " FROM clair_data AS Data "
			+ " LEFT OUTER JOIN user AS User ON Data.user_id = User.id "
			+ " LEFT OUTER JOIN ct AS Bay ON Data.CT_id = Bay.id "
			+ " LEFT OUTER JOIN water AS Water ON Data.water_id = Water.id "
			+ " LEFT OUTER JOIN element AS Element ON Data.element_id = Element.id "
			+ " WHERE DATE_FORMAT( Data.created_time,  '%Y-%m-%d %H:%i:%s' ) between :startDate and :endDate and"
			+ " Data.user_id=:userId and (:bayId is null or Data.CT_id=(select id from ct where name=:bayId)) and"
			+ " (:waterId is null or Data.water_id=(select id from water where type = :waterId)) and"
			+ " (:elementId is null or Data.element_id=(select id from element where name = :elementId)) "
			+ " group by timeCreated, Data.CT_id, Data.water_id, Data.element_id ";
	//+ " DATE_FORMAT(created_time, '%m-%d-%Y') order by DATE_FORMAT(created_time, '%m-%d-%Y') desc";

	private static final String FIND_BY_FILTER_MONTHLY_GROUPID = "select Data.id, User.name as userId, Bay.name as bayId, Water.type as waterId, Element.name as elementId,  "
			+ " avg(element_value) as elementValue, criteria, STR_TO_DATE(DATE_FORMAT(Data.created_time, '%Y-%m'), '%Y-%m-%d %H:%i') as timeCreated, "
			+ " STR_TO_DATE(DATE_FORMAT(Data.updated_time, '%Y-%m'),'%Y-%m-%d %H:%i') as timeUpdated "
			+ " FROM clair_data AS Data "
			+ " LEFT OUTER JOIN user AS User ON Data.user_id = User.id "
			+ " LEFT OUTER JOIN ct AS Bay ON Data.CT_id = Bay.id "
			+ " LEFT OUTER JOIN water AS Water ON Data.water_id = Water.id "
			+ " LEFT OUTER JOIN element AS Element ON Data.element_id = Element.id "
			+ " WHERE DATE_FORMAT( Data.created_time,  '%Y-%m-%d %H:%i:%s' ) between :startDate and :endDate and"
			+ " Data.group_id=:groupId and (:bayId is null or Data.CT_id=(select id from ct where name=:bayId)) and"
			+ " (:waterId is null or Data.water_id=(select id from water where type = :waterId)) and"
			+ " (:elementId is null or Data.element_id=(select id from element where name = :elementId)) "
			+ " group by timeCreated, Data.CT_id, Data.water_id, Data.element_id ";

	private static final String FIND_BY_FILTER_DAILY_USERID = "select Data.id, User.name as userId, Bay.name as bayId, Water.type as waterId, Element.name as elementId,  "
			+ " avg(element_value) as elementValue, criteria, STR_TO_DATE(DATE_FORMAT(Data.created_time, '%Y-%m-%d'), '%Y-%m-%d %H:%i') as timeCreated, "
			+ " STR_TO_DATE(DATE_FORMAT(Data.updated_time, '%Y-%m-%d'),'%Y-%m-%d %H:%i') as timeUpdated "
			+ " FROM clair_data AS Data "
			+ " LEFT OUTER JOIN user AS User ON Data.user_id = User.id "
			+ " LEFT OUTER JOIN ct AS Bay ON Data.CT_id = Bay.id "
			+ " LEFT OUTER JOIN water AS Water ON Data.water_id = Water.id "
			+ " LEFT OUTER JOIN element AS Element ON Data.element_id = Element.id "
			+ " WHERE DATE_FORMAT( Data.created_time,  '%Y-%m-%d %H:%i:%s' ) between :startDate and :endDate and"
			+ " Data.user_id=:userId and (:bayId is null or Data.CT_id=(select id from ct where name=:bayId)) and"
			+ " (:waterId is null or Data.water_id=(select id from water where type = :waterId)) and"
			+ " (:elementId is null or Data.element_id=(select id from element where name = :elementId)) "
			+ " group by timeCreated, Data.CT_id, Data.water_id, Data.element_id ";
	//+ " DATE_FORMAT(created_time, '%m-%d-%Y') order by DATE_FORMAT(created_time, '%m-%d-%Y') desc";

	private static final String FIND_BY_FILTER_DAILY_GROUPID = "select Data.id, User.name as userId, Bay.name as bayId, Water.type as waterId, Element.name as elementId,  "
			+ " avg(element_value) as elementValue, criteria, STR_TO_DATE(DATE_FORMAT(Data.created_time, '%Y-%m-%d'), '%Y-%m-%d %H:%i') as timeCreated, "
			+ " STR_TO_DATE(DATE_FORMAT(Data.updated_time, '%Y-%m-%d'),'%Y-%m-%d %H:%i') as timeUpdated "
			+ " FROM clair_data AS Data "
			+ " LEFT OUTER JOIN user AS User ON Data.user_id = User.id "
			+ " LEFT OUTER JOIN ct AS Bay ON Data.CT_id = Bay.id "
			+ " LEFT OUTER JOIN water AS Water ON Data.water_id = Water.id "
			+ " LEFT OUTER JOIN element AS Element ON Data.element_id = Element.id "
			+ " WHERE DATE_FORMAT( Data.created_time,  '%Y-%m-%d %H:%i:%s' ) between :startDate and :endDate and"
			+ " Data.group_id=:groupId and (:bayId is null or Data.CT_id=(select id from ct where name=:bayId)) and"
			+ " (:waterId is null or Data.water_id=(select id from water where type = :waterId)) and"
			+ " (:elementId is null or Data.element_id=(select id from element where name = :elementId)) "
			+ " group by timeCreated, Data.CT_id, Data.water_id, Data.element_id ";

	private static final String FIND_BY_FILTER_HOURLY_USERID = "select Data.id, User.name as userId, Bay.name as bayId, Water.type as waterId, Element.name as elementId,  "
			+ " avg(element_value) as elementValue, criteria, STR_TO_DATE(DATE_FORMAT(Data.created_time, '%Y-%m-%d %H'), '%Y-%m-%d %H:%i') as timeCreated, "
			+ " STR_TO_DATE(DATE_FORMAT(Data.updated_time, '%Y-%m-%d %H'),'%Y-%m-%d %H:%i') as timeUpdated "
			+ " FROM clair_data AS Data "
			+ " LEFT OUTER JOIN user AS User ON Data.user_id = User.id "
			+ " LEFT OUTER JOIN ct AS Bay ON Data.CT_id = Bay.id "
			+ " LEFT OUTER JOIN water AS Water ON Data.water_id = Water.id "
			+ " LEFT OUTER JOIN element AS Element ON Data.element_id = Element.id "
			+ " WHERE DATE_FORMAT( Data.created_time,  '%Y-%m-%d %H:%i:%s' ) between :startDate and :endDate and"
			+ " Data.user_id=:userId and (:bayId is null or Data.CT_id=(select id from ct where name=:bayId)) and"
			+ " (:waterId is null or Data.water_id=(select id from water where type = :waterId)) and"
			+ " (:elementId is null or Data.element_id=(select id from element where name = :elementId)) "
			+ " group by timeCreated, Data.CT_id, Data.water_id, Data.element_id ";

	private static final String FIND_BY_FILTER_HOURLY_GROUPID = "select Data.id, User.name as userId, Bay.name as bayId, Water.type as waterId, Element.name as elementId,  "
			+ " avg(element_value) as elementValue, criteria, STR_TO_DATE(DATE_FORMAT(Data.created_time, '%Y-%m-%d %H'), '%Y-%m-%d %H:%i') as timeCreated, "
			+ " STR_TO_DATE(DATE_FORMAT(Data.updated_time, '%Y-%m-%d %H'),'%Y-%m-%d %H:%i') as timeUpdated "
			+ " FROM clair_data AS Data "
			+ " LEFT OUTER JOIN user AS User ON Data.user_id = User.id "
			+ " LEFT OUTER JOIN ct AS Bay ON Data.CT_id = Bay.id "
			+ " LEFT OUTER JOIN water AS Water ON Data.water_id = Water.id "
			+ " LEFT OUTER JOIN element AS Element ON Data.element_id = Element.id "
			+ " WHERE DATE_FORMAT( Data.created_time,  '%Y-%m-%d %H:%i:%s' ) between :startDate and :endDate and"
			+ " Data.group_id=:groupId and (:bayId is null or Data.CT_id=(select id from ct where name=:bayId)) and"
			+ " (:waterId is null or Data.water_id=(select id from water where type = :waterId)) and"
			+ " (:elementId is null or Data.element_id=(select id from element where name = :elementId)) "
			+ " group by timeCreated, Data.CT_id, Data.water_id, Data.element_id ";

	private static final String INSERT_WRMDATA = "insert into clair_data (user_id, ct_id, water_id, element_id, element_value,"
			+ " criteria, created_time, updated_time, group_id, bay_id) values "
			+ "((select id as userData from user where user.first_name = :userId and group_id = :groupId),"
			+"(select id from ct where name = :ctId and group_id = :groupId), "
			+"(select water_id from ct_water_association as ct_wt_asc "
			+ " LEFT OUTER JOIN ct as Bay on Bay.name = :ctId "
			+ "LEFT OUTER JOIN water as Water on Water.type = :waterId where ct_wt_asc.CT_id = Bay.id and ct_wt_asc.water_id = Water.id),"
			+"(select element_id from water_element_association as wt_elem_asc "
			+ "LEFT OUTER JOIN water as Water on Water.type = :waterId "
			+ "LEFT OUTER JOIN element as Element on Element.name = :elementId "
			+ "where wt_elem_asc.water_id = Water.id and wt_elem_asc.element_id = Element.id), "
			+ ":elementValue, :criteria, :timeCreated, :timeUpdated, :groupId, :bayId)";

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
	public List<WrmData> findByFiltersHourly(String groupId, String userId, String bayId, String waterId, String elementId, String startDate, String endDate, Boolean category) {
		if (category) {
			List<WrmData> entities = (List<WrmData>) getCurrentSessionWithTransaction().createSQLQuery(FIND_BY_FILTER_HOURLY_GROUPID)
					.setParameter("groupId", groupId)
					.setParameter("bayId", bayId)
					.setParameter("waterId", waterId)
					.setParameter("elementId", elementId)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate)
					.setResultTransformer(Transformers.aliasToBean(WrmData.class))
					.list();
			return entities;

		} else {
			List<WrmData> entities = (List<WrmData>) getCurrentSessionWithTransaction().createSQLQuery(FIND_BY_FILTER_HOURLY_USERID)
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
	}

	@SuppressWarnings("unchecked")
	public List<WrmData> findByFiltersDaily(String groupId, String userId, String bayId, String waterId, String elementId, String startDate, String endDate, Boolean category) {
		if(category) {
			List<WrmData> entities = (List<WrmData>) getCurrentSessionWithTransaction().createSQLQuery(FIND_BY_FILTER_DAILY_GROUPID)
					.setParameter("groupId", groupId)
					.setParameter("bayId", bayId)
					.setParameter("waterId", waterId)
					.setParameter("elementId", elementId)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate)
					.setResultTransformer(Transformers.aliasToBean(WrmData.class))
					.list();
			return entities;
		} else {
			List<WrmData> entities = (List<WrmData>) getCurrentSessionWithTransaction().createSQLQuery(FIND_BY_FILTER_DAILY_USERID)
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
	}

	@SuppressWarnings("unchecked")
	public List<WrmData> findByFiltersMonthly(String groupId, String userId, String bayId, String waterId, String elementId, String startDate, String endDate, Boolean category) {
		if(category) {
			List<WrmData> entities = (List<WrmData>) getCurrentSessionWithTransaction().createSQLQuery(FIND_BY_FILTER_MONTHLY_GROUPID)
					.setParameter("groupId", groupId)
					.setParameter("bayId", bayId)
					.setParameter("waterId", waterId)
					.setParameter("elementId", elementId)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate)
					.setResultTransformer(Transformers.aliasToBean(WrmData.class))
					.list();
			return entities;
		} else {
			List<WrmData> entities = (List<WrmData>) getCurrentSessionWithTransaction().createSQLQuery(FIND_BY_FILTER_MONTHLY_USERID)
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
	}

	@SuppressWarnings("unchecked")
	public List<WrmData> findByFiltersYearly(String groupId, String userId, String bayId, String waterId, String elementId, String startDate, String endDate, Boolean category) {
		if(category) {
			List<WrmData> entities = (List<WrmData>) getCurrentSessionWithTransaction().createSQLQuery(FIND_BY_FILTER_YEARLY_GROUPID)
					.setParameter("groupId", groupId)
					.setParameter("bayId", bayId)
					.setParameter("waterId", waterId)
					.setParameter("elementId", elementId)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate)
					.setResultTransformer(Transformers.aliasToBean(WrmData.class))
					.list();
			return entities;
		} else {
			List<WrmData> entities = (List<WrmData>) getCurrentSessionWithTransaction().createSQLQuery(FIND_BY_FILTER_YEARLY_USERID)
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
	}

	@SuppressWarnings("unchecked")
	public void insertWrmData(WrmData entity) {
		System.out.println(entity.toString());
		getCurrentSessionWithTransaction().createSQLQuery(INSERT_WRMDATA)
		//.setParameter("id",entity.getId())
		.setParameter("ctId",entity.getCtId())
		.setParameter("userId",entity.getUserId())
		.setParameter("waterId",entity.getWaterId())
		.setString("elementId",entity.getElementId())
		.setParameter("elementValue",entity.getElementValue())
		.setParameter("criteria",entity.getCriteria())
		.setParameter("timeCreated",entity.getTimeCreated())
		.setParameter("timeUpdated",entity.getTimeUpdated())
		.setParameter("groupId",entity.getGroupId())
		.setParameter("bayId",null)
		.executeUpdate();

	}

	@Override
	public void deleteAll() {
		// Method not implemented, Not sure
	}
}

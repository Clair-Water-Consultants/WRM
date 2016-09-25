package com.wrm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.Transformers;

import com.wrm.dao.DaoImpl;
import com.wrm.dao.DaoInterface;
import com.wrm.dao.model.Bay;
import com.wrm.dao.model.WrmData;
import com.wrm.model.BayWaterElementsResponse;

public class BayDaoImpl extends DaoImpl implements DaoInterface<Bay, String> {

	private static final String FIND_ALL_BAYS = "from Bay";

	private static final String FIND_ALL_BY_GROUPID = "from Bay where group_id=:groupId";
	
	private static final String FIND_ALL_ASSOCIATIONS_BY_GROUPID = 
			"select Bay.name as ctId, Water.type as waterId, Element.name as elementId"
          + " from ct_water_association as ct_wt_assoc"
          + " LEFT OUTER JOIN ct as Bay on ct_wt_assoc.CT_ID = Bay.id and Bay.group_id = :groupId "
          + " LEFT OUTER JOIN water as Water on ct_wt_assoc.WATER_ID = Water.id "
          + " LEFT OUTER JOIN water_element_association as wt_elem_assoc on ct_wt_assoc.WATER_ID = wt_elem_assoc.water_id "
          + " LEFT OUTER JOIN element as Element on wt_elem_assoc.element_id = Element.id"
          + " where group_id = :groupId ";

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
	
	@SuppressWarnings("unchecked")
	public List<BayWaterElementsResponse> findAllAssocByGroupId(String groupId) {
		List<BayWaterElementsResponse> entities = (List<BayWaterElementsResponse>) getCurrentSessionWithTransaction().createSQLQuery(FIND_ALL_ASSOCIATIONS_BY_GROUPID)
				.setParameter("groupId", groupId)
				.setResultTransformer(Transformers.aliasToBean(BayWaterElementsResponse.class))
				.list();
		return entities;
	}
}

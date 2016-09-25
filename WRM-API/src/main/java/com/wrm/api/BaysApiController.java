package com.wrm.api;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.wrm.dao.DaoInterface;
import com.wrm.dao.impl.BayDaoImpl;
import com.wrm.dao.impl.WrmDataDaoImpl;
import com.wrm.dao.model.Bay;
import com.wrm.dao.model.WrmData;
import com.wrm.model.BayListResponse;
import com.wrm.model.BayPostResponse;
import com.wrm.model.BayRequest;
import com.wrm.model.BayResponse;
import com.wrm.model.BayWaterElementsListResponse;
import com.wrm.model.BayWaterElementsResponse;
import com.wrm.model.WRMDataListResponse;
import com.wrm.model.WRMDataResponse;
import com.wrm.model.WRMDataTime;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

@Controller
public class BaysApiController implements BaysApi {

	public ResponseEntity<BayListResponse> baysGet() {

		BayListResponse responseList = new BayListResponse();
		try {
			DaoInterface<Bay, ?> dao = new BayDaoImpl();
			List<Bay> bayList = dao.findAll();
			for (Bay b : bayList) {
				BayResponse response = new BayResponse();
				response.setId(b.getId());
				response.setGroupId(b.getGroupId());
				response.setName(b.getName());
				responseList.addBaysItem(response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return ResponseEntity.ok(responseList);
	}

	public ResponseEntity<BayPostResponse> baysPost(

			@ApiParam(value = "request object of the bay", required = true) @RequestBody BayRequest body

	) {
		Date date = Calendar.getInstance().getTime();
		Bay b = new Bay();
		b.setId(UUID.randomUUID().toString());
		b.setName(body.getName());
		b.setGroupId(body.getGroupId());
		b.setCreatedTime(date);
		b.setUpdatedTime(date);
		BayDaoImpl daoInterface = new BayDaoImpl();
		daoInterface.persist(b);
		BayDaoImpl.closeCurrentSessionWithTransaction();
		return ResponseEntity.ok(new BayPostResponse(b.getId()));
	}


	public ResponseEntity<BayWaterElementsListResponse> watertypesGet(
			@ApiParam(value = "", required = true) @PathVariable("groupId") String groupId) {
		System.out.println("GroupID = " + groupId);
		BayDaoImpl bayDao = new BayDaoImpl();
		List<BayWaterElementsResponse> assocList = new ArrayList<BayWaterElementsResponse>();
				assocList = bayDao.findAllAssocByGroupId(groupId);

		BayWaterElementsListResponse response = new BayWaterElementsListResponse();
		for (BayWaterElementsResponse w : assocList) {
			System.out.println(w);
			response.addAssocItem(w);
		}
		return ResponseEntity.ok(response);
	}
}

package com.wrm.api;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.wrm.dao.impl.WrmDataDaoImpl;
import com.wrm.dao.model.WrmData;
import com.wrm.model.WRMDataListResponse;
import com.wrm.model.WRMDataPostResponse;
import com.wrm.model.WRMDataRequest;
import com.wrm.model.WRMDataResponse;
import com.wrm.model.WRMDataTime;
import com.wrm.security.SecurityHelper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

@Controller
public class WrmdataApiController implements WrmdataApi {

	public ResponseEntity<WRMDataListResponse> wrmdataGroupIdGet(
			@ApiParam(value = "", required = true) @PathVariable("groupId") String groupId

			,@ApiParam(value = "", required = true) @RequestParam("userId") String userId

			, @ApiParam(value = "", required = true) @RequestParam(value = "elementId", required = true) String elementId

			, @ApiParam(value = "", required = true) @RequestParam(value = "ctId", required = true) String ctId

			, @ApiParam(value = "", required = true) @RequestParam(value = "waterId", required = true) String waterId

			, @ApiParam(value = "") @RequestParam(value = "granularity", required = false) String granularity

			, @ApiParam(value = "") @RequestParam(value = "timeperiod", required = false) String timeperiod

			, @ApiParam(value = "0") @RequestParam(value = "category", required = true) String category

			) {
		System.out.println("GroupID = " + groupId + "UserID= " + userId + "ElementID= " + elementId + "WaterID= "+ waterId
				+ "CTID= " + ctId + "Granularity= " + granularity + "timeperiod= "+ timeperiod);
		WrmDataDaoImpl wrmDao = new WrmDataDaoImpl();
		// Granularity switch case
		String startDate = null;
		String endDate = null;
		Date endCal = Calendar.getInstance().getTime();
		List<WrmData> wrmList = new ArrayList<WrmData>();
		if(elementId.equalsIgnoreCase("ALL")) { elementId = null;}
		if(ctId.equalsIgnoreCase("ALL")) {ctId = null;}
		if(waterId.equalsIgnoreCase("ALL")) { waterId = null;}
		if (granularity != null && !granularity.equals("")) {
			if (granularity.equalsIgnoreCase("hourly")) {
				System.out.println("Inside hourly...");
				timeperiod = (timeperiod != null && !timeperiod.equalsIgnoreCase("")) ? timeperiod : Constants.DEFAULT_HOURS_TIMEPERIOD;
				Calendar startCal = Calendar.getInstance();
				startCal.add(Calendar.HOUR_OF_DAY, (Constants.MINUS_ONE * Integer.valueOf(timeperiod)));
				startDate = Constants.sdf.format(startCal.getTime());
				endDate = Constants.sdf.format(endCal.getTime());
				wrmList = wrmDao.findByFiltersHourly(groupId, userId, ctId, waterId, elementId, startDate, Constants.sdf.format(endCal), Boolean.parseBoolean(category));
			} else if (granularity.equalsIgnoreCase("daily")) {
				System.out.println("Inside daily...");
				timeperiod = (timeperiod != null && !timeperiod.equalsIgnoreCase("")) ? timeperiod : Constants.DEFAULT_DAYS_TIMEPERIOD;
				Calendar startCal = Calendar.getInstance();
				startCal.add(Calendar.DAY_OF_MONTH, (Constants.MINUS_ONE * Integer.valueOf(timeperiod)));
				startDate = Constants.sdf.format(startCal.getTime());
				endDate = Constants.sdf.format(endCal.getTime());
				wrmList = wrmDao.findByFiltersDaily(groupId, userId, ctId, waterId, elementId, startDate, Constants.sdf.format(endCal), Boolean.parseBoolean(category));
			} else if (granularity.equalsIgnoreCase("yearly") || granularity.equalsIgnoreCase("monthly")) {
				System.out.println("Inside yearly...");
				timeperiod = (timeperiod != null && !timeperiod.equalsIgnoreCase("")) ? timeperiod : Constants.DEFAULT_YEARLY_TIMEPERIOD;
				Calendar startCal = Calendar.getInstance();
				startCal.add(Calendar.MONTH, (Constants.MINUS_ONE * Integer.valueOf(timeperiod)));
				startDate = Constants.sdf.format(startCal.getTime());
				endDate = Constants.sdf.format(endCal.getTime());
				wrmList = wrmDao.findByFiltersMonthly(groupId, userId, ctId, waterId, elementId, startDate, Constants.sdf.format(endCal), Boolean.parseBoolean(category));

			}
		} else {
			System.out.println("Inside else loop...");
			//by default hourly data
			timeperiod = (timeperiod != null && !timeperiod.equalsIgnoreCase("")) ? timeperiod : Constants.DEFAULT_HOURS_TIMEPERIOD;
			Calendar startCal = Calendar.getInstance();
			startCal.add(Calendar.HOUR_OF_DAY, (-1 * Integer.valueOf(timeperiod)));
			startDate = Constants.sdf.format(startCal.getTime());
			endDate = Constants.sdf.format(endCal.getTime());
			wrmList = wrmDao.findByFiltersHourly(groupId, userId, ctId, waterId, elementId, startDate, Constants.sdf.format(endCal), Boolean.parseBoolean(category));
		}
		System.out.println("START DATE :: " + startDate);
		System.out.println("END DATE :: " + endDate);

		WRMDataListResponse response = new WRMDataListResponse();
		HashMap <Date,HashMap <String, WRMDataTime> > dataMap = new HashMap<>();
		for (WrmData w : wrmList) {
			System.out.println(w);
			WRMDataResponse wrmResponse = new WRMDataResponse();
			BeanUtils.copyProperties(w, wrmResponse);
			wrmResponse.setGroupId(groupId);
			response.addWrmdataItem(wrmResponse);
			//			transformData(wrmResponse, dataMap);
		}
		return ResponseEntity.ok(response);
	}

	public ResponseEntity<WRMDataPostResponse> wrmdataPost(HttpServletRequest req,

			@ApiParam(value = "request object of the wrmdata type", required = true) @Valid @RequestBody WRMDataRequest body

			) {
		
		System.out.println("body : " + body.toString());
		
		Cookie currentCookie = null;
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equalsIgnoreCase(SecurityHelper.WRM_COOKIE_NAME)) {
					currentCookie = c;
					break;
				}
			}
		}
		
		if(currentCookie == null) {
			return new ResponseEntity<WRMDataPostResponse>(HttpStatus.UNAUTHORIZED);
		}
		
		String sessionToken = SecurityHelper.parseSessionToken(currentCookie.getValue());
		String[] creds = sessionToken.split("\\|");
		String userId = creds[0];
		String groupId = creds[1];
	
		WrmData daoModel = new WrmData();
		BeanUtils.copyProperties(body, daoModel);
		if(daoModel.getCtId() == null || daoModel.getElementId() == null || 
				daoModel.getUserId() == null || daoModel.getWaterId() == null ||
				daoModel.getGroupId() == null) {
			return new ResponseEntity<WRMDataPostResponse>(HttpStatus.BAD_REQUEST);
		}
		daoModel.setTimeCreated(new Date());
		daoModel.setUserId(userId);
		daoModel.setGroupId(groupId);
		daoModel.setTimeUpdated(new Date());
		WrmDataDaoImpl dao = new WrmDataDaoImpl();
		//dao.persist(daoModel);
		dao.insertWrmData(daoModel);
		//WrmDataDaoImpl.closeCurrentSessionWithTransaction();
		return ResponseEntity.ok(new WRMDataPostResponse("Success"));
	}

}

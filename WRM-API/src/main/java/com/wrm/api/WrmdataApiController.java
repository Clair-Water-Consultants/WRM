package com.wrm.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

@Controller
public class WrmdataApiController implements WrmdataApi {

	public ResponseEntity<WRMDataListResponse> wrmdataGroupIdGet(
			@ApiParam(value = "", required = true) @PathVariable("groupId") String groupId

	, @ApiParam(value = "", required = true) @RequestParam("userId") String userId

	, @ApiParam(value = "", required = true) @RequestParam(value = "elementId", required = true) String elementId

	, @ApiParam(value = "", required = true) @RequestParam(value = "ctId", required = true) String ctId

	, @ApiParam(value = "", required = true) @RequestParam(value = "waterId", required = true) String waterId

	, @ApiParam(value = "") @RequestParam(value = "granularity", required = false) String granularity

	, @ApiParam(value = "") @RequestParam(value = "timeperiod", required = false) String timeperiod

	) {
		
		WrmDataDaoImpl wrmDao = new WrmDataDaoImpl();
		// Granularity switch case
		String startDate = null;
		String endDate = null;
		Date endCal = Calendar.getInstance().getTime();
		List<WrmData> wrmList = new ArrayList<WrmData>();
		if (granularity != null && granularity.equals("")) {
			if (granularity.equalsIgnoreCase("hourly")) {
				timeperiod = (timeperiod != null && timeperiod.equalsIgnoreCase("")) ? timeperiod : Constants.DEFAULT_HOURS_TIMEPERIOD;
				Calendar startCal = Calendar.getInstance();
				startCal.add(Calendar.HOUR_OF_DAY, (Constants.MINUS_ONE * Integer.valueOf(Constants.DEFAULT_HOURS_TIMEPERIOD)));
				startDate = Constants.sdf.format(startCal.getTime());
				wrmList = wrmDao.findByFiltersHourly(userId, ctId, waterId, elementId, startDate, Constants.sdf.format(endCal));
			} else if (granularity.equalsIgnoreCase("daily")) {
				timeperiod = (timeperiod != null && timeperiod.equalsIgnoreCase("")) ? timeperiod : Constants.DEFAULT_DAYS_TIMEPERIOD;
				Calendar startCal = Calendar.getInstance();
				startCal.add(Calendar.DAY_OF_MONTH, (Constants.MINUS_ONE * Integer.valueOf(timeperiod)));
				startDate = Constants.sdf.format(startCal.getTime());
				wrmList = wrmDao.findByFiltersDaily(userId, ctId, waterId, elementId, startDate, Constants.sdf.format(endCal));
			}
		} else {
			//by default hourly data
			timeperiod = (timeperiod != null && timeperiod.equalsIgnoreCase("")) ? timeperiod : Constants.DEFAULT_HOURS_TIMEPERIOD;
			Calendar startCal = Calendar.getInstance();
			startCal.add(Calendar.HOUR_OF_DAY, (-1 * Integer.valueOf(timeperiod)));
			startDate = Constants.sdf.format(startCal.getTime());
			wrmList = wrmDao.findByFiltersHourly(userId, ctId, waterId, elementId, startDate, Constants.sdf.format(endCal));
		}
		System.out.println("START DATE :: " + startDate);
		System.out.println("END DATE :: " + endDate);

		WRMDataListResponse response = new WRMDataListResponse();
		for (WrmData w : wrmList) {
			System.out.println(w);
			WRMDataResponse wrmResponse = new WRMDataResponse();
			BeanUtils.copyProperties(w, wrmResponse);
			wrmResponse.setGroupId(groupId);
			response.addWrmdataItem(wrmResponse);
		}
		return ResponseEntity.ok(response);
	}

	public ResponseEntity<WRMDataPostResponse> wrmdataPost(

			@ApiParam(value = "request object of the wrmdata type", required = true) @Valid @RequestBody WRMDataRequest body

	) {
		WrmData daoModel = new WrmData();
		BeanUtils.copyProperties(body, daoModel);
		try {
			daoModel.setTimeCreated(Constants.sdf.parse(body.getTimeCreated()));
		} catch (ParseException e) {
			daoModel.setTimeCreated(new Date());
		}
		WrmDataDaoImpl dao = new WrmDataDaoImpl();
		dao.persist(daoModel);
		WrmDataDaoImpl.closeCurrentSessionWithTransaction();
		return ResponseEntity.ok(new WRMDataPostResponse("Success"));
	}

}

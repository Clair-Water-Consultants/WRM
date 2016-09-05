package com.wrm.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

@Controller
public class WrmdataApiController implements WrmdataApi {

	public ResponseEntity<WRMDataListResponse> wrmdataGroupIdGet(
			@ApiParam(value = "", required = true) @PathVariable("userId") String userId

	, @ApiParam(value = "", required = true) @RequestParam(value = "elementId", required = true) String elementId

	, @ApiParam(value = "", required = true) @RequestParam(value = "ctId", required = true) String ctId
	
	, @ApiParam(value = "", required = true) @RequestParam(value = "waterId", required = true) String waterId

	, @ApiParam(value = "") @RequestParam(value = "granularity", required = false) String granularity

	, @ApiParam(value = "") @RequestParam(value = "timeperiod", required = false) String timeperiod

	) {
		WrmDataDaoImpl wrmDao = new WrmDataDaoImpl();
		List<WrmData> wrmList = wrmDao.findByFilters(userId, ctId, waterId, elementId, Integer.valueOf(timeperiod));
		WRMDataListResponse response = new WRMDataListResponse();
		for(WrmData w : wrmList) {
			WRMDataResponse wrmResponse = new WRMDataResponse();
			BeanUtils.copyProperties(w, wrmResponse);
			response.addWrmdataItem(wrmResponse);
		}
		return ResponseEntity.ok(response);
	}

	public ResponseEntity<WRMDataPostResponse> wrmdataPost(

			@ApiParam(value = "request object of the wrmdata type", required = true) @Valid @RequestBody WRMDataRequest body

	) {
		String formatter = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		WrmData daoModel = new WrmData();
		BeanUtils.copyProperties(body, daoModel);
		try {
			daoModel.setTimeCreated(sdf.parse(body.getTimeCreated()));
		} catch (ParseException e) {
			daoModel.setTimeCreated(new Date());
		}
		WrmDataDaoImpl dao = new WrmDataDaoImpl();
		dao.persist(daoModel);
		WrmDataDaoImpl.closeCurrentSessionWithTransaction();
		return ResponseEntity.ok(new WRMDataPostResponse("Success"));
	}

}

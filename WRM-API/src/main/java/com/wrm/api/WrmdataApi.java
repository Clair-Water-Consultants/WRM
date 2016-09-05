package com.wrm.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wrm.model.WRMDataListResponse;
import com.wrm.model.WRMDataPostResponse;
import com.wrm.model.WRMDataRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

@Api(value = "wrmdata", description = "the wrmdata API")
public interface WrmdataApi {

	@ApiOperation(value = "WRM Data to be retrieved", notes = "Obtain the history of WRM data for a given groupid, userid and chemical id for a given period of time and granularity ", response = WRMDataListResponse.class, tags = {
			"WRMData", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "An array of WRM Data", response = WRMDataListResponse.class),
			@ApiResponse(code = 200, message = "upon error", response = WRMDataListResponse.class) })
	@RequestMapping(value = "/wrmdata/{groupId}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<WRMDataListResponse> wrmdataGroupIdGet(
			@ApiParam(value = "", required = true) @PathVariable("groupId") String groupId

	, @ApiParam(value = "", required = true) @RequestParam("userId") String userId

	, @ApiParam(value = "", required = true) @RequestParam(value = "elementId", required = true) String elementId

	, @ApiParam(value = "", required = true) @RequestParam(value = "ctId", required = true) String ctId

	, @ApiParam(value = "", required = true) @RequestParam(value = "waterId", required = true) String waterId

	, @ApiParam(value = "") @RequestParam(value = "granularity", required = false) String granularity

	, @ApiParam(value = "") @RequestParam(value = "timeperiod", required = false) String timeperiod

	);

	@ApiOperation(value = "Add a wrm data type", notes = "This endpint adds a new wrm data type to the system. It accepts a json which would include wrm data type name, description and would return a unique identifier of the wrm data type upon success ", response = WRMDataPostResponse.class, tags = {
			"WRMData", })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "upon successful creation of a wrmdata type", response = WRMDataPostResponse.class),
			@ApiResponse(code = 200, message = "upon error", response = WRMDataPostResponse.class) })
	@RequestMapping(value = "/wrmdata", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<WRMDataPostResponse> wrmdataPost(

			@ApiParam(value = "request object of the wrmdata type", required = true) @RequestBody WRMDataRequest body

	);

}

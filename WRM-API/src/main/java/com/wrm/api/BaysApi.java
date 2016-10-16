package com.wrm.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wrm.model.BayListResponse;
import com.wrm.model.BayPostResponse;
import com.wrm.model.BayRequest;
import com.wrm.model.BayWaterElementsListResponse;
import com.wrm.model.WaterTypeListResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

@Api(value = "bays", description = "the bays API")
public interface BaysApi {

    @ApiOperation(value = "Bays", notes = "The elements enpoint returns the list of bays per group in the system. The response would include unique identifier of the bay, bay name, group id of the group the bay belongs ", response = BayListResponse.class, tags={ "Bays", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of elements", response = BayListResponse.class),
        @ApiResponse(code = 200, message = "upon error", response = BayListResponse.class) })
    @RequestMapping(value = "/bays",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<BayListResponse> baysGet();

	@ApiOperation(value = "Bay -> Water -> Elements Associaton", notes = "The enpoint returns the list of bays, their water types and associated elements in the system. The response would include unique identifier of the type, the type and description of the water type ", response = BayWaterElementsListResponse.class, tags = {
			"BayWaterElements", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "An array of elements", response = BayWaterElementsListResponse.class),
			@ApiResponse(code = 200, message = "upon error", response = WaterTypeListResponse.class) })
	@RequestMapping(value = "/association", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<BayWaterElementsListResponse> watertypesGet(
			@ApiParam(value = "", required = true) @PathVariable("Id") String Id,
			@ApiParam(value = "", required = false) @RequestParam("category") String category

	);

    @ApiOperation(value = "Add a bay", notes = "This endpint adds a new bay to the system. It accepts a json which would include bay name, group id and would return a unique identifier of the bay upon success ", response = BayPostResponse.class, tags={ "Bays", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "upon successful creation of a bay", response = BayPostResponse.class),
        @ApiResponse(code = 200, message = "upon error", response = BayPostResponse.class) })
    @RequestMapping(value = "/bays",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<BayPostResponse> baysPost(

@ApiParam(value = "request object of the bay" ,required=true ) @RequestBody BayRequest body

);

}

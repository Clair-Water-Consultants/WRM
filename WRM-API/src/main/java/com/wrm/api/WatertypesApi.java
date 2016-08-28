package com.wrm.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wrm.model.WaterPostResponse;
import com.wrm.model.WaterRequest;
import com.wrm.model.WaterTypeListResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

@Api(value = "watertypes", description = "the watertypes API")
public interface WatertypesApi {

    @ApiOperation(value = "Water types available", notes = "The elements enpoint returns the list of water types in the system. The response would include unique identifier of the type, the type and description of the water type ", response = WaterTypeListResponse.class, tags={ "WaterTypes", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of elements", response = WaterTypeListResponse.class),
        @ApiResponse(code = 200, message = "upon error", response = WaterTypeListResponse.class) })
    @RequestMapping(value = "/watertypes",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<WaterTypeListResponse> watertypesGet(@ApiParam(value = "", required = true) @RequestParam(value = "groupId", required = true) String groupId



,@ApiParam(value = "", required = true) @RequestParam(value = "bayId", required = true) String bayId



);


    @ApiOperation(value = "Add a water type", notes = "This endpint adds a new water type to the system. It accepts a json which would include water type name, description and would return a unique identifier of the water type upon success ", response = WaterPostResponse.class, tags={ "WaterTypes", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "upon successful creation of a water type", response = WaterPostResponse.class),
        @ApiResponse(code = 200, message = "upon error", response = WaterPostResponse.class) })
    @RequestMapping(value = "/watertypes",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<WaterPostResponse> watertypesPost(

@ApiParam(value = "request object of the water type" ,required=true ) @RequestBody WaterRequest body

);

}

package com.wrm.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wrm.model.CompanyGroupPostResponse;
import com.wrm.model.CompanyGroupRequest;
import com.wrm.model.UserPostResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-04T10:25:35.178Z")

@Api(value = "companygroup", description = "the companygroup API")
public interface CompanyGroupApi {

	@ApiOperation(value = "Add a user", notes = "This endpoint adds a new user to the user table ", response = UserPostResponse.class, tags={ "User", })
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "upon successful creation of a user", response = UserPostResponse.class),
			@ApiResponse(code = 200, message = "upon error", response = UserPostResponse.class) })
	@RequestMapping(value = "/company",
	produces = { "application/json" }, 
	consumes = { "application/json" },
	method = RequestMethod.POST)
	ResponseEntity<CompanyGroupPostResponse> companyPost(

			@ApiParam(value = "request object of an element" ,required=true ) @RequestBody CompanyGroupRequest body

			);

}

package com.wrm.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wrm.model.UserListResponse;
import com.wrm.model.UserPostResponse;
import com.wrm.model.UserRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-04T10:25:35.178Z")

@Api(value = "user", description = "the user API")
public interface UserApi {

    @ApiOperation(value = "WRM user table get request", notes = "This end point is used to perform user related activities of WRM ", response = UserListResponse.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of users", response = UserListResponse.class),
        @ApiResponse(code = 200, message = "upon error", response = UserListResponse.class) })
    @RequestMapping(value = "/user",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<UserListResponse> userGet(
    		@ApiParam(value = "", required = true) @RequestParam(value = "groupId", required = true) String groupId,
    		@ApiParam(value = "", required = true) @RequestParam(value = "userId", required = true) String userId
    		);
    
    @ApiOperation(value = "WRM user table get request", notes = "This end point is used to perform user related activities of WRM ", response = UserListResponse.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of users", response = UserListResponse.class),
        @ApiResponse(code = 200, message = "upon error", response = UserListResponse.class) })
    @RequestMapping(value = "/userDetails",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<UserListResponse> userDetailsGet(HttpServletRequest req);
    
    @ApiOperation(value = "WRM user find All get request", notes = "This end point is used to perform user related activities of WRM ", response = UserListResponse.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of users", response = UserListResponse.class),
        @ApiResponse(code = 200, message = "upon error", response = UserListResponse.class) })
    @RequestMapping(value = "/user/all",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<UserListResponse> userGetAll(
    		@ApiParam(value = "", required = true) @RequestParam(value = "groupId", required = true) String groupId
    		);
    		


    @ApiOperation(value = "Add a user", notes = "This endpoint adds a new user to the user table ", response = UserPostResponse.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "upon successful creation of a user", response = UserPostResponse.class),
        @ApiResponse(code = 200, message = "upon error", response = UserPostResponse.class) })
    @RequestMapping(value = "/user",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<UserPostResponse> userPost(

@ApiParam(value = "request object of an element" ,required=true ) @RequestBody UserRequest body

);
    @ApiOperation(value = "Authenticate a user", notes = "This endpoint adds authenticates a user of a given group", response = UserPostResponse.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "upon successful authentication of a user", response = UserPostResponse.class),
        @ApiResponse(code = 200, message = "upon error", response = UserPostResponse.class) })
    @RequestMapping(value = "/user/login",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<UserPostResponse> userLogin(
    		HttpServletRequest req,
    		HttpServletResponse res,
    		@ApiParam(value = "", required = true) @RequestParam(value = "groupId", required = true) String groupId,
    		@ApiParam(value = "", required = true) @RequestParam(value = "userId", required = true) String userId,
    		@ApiParam(value = "", required = true) @RequestParam(value = "p", required = true) String pass

);
    
    @ApiOperation(value = "LogOut a user", notes = "This endpoint logs out a user of a given group", response = UserPostResponse.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "upon successful logging out a user", response = UserPostResponse.class),
        @ApiResponse(code = 200, message = "upon error", response = UserPostResponse.class) })
    @RequestMapping(value = "/user/logout",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<UserPostResponse> userLogOut(
    		HttpServletRequest req,
    		HttpServletResponse res,
    		@ApiParam(value = "", required = true) @RequestParam(value = "groupId", required = true) String groupId,
    		@ApiParam(value = "", required = true) @RequestParam(value = "userId", required = true) String userId
); 



}

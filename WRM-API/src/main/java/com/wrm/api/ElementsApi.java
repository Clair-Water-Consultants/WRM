package com.wrm.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wrm.model.ElementListResponse;
import com.wrm.model.ElementPostResponse;
import com.wrm.model.ElementRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

@Api(value = "elements", description = "the elements API")
public interface ElementsApi {

    @ApiOperation(value = "Water Elements", notes = "The elements enpoint returns the list of water elements in the system. The response would include unique identifier of the element, element name, units, max min limits ", response = ElementListResponse.class, tags={ "Elements", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of elements", response = ElementListResponse.class),
        @ApiResponse(code = 200, message = "upon error", response = ElementListResponse.class) })
    @RequestMapping(value = "/elements",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ElementListResponse> elementsGet();


    @ApiOperation(value = "Add a water element", notes = "This endpint adds a new water element to the system. It accepts a json which would include element name, units, description, max min limits and would return a unique identifier of the element upon success ", response = ElementPostResponse.class, tags={ "Elements", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "upon successful creation of an element", response = ElementPostResponse.class),
        @ApiResponse(code = 200, message = "upon error", response = ElementPostResponse.class) })
    @RequestMapping(value = "/elements",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ElementPostResponse> elementsPost(

@ApiParam(value = "request object of an element" ,required=true ) @RequestBody ElementRequest body

);

}

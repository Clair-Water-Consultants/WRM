package com.wrm.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wrm.dao.DaoInterface;
import com.wrm.dao.impl.ElementDaoImpl;
import com.wrm.dao.impl.WaterDaoImpl;
import com.wrm.dao.model.Element;
import com.wrm.dao.model.Water;
import com.wrm.dao.model.WaterBayAssociation;
import com.wrm.model.ElementListResponse;
import com.wrm.model.ElementResponse;
import com.wrm.model.WaterPostResponse;
import com.wrm.model.WaterRequest;
import com.wrm.model.WaterTypeListResponse;
import com.wrm.model.WaterTypeResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

@Controller
@Api(value = "watertypes", description = "the watertypes API")
public class WatertypesApiController implements WatertypesApi {

    @ApiOperation(value = "Water types available", notes = "The elements enpoint returns the list of water types in the system. The response would include unique identifier of the type, the type and description of the water type ", response = WaterTypeListResponse.class, tags={ "WaterTypes", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of elements", response = WaterTypeListResponse.class),
        @ApiResponse(code = 200, message = "upon error", response = WaterTypeListResponse.class) })
    @RequestMapping(value = "/watertypes",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public ResponseEntity<WaterTypeListResponse> watertypesGet(@ApiParam(value = "", required = true) @RequestParam(value = "groupId", required = true) String groupId



,
        @ApiParam(value = "", required = true) @RequestParam(value = "bayId", required = true) String bayId



) {
    	WaterTypeListResponse responseList = new WaterTypeListResponse();
		try {
			WaterDaoImpl dao = new WaterDaoImpl();
			List<WaterBayAssociation> waterList = dao.findAll(groupId, bayId);
			for (WaterBayAssociation e : waterList) {
				WaterTypeResponse response = new WaterTypeResponse();
				response.setDescription(e.getPrimary().getWater().getDescription());
				response.setId(e.getPrimary().getWater().getId());
				response.setType(e.getPrimary().getWater().getType());
				responseList.addWatertypeItem(response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return ResponseEntity.ok(responseList);
    }

    public ResponseEntity<WaterPostResponse> watertypesPost(

@ApiParam(value = "request object of the water type" ,required=true ) @RequestBody WaterRequest body

) {
        // do some magic!
        return new ResponseEntity<WaterPostResponse>(HttpStatus.OK);
    }

}

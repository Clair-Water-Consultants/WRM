package com.wrm.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.wrm.model.WRMDataListResponse;
import com.wrm.model.WRMDataPostResponse;
import com.wrm.model.WRMDataRequest;

import io.swagger.annotations.ApiParam;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

@Controller
public class WrmdataApiController implements WrmdataApi {

    public ResponseEntity<WRMDataListResponse> wrmdataGroupIdGet(
@ApiParam(value = "",required=true ) @PathVariable("groupId") String groupId


,
        @ApiParam(value = "", required = true) @RequestParam(value = "elementId", required = true) String elementId



,
        @ApiParam(value = "", required = true) @RequestParam(value = "bayId", required = true) String bayId



,
        @ApiParam(value = "") @RequestParam(value = "granularity", required = false) String granularity



,
        @ApiParam(value = "") @RequestParam(value = "timeperiod", required = false) String timeperiod



) {
        // do some magic!
        return new ResponseEntity<WRMDataListResponse>(HttpStatus.OK);
    }

    public ResponseEntity<WRMDataPostResponse> wrmdataPost(

@ApiParam(value = "request object of the wrmdata type" ,required=true ) @RequestBody WRMDataRequest body

) {
        // do some magic!
        return new ResponseEntity<WRMDataPostResponse>(HttpStatus.OK);
    }

}

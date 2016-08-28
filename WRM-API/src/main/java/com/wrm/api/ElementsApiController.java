package com.wrm.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.wrm.dao.DaoInterface;
import com.wrm.dao.impl.ElementDaoImpl;
import com.wrm.dao.model.Element;
import com.wrm.model.ElementListResponse;
import com.wrm.model.ElementPostResponse;
import com.wrm.model.ElementRequest;
import com.wrm.model.ElementResponse;

import io.swagger.annotations.ApiParam;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

@Controller
public class ElementsApiController implements ElementsApi {

    public ResponseEntity<ElementListResponse> elementsGet() {
       ElementListResponse responseList = new ElementListResponse();
		try {
			DaoInterface<Element, ?> dao = new ElementDaoImpl();
			List<Element> elementList = dao.findAll();
			for (Element e : elementList) {
				ElementResponse response = new ElementResponse();
				response.setId(e.getId());
				response.setDescription(e.getDescription());
				response.setLowerLimit(e.getLowerLimit());
				response.setUpperLimit(e.getUpperLimit());
				response.setName(e.getName());
				response.setUnits(e.getUnits());
				responseList.addElementsItem(response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return ResponseEntity.ok(responseList);

    }

    public ResponseEntity<ElementPostResponse> elementsPost(

@ApiParam(value = "request object of an element" ,required=true ) @RequestBody ElementRequest body

) {
        // do some magic!
        return new ResponseEntity<ElementPostResponse>(HttpStatus.OK);
    }

}

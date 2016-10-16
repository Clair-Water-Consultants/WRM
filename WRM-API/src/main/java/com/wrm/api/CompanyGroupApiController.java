package com.wrm.api;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.wrm.dao.impl.CompanyGroupDaoImpl;
import com.wrm.dao.model.CompanyGroup;
import com.wrm.model.CompanyGroupPostResponse;
import com.wrm.model.CompanyGroupRequest;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-04T10:25:35.178Z")

@Controller
public class CompanyGroupApiController implements CompanyGroupApi {

	public ResponseEntity<CompanyGroupPostResponse> companyPost(
			@ApiParam(value = "request object of an element", required = true) @RequestBody CompanyGroupRequest body) {
		String uniqueUserId = UUID.randomUUID().toString();
		CompanyGroup user = new CompanyGroup();
		BeanUtils.copyProperties(body, user);
		user.setId(uniqueUserId);

		if(body.getCreatedTime() ==  null) {
			user.setCreatedTime(new Date());
		}
		
		user.setUpdatedTime(new Date());
		CompanyGroupDaoImpl cgDao = new CompanyGroupDaoImpl();
		List<CompanyGroup> existingUser = cgDao.findByName(user.getName(), user.getDescription());
		if (existingUser != null && existingUser.size() > 0) {
			return new ResponseEntity<CompanyGroupPostResponse>(HttpStatus.CONFLICT);
		}
		cgDao.persist(user);
		CompanyGroupDaoImpl.closeCurrentSessionWithTransaction();
		return ResponseEntity.ok(new CompanyGroupPostResponse(user.getId(),user.getName()));
	}


}
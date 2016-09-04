package com.wrm.api;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.wrm.dao.impl.UserDaoImpl;
import com.wrm.dao.model.User;
import com.wrm.model.UserListResponse;
import com.wrm.model.UserPostResponse;
import com.wrm.model.UserRequest;
import com.wrm.security.SecurityHelper;
import com.wrm.security.SecurityHelper.CannotPerformOperationException;
import com.wrm.security.SecurityHelper.InvalidHashException;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-04T10:25:35.178Z")

@Controller
public class UserApiController implements UserApi {

	public ResponseEntity<UserListResponse> userGet(
			@ApiParam(value = "", required = true) @RequestParam(value = "groupId", required = true) String groupId,
			@ApiParam(value = "", required = true) @RequestParam(value = "user", required = true) String userId,
			@ApiParam(value = "", required = true) @RequestParam(value = "p", required = true) String pass) {

		// get user for given userId and then authenticate
		UserDaoImpl userDao = new UserDaoImpl();
		List<User> userList = userDao.findByUserId(userId, groupId);
		if (userList != null && userList.size() > 1) {
			return new ResponseEntity<UserListResponse>(HttpStatus.FORBIDDEN);
		}
		User userEntity = userList.get(0);
		try {
			if (SecurityHelper.verifyPassword(pass, userEntity.getPass())) {
				return new ResponseEntity<UserListResponse>(HttpStatus.OK);
			} else {
				return new ResponseEntity<UserListResponse>(HttpStatus.FORBIDDEN);
			}
		} catch (InvalidHashException e) {
			return new ResponseEntity<UserListResponse>(HttpStatus.FORBIDDEN);
		} catch (CannotPerformOperationException cnoe) {
			return new ResponseEntity<UserListResponse>(HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<UserPostResponse> userPost(
			@ApiParam(value = "request object of an element", required = true) @RequestBody UserRequest body
	) {
		String uniqueUserId = UUID.randomUUID().toString();
		User user = new User();
		BeanUtils.copyProperties(body, user);
		user.setId(uniqueUserId);
		Date date = Calendar.getInstance().getTime();
		try {
			String hash = SecurityHelper.createHash(user.getPass());
			user.setCreatedTime(date);
			user.setUpdatedTime(date);
			user.setPass(hash);
		} catch (CannotPerformOperationException e) {
			return new ResponseEntity<UserPostResponse>(HttpStatus.FORBIDDEN);
		}
		UserDaoImpl userDao = new UserDaoImpl();
		List<User> existingUser = userDao.findByUserId(user.getName(), user.getGroupId());
		if(existingUser != null && existingUser.size() > 0) {
			return new ResponseEntity<UserPostResponse>(HttpStatus.CONFLICT);
		}
		userDao.persist(user);
		UserDaoImpl.closeCurrentSessionWithTransaction();
		return new ResponseEntity<UserPostResponse>(HttpStatus.OK);
	}

}

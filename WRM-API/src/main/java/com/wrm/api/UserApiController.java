package com.wrm.api;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.wrm.model.UserResponse;
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
				UserResponse response = new UserResponse();
				BeanUtils.copyProperties(userEntity, response);
				response.setPass(null);
				return ResponseEntity.ok(new UserListResponse().addUserItem(response));
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
			@ApiParam(value = "request object of an element", required = true) @RequestBody UserRequest body) {
		String uniqueUserId = UUID.randomUUID().toString();
		User user = new User();
		BeanUtils.copyProperties(body, user);
		user.setId(uniqueUserId);
		try {
			String hash = SecurityHelper.createHash(user.getPass());
			user.setPass(hash);
		} catch (CannotPerformOperationException e) {
			return new ResponseEntity<UserPostResponse>(HttpStatus.FORBIDDEN);
		}
		UserDaoImpl userDao = new UserDaoImpl();
		List<User> existingUser = userDao.findByUserId(user.getName(), user.getGroupId());
		if (existingUser != null && existingUser.size() > 0) {
			return new ResponseEntity<UserPostResponse>(HttpStatus.CONFLICT);
		}
		userDao.persist(user);
		UserDaoImpl.closeCurrentSessionWithTransaction();
		return ResponseEntity.ok(new UserPostResponse(uniqueUserId));
	}

	public ResponseEntity<UserPostResponse> userLogin(HttpServletRequest req, HttpServletResponse res,
			@ApiParam(value = "", required = true) @RequestParam(value = "groupId", required = true) String groupId,
			@ApiParam(value = "", required = true) @RequestParam(value = "user", required = true) String userId,
			@ApiParam(value = "", required = true) @RequestParam(value = "p", required = true) String pass) {
		// get user for given userId and then authenticate
		UserDaoImpl userDao = new UserDaoImpl();
		List<User> userList = userDao.findByUserId(userId, groupId);
		if (userList != null && userList.size() > 1) {
			return new ResponseEntity<UserPostResponse>(HttpStatus.FORBIDDEN);
		}
		User userEntity = userList.get(0);
		try {
			if (SecurityHelper.verifyPassword(pass, userEntity.getPass())) {
				UserResponse response = new UserResponse();
				BeanUtils.copyProperties(userEntity, response);
				response.setPass(null);
				Date date = new Date();
				userEntity.setUpdatedTime(date);
				userDao.update(userEntity);
				UserDaoImpl.closeCurrentSessionWithTransaction();
				userEntity = userDao.findById(userEntity.getId());
				String sessionToken = SecurityHelper.generateSessionToken(userEntity.getName(), userEntity.getGroupId(),
						req.getRemoteAddr(), userEntity.getUpdatedTime().getTime());
				Cookie[] cookies = req.getCookies();
				Cookie wrmCookie = null;
				if (cookies != null) {
					for (Cookie c : cookies) {
						if (c.getName().equalsIgnoreCase(SecurityHelper.WRM_COOKIE_NAME)) {
							wrmCookie = c;
							break;
						}
					}
				}
				if (wrmCookie != null) {
					// set the new sessionToken and invalidate an older one
					wrmCookie.setValue(sessionToken);
					res.addCookie(wrmCookie);
				} else {
					wrmCookie = new Cookie(SecurityHelper.WRM_COOKIE_NAME, sessionToken);
					wrmCookie.setMaxAge(Constants.SESSION_MAX_AGE);
					res.addCookie(wrmCookie);
				}
				return ResponseEntity.ok(new UserPostResponse(userEntity.getId()));
			} else {
				return new ResponseEntity<UserPostResponse>(HttpStatus.FORBIDDEN);
			}
		} catch (InvalidHashException e) {
			return new ResponseEntity<UserPostResponse>(HttpStatus.FORBIDDEN);
		} catch (CannotPerformOperationException cnoe) {
			return new ResponseEntity<UserPostResponse>(HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<UserPostResponse> userLogOut(HttpServletRequest req, HttpServletResponse res,
			@ApiParam(value = "", required = true) @RequestParam(value = "groupId", required = true) String groupId,
			@ApiParam(value = "", required = true) @RequestParam(value = "user", required = true) String userId) {
		UserDaoImpl userDao = new UserDaoImpl();
		List<User> userList = userDao.findByUserId(userId, groupId);
		if (userList != null && userList.size() > 1) {
			return new ResponseEntity<UserPostResponse>(HttpStatus.FORBIDDEN);
		}
		User userEntity = userList.get(0);
		userEntity.setUpdatedTime(null);
		userDao.update(userEntity);
		UserDaoImpl.closeCurrentSessionWithTransaction();
		// reset session cookie on logout
		Cookie wrmCookie = new Cookie(SecurityHelper.WRM_COOKIE_NAME, null);
		wrmCookie.setHttpOnly(true);
		wrmCookie.setMaxAge(0);
		res.addCookie(wrmCookie);
		return ResponseEntity.ok(new UserPostResponse(userEntity.getId()));
	}

}
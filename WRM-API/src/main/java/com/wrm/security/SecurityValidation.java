package com.wrm.security;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wrm.dao.impl.UserDaoImpl;
import com.wrm.dao.model.User;

public class SecurityValidation {

	public static HttpServletResponse doValidate(ServletRequest request, ServletResponse response) {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		if (!req.getRequestURI().contains("user/login") && !req.getRequestURI().contains("user/logout")) {
			System.out.println("Inside Non-Login Flow...");
			Cookie currentCookie = null;
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
					if (c.getName().equalsIgnoreCase(SecurityHelper.WRM_COOKIE_NAME)) {
						currentCookie = c;
						break;
					}
				}
			}
			System.out.println("Check 1...");
			if (currentCookie == null) {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return res;
			}
			System.out.println("Check 2...");
			String sessionToken = SecurityHelper.parseSessionToken(currentCookie.getValue());
			if (sessionToken == null || sessionToken.equals("")) {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return res;
			}
			System.out.println("Check 3...");
			String[] creds = sessionToken.split("\\|");
			String userId = creds[0];
			String groupId = creds[1];
			String loginTime = creds[3];
			System.out.println(Long.parseLong(loginTime));

			UserDaoImpl daoImpl = new UserDaoImpl();
			List<User> userList = daoImpl.findByUserId(userId, groupId);
			if (userList != null && userList.size() > 1) {
				res.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return res;
			}
			System.out.println("Check 4...");
			User currentUser = userList.get(0);
			Date lastLoggedInTime = currentUser.getUpdatedTime();
			if (lastLoggedInTime == null) {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return res;
			}
			System.out.println("Check 5...");

			if (currentCookie == null || currentCookie.getValue().equals("")) {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return res;
			}
			System.out.println("Check 6...");
			try {
				if (!SecurityHelper.validateToken(currentUser.getName(), currentUser.getGroupId(), req.getRemoteAddr(),
						currentUser.getUpdatedTime().getTime(), currentCookie.getValue())) {
					res.setStatus(HttpServletResponse.SC_FORBIDDEN);
					return res;
				}
				System.out.println("Check 7...");
			} catch (Exception e) {
				e.printStackTrace();
			}

			if ((System.currentTimeMillis() - lastLoggedInTime.getTime()) > SecurityHelper.TOKEN_EXPIRY) {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return res;
			}
			System.out.println("Check 8...");
		}
		return null;
	}

}
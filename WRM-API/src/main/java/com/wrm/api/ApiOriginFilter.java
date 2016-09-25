package com.wrm.api;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;
//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import com.wrm.dao.impl.UserDaoImpl;
import com.wrm.dao.model.User;
import com.wrm.security.SecurityHelper;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")
@Component
public class ApiOriginFilter implements javax.servlet.Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		res.addHeader("Access-Control-Allow-Headers", "Content-Type");
		System.out.println("API Origin FILTERRRRRRRRRRRRRRRRRR");
/*		if (!req.getRequestURI().contains("/v1/user/login") && !req.getRequestURI().contains("/v1/user/logout")) {
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
				return;
			}
			System.out.println("Check 2...");
			String sessionToken = SecurityHelper.parseSessionToken(currentCookie.getValue());
			if (sessionToken == null || sessionToken.equals("")) {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}
			System.out.println("Check 3...");
			String[] creds = sessionToken.split("\\|");
			String userId = creds[0];
			String groupId = creds[1];
			UserDaoImpl daoImpl = new UserDaoImpl();
			List<User> userList = daoImpl.findByUserId(userId, groupId);
			if (userList != null && userList.size() > 1) {
				res.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return;
			}
			System.out.println("Check 4...");
			User currentUser = userList.get(0);
			Date lastLoggedInTime = currentUser.getUpdatedTime();
			if (lastLoggedInTime == null) {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}
			System.out.println("Check 5...");

			if (currentCookie == null || currentCookie.getValue().equals("")) {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}
			System.out.println("Check 6...");
			try {
				if (!SecurityHelper.validateToken(currentUser.getName(), currentUser.getGroupId(), req.getRemoteAddr(),
						currentUser.getUpdatedTime().getTime(), currentCookie.getValue())) {
					res.setStatus(HttpServletResponse.SC_FORBIDDEN);
					return;
				}
				System.out.println("Check 7...");
			} catch (Exception e) {
				e.printStackTrace();
			}

			if ((System.currentTimeMillis() - lastLoggedInTime.getTime()) > SecurityHelper.TOKEN_EXPIRY) {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}
			System.out.println("Check 8...");
		}*/
		System.out.println("Surpassed cookie checks...");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
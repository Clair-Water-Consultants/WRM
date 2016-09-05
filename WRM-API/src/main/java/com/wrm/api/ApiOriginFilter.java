package com.wrm.api;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
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
		if (!req.getRequestURI().equals("/v1/user/login") && !req.getRequestURI().equals("/v1/user/logout")) {
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
			if (currentCookie == null) {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				//res.sendRedirect("/v1/user/login");
				return;
			}
			String sessionToken = SecurityHelper.parseSessionToken(currentCookie.getValue());
			if (sessionToken == null || sessionToken.equals("")) {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				//res.sendRedirect("/v1/user/login");
				return;
			}
			String[] creds = sessionToken.split("\\|");
			String userId = creds[0];
			String groupId = creds[1];
			UserDaoImpl daoImpl = new UserDaoImpl();
			List<User> userList = daoImpl.findByUserId(userId, groupId);
			if (userList != null && userList.size() > 1) {
				res.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return;
			}
			User currentUser = userList.get(0);
			SimpleDateFormat sdfDate = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
			Calendar cal = Calendar.getInstance();
			Date lastLoggedInTime = currentUser.getUpdatedTime();
			System.out.println(lastLoggedInTime+","+lastLoggedInTime.getTime());
			//cal.setTimeInMillis(lastLoggedInTime.getTime());
			//cal.set(Calendar.MILLISECOND, 0);
			
			if (lastLoggedInTime == null) {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}

			if (currentCookie == null || currentCookie.getValue().equals("")) {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}
			try {
				if (!SecurityHelper.validateToken(currentUser.getName(), currentUser.getGroupId(), req.getRemoteAddr(),
						currentUser.getUpdatedTime().getTime(), currentCookie.getValue())) {
					res.setStatus(HttpServletResponse.SC_FORBIDDEN);
					return;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if ((System.currentTimeMillis() - lastLoggedInTime.getTime()) > SecurityHelper.TOKEN_EXPIRY) {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				//res.sendRedirect("/v1/user/login");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
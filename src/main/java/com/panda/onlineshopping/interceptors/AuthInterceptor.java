package com.panda.onlineshopping.interceptors;

import java.net.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.panda.onlineshopping.services.UserService;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getHeader("PandaAuthToken");
		if (!userService.isActiveToken(token)) {
			response.setStatus(HttpURLConnection.HTTP_BAD_REQUEST);
			return false;
		} else
			return super.preHandle(request, response, handler);
	}

}

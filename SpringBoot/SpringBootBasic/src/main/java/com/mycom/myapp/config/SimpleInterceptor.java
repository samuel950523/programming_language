package com.mycom.myapp.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class SimpleInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String str = request.getParameter("login");
		if ("no".equals(str)) {
			// http://localhost:8080/login?login=no
			// http://localhost:8080/main?login=no
			System.out.println("Not Logged In!!");
			request.getRequestDispatcher("/login").forward(request, response);
			return false;
		}
		return super.preHandle(request, response, handler);
	}
}

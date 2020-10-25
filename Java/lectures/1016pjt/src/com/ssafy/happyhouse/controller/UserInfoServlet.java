package com.ssafy.happyhouse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ssafy.happyhouse.model.UserInfoDto;
import com.ssafy.happyhouse.model.service.UserInfoService;
import com.ssafy.happyhouse.model.service.UserInfoServiceImpl;


/*
 * contextPath 고려
 */
@WebServlet("/UserInfo/*")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// met
	UserInfoService service = new UserInfoServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String contextPath = request.getContextPath();
		String path = request.getRequestURI().substring(contextPath.length());

		System.out.println(path);
		
		switch(path) {
			case "/UserInfo/UserInfoDetail"		: UserInfoDetail(request, response); break;
			case "/UserInfo/UserInfoUpdate"		: UserInfoUpdate(request, response); break;
			case "/UserInfo/UserInfoDelete"		: UserInfoDelete(request, response); break;
			default : notValidUrl();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	
	private void UserInfoDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String userName = request.getParameter("userName");
		// if strUserInfoId == null or "" Exception ...
		UserInfoDto UserInfoDto = service.UserInfoDetail(userName);

		Gson gson = new Gson();

		String jsonStr = gson.toJson(UserInfoDto, UserInfoDto.class);
		response.getWriter().write(jsonStr);
	}
	
	private void UserInfoUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		UserInfoDto UserInfoDto = new UserInfoDto();
		UserInfoDto.setUserName(request.getParameter("userName"));
		UserInfoDto.setUserPassword(request.getParameter("userPassword"));
		UserInfoDto.setUserEmail(request.getParameter("userEmail"));
		
		int ret = service.UserInfoUpdate(UserInfoDto);

		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		
		if (ret == 1) {
			jsonObject.addProperty("result", "success");
		} else {
			jsonObject.addProperty("result", "fail");
		}
		
		String jsonStr = gson.toJson(jsonObject);
		response.getWriter().write(jsonStr);
	}
	
	private void UserInfoDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		int ret = service.UserInfoDelete(request.getParameter("userName"));

		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		
		if (ret == 1) {
			jsonObject.addProperty("result", "success");
		} else {
			jsonObject.addProperty("result", "fail");
		}
		
		String jsonStr = gson.toJson(jsonObject);
		response.getWriter().write(jsonStr);
	}

	private void notValidUrl() {
		System.out.println("UserInfoServlet - Not Valid URL Request !");
	}
}
package com.ssafy.happyhouse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.service.UserService;
import com.ssafy.happyhouse.model.service.UserServiceImpl;


@WebServlet("/register")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		System.out.println(userName);
		String userPassword = request.getParameter("userPassword");
		String userEmail = request.getParameter("userEmail");
		System.out.println(userEmail);
		
		UserDto userDto = new UserDto();
		userDto.setUserName(userName);
		userDto.setUserPassword(userPassword);
		userDto.setUserEmail(userEmail);
		
		UserService userService =new UserServiceImpl();
		
		int ret = userService.userRegister(userDto);
		
		Gson gson = new Gson();
		
		JsonObject jsonObject = new JsonObject();
		
		if(ret==1)
			jsonObject.addProperty("result","success");
		else
			jsonObject.addProperty("result","fail");
		
		String jsonStr = gson.toJson(jsonObject);
		response.getWriter().write(jsonStr);
	}

}

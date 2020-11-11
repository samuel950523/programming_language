package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping(value = "/register")
	public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
		int result = -1;
		result = userService.userRegister(userDto);
		if(result==-1)
			return new ResponseEntity<UserDto>(userDto, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
}

package com.mycom.myboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myboard.dto.UserDto;
import com.mycom.myboard.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService service;

	@PostMapping(value = "/login")
	public ResponseEntity<UserDto> login(@RequestBody UserDto dto, HttpSession session) {
		UserDto userDto = service.login(dto);
		if (userDto != null) {
			session.setAttribute("userDto", userDto);
			return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
		}
		return new ResponseEntity<UserDto>(userDto, HttpStatus.NOT_FOUND);

	}
}

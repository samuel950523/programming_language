package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.service.LoginService;

@Controller
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

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userDto");
		return "Main";
	}

}

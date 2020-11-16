package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.service.UserInfoService;

@RestController
public class UserInfoController {
	@Autowired
	UserInfoService service;
	
	@PutMapping(value = "/userInfo/userInfoUpdate/{userName}")
	public int update(@PathVariable String userName, @RequestBody UserDto dto) {
		return service.UserInfoUpdate(dto);
	}

	@DeleteMapping(value = "/userInfo/userInfoDelete/{userName}")
	public int delete(@PathVariable String userName) {
		return service.UserInfoDelete(userName);
	}

	@GetMapping(value = "/userInfo/userInfoDetail/{userName}")
	public UserDto detail(@PathVariable String userName) {
		return service.UserInfoDetail(userName);
	}
}

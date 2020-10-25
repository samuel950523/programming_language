package com.mycom.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.mybatis.dto.EmpDto;
import com.mycom.mybatis.service.MyBatisService;

@Controller
public class MyBatisController {

	@Autowired
	MyBatisService service;

	@GetMapping(value = "/empDetail/{employeeId}")
	@ResponseBody
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println(employeeId);
		EmpDto empDto = service.empDetail(employeeId);
		return empDto;
	}

}

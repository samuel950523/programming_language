package com.mycom.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.mybatis.dto.EmpDto;
import com.mycom.mybatis.service.MyBatisService;

@Controller
public class MyBatisController {
	@Autowired
	MyBatisService service;
	
	@GetMapping(value="/empDetail/{employeeId}")
	@ResponseBody
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println(employeeId);
		EmpDto empDto = service.empDetail(employeeId);
		return empDto;
	}

	@GetMapping(value="/empList")
	@ResponseBody
	public List<EmpDto> empList() {
		List<EmpDto> list = service.empList();
		return list;
	}


	@PostMapping(value="/empInsert")
	@ResponseBody
	public int empInsert(EmpDto empDto) {
		System.out.println(empDto);
		int ret = service.empInsert(empDto);
		return ret;
	}

	@PostMapping(value="/empUpdate")
	@ResponseBody
	public int empUpdate(EmpDto empDto) {
		System.out.println(empDto);
		int ret = service.empUpdate(empDto);
		return ret;
	}

	@PostMapping(value="/empDelete")
	@ResponseBody
	public int empDelete(int employeeId) {
		int ret = service.empDelete(employeeId);
		return ret;
	}

	@PostMapping(value="/empInsertJSON")
	@ResponseBody
	public int empInsertJSON(@RequestBody EmpDto empDto) {
		System.out.println(empDto);
		int ret = service.empInsert(empDto);
		return ret;
	}
	
	@GetMapping(value="/empDetailNormal/{employeeId}")
	public String empDetailNormal(@PathVariable int employeeId, Model model) {
		System.out.println(employeeId);
		EmpDto empDto = service.empDetail(employeeId);
		model.addAttribute("empDto", empDto);
		return "detail";
	}
}

package com.mycom.mymvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycom.mymvc.dto.EmpDto;

@Controller
public class JsonController {
	@PostMapping(value = "/emp")
	public void m1(@RequestBody EmpDto dto) {
		System.out.println("employeeId : " + dto.getEmployeeId());
		System.out.println("firstName : " + dto.getFirstName());
		System.out.println("lastName : " + dto.getLastName());
		System.out.println("email : " + dto.getEmail());
		System.out.println("hireDate : " + dto.getHireDate());
	}

	// @RequestBody
	// multiple Emps
	@PostMapping(value = "/empList")
	public void m2(@RequestBody List<EmpDto> empList) {
		for (EmpDto dto : empList) {
			System.out.println(dto);
		}
	}

	// @ResponseBody TEST EmpDto
	@GetMapping(value = "/empDetail/{employeeId}")
	@ResponseBody
	public EmpDto m3(@PathVariable int employeeId) {
		System.out.println(employeeId);
		EmpDto empDto = new EmpDto(1600, "Chan-Ho", "Park", "hopark@heroes.com", "1600-12-25");
		return empDto;
	}

	// @ResponseBody TEST List<EmpDto>
	@GetMapping(value = "/empList")
	public @ResponseBody List<EmpDto> m4() {
		List<EmpDto> empList = new ArrayList<EmpDto>();
		empList.add(new EmpDto(1600, "Chan-Ho", "Park", "hopark@heroes.com", "1600-12-25"));
		empList.add(new EmpDto(1953, "Boom", "Cha", "cha@heroes.com", "1953-05-22"));
		empList.add(new EmpDto(2001, "Gang-In", "Lee", "loveyou@heroes.com", "2001-02-19"));

		return empList;
	}

	@PostMapping(value = "/jacksonEmp")
	public void m5(String json) throws IOException {
		System.out.println("json : " + json);
		ObjectMapper objectMapper = new ObjectMapper();
		EmpDto dto = objectMapper.readValue(json, EmpDto.class);
		System.out.println("employeeId : " + dto.getEmployeeId());
		System.out.println("firstName : " + dto.getFirstName());
		System.out.println("lastName : " + dto.getLastName());
		System.out.println("email : " + dto.getEmail());
		System.out.println("hireDate : " + dto.getHireDate());
	}
}

package com.mycom.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.myapp.dto.StudentDto;
import com.mycom.myapp.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@ExceptionHandler
	public ModelAndView handler(Exception ex) {
		ModelAndView mav = new ModelAndView("error/errorHandler");
		mav.addObject("msg", ex.getMessage());
		ex.printStackTrace();
		return mav;
	}

	@GetMapping(value = "/students")
	public List<StudentDto> list() {
		List<StudentDto> list = studentService.list();
		for (StudentDto studentDto : list) {
			System.out.println(studentDto.getStudentId());
			System.out.println(studentDto.getStudentNm());
		}
		return studentService.list();
	}

	@PostMapping(value = "/students")
	public int insert(@RequestBody StudentDto dto) {
		return studentService.insert(dto);
	}

	@PutMapping(value = "/students/{id}")
	public int update(@PathVariable int id, @RequestBody StudentDto dto) {
		return studentService.update(dto);
	}

	@DeleteMapping(value = "/students/{id}")
	public int delete(@PathVariable int id) {
		return studentService.delete(id);
	}

	@GetMapping(value = "/students/{id}")
	public StudentDto detail(@PathVariable int id) {
		return studentService.detail(id);
	}
}

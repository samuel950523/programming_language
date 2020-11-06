package com.mycom.myapp.service;

import java.util.List;

import com.mycom.myapp.dto.StudentDto;

public interface StudentService {
	public List<StudentDto> list(); 
	public int insert(StudentDto dto);
	public int update(StudentDto dto);
	public int delete(int id);
	public StudentDto detail(int id);
}

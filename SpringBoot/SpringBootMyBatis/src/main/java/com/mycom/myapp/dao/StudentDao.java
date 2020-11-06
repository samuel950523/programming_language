package com.mycom.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.dto.StudentDto;

@Mapper
public interface StudentDao {
	public List<StudentDto> list(); 
	public int insert(StudentDto dto);
	public int update(StudentDto dto);
	public int delete(int id);
	public StudentDto detail(int id);
}

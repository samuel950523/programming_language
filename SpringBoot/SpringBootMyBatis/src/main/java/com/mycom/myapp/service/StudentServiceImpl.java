package com.mycom.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.dao.StudentDao;
import com.mycom.myapp.dto.StudentDto;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	public List<StudentDto> list() {
		return studentDao.list();
	}

	@Override
	public int insert(StudentDto dto) {
		return studentDao.insert(dto);
	}

	@Override
	public int update(StudentDto dto) {
		return studentDao.update(dto);
	}

	@Override
	public int delete(int id) {
		return studentDao.delete(id);
	}

	@Override
	public StudentDto detail(int id) {
		return studentDao.detail(id);
	}

}

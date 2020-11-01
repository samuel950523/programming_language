package com.mycom.batishw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.batishw.dao.MyBatisDao;
import com.mycom.batishw.dto.EmpDto;

@Service
public class MyBatisServiceImpl implements MyBatisService {

	@Autowired
	MyBatisDao dao;

	@Override
	public EmpDto empDetail(int employeeId) {
		return dao.empDetail(employeeId);
	}

	@Override
	public List<EmpDto> empList() {
		return dao.empList();
	}

	@Override
	public int empInsert(EmpDto dto) {
		return dao.empInsert(dto);
	}

	@Override
	public int empUpdate(EmpDto dto) {
		return dao.empUpdate(dto);
	}

	@Override
	public int empDelete(int employeeId) {
		return dao.empDelete(employeeId);
	}
}

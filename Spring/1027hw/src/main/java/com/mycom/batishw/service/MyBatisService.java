package com.mycom.batishw.service;

import java.util.List;

import com.mycom.batishw.dto.EmpDto;

public interface MyBatisService {
	public EmpDto empDetail(int employeeId);
	public List<EmpDto> empList();
	public int empInsert(EmpDto dto);
	public int empUpdate(EmpDto dto);
	public int empDelete(int employeeId);
}

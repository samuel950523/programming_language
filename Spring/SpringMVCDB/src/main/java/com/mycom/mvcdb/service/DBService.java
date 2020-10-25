package com.mycom.mvcdb.service;

import java.util.List;

import com.mycom.mvcdb.dto.EmpDto;

public interface DBService {
	public EmpDto empDetail(int employeeId);
	public List<EmpDto> empList();
	public int empInsert(EmpDto dto);
	public int empUpdate(EmpDto dto);
	public int empDelete(int employeeId);
}
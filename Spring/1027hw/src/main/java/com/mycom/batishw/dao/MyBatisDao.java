package com.mycom.batishw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.batishw.dto.EmpDto;

@Mapper
public interface MyBatisDao {
	public EmpDto empDetail(int employeeId);
	public List<EmpDto> empList();
	public int empInsert(EmpDto dto);
	public int empUpdate(EmpDto dto);
	public int empDelete(int employeeId);
}

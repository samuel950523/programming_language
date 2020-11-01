package com.ssafy.term4.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.RegistDto;

public interface RegistDao {

	public void createRegist(RegistDto registDto) throws SQLException;
	public List<RegistDto> listRegist(Map<String, String> map) throws SQLException;
	
	public RegistDto getRegist(int ccode) throws SQLException;
	public void deleteRegist(int ccode) throws SQLException;
	
}

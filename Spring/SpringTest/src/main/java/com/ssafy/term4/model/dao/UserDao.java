package com.ssafy.term4.model.dao;

import java.sql.SQLException;
import java.util.Map;

import model.MemberDto;

public interface UserDao {

	public MemberDto login(Map<String, String> map) throws SQLException;
	
}

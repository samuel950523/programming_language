package com.ssafy.happyhouse.model.dao;

import com.ssafy.happyhouse.model.UserDto;

public interface LoginDao {
	public UserDto login(String userName);
}

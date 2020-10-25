package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.dao.UserDao;
import com.ssafy.happyhouse.model.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
	@Override
	public int userRegister(UserDto userDto) {
		UserDao userDao = new UserDaoImpl();
		return userDao.userRegister(userDto);
	}
}

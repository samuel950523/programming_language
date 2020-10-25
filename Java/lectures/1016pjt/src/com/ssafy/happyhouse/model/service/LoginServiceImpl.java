package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.dao.LoginDao;
import com.ssafy.happyhouse.model.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {
	LoginDao loginDao = new LoginDaoImpl();

	@Override
	public UserDto login(String userName, String userPassword) {
		UserDto userDto = loginDao.login(userName);
		
		if(userDto!=null && userDto.getUserPassword().equals(userPassword)) {
			return userDto;
		}else {
			return null;
		}
	}

}

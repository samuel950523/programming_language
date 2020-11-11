package com.ssafy.happyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.UserInfoDao;
import com.ssafy.happyhouse.dto.UserDto;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	UserInfoDao dao;


	@Override
	public int UserInfoUpdate(UserDto dto) {
		return dao.UserInfoUpdate(dto);
	}

	@Override
	public int UserInfoDelete(String userName) {
		return dao.UserInfoDelete(userName);
	}

	@Override
	public UserDto UserInfoDetail(String userName) {
		return dao.UserInfoDetail(userName);
	}

}

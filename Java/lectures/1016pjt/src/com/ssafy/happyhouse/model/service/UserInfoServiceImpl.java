package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.UserInfoDto;
import com.ssafy.happyhouse.model.dao.UserInfoDao;
import com.ssafy.happyhouse.model.dao.UserInfoDaoImpl;

public class UserInfoServiceImpl implements UserInfoService {

	UserInfoDao dao = new UserInfoDaoImpl();


	@Override
	public int UserInfoUpdate(UserInfoDto dto) {
		return dao.UserInfoUpdate(dto);
	}

	@Override
	public int UserInfoDelete(String UserInfoId) {
		return dao.UserInfoDelete(UserInfoId);
	}

	@Override
	public UserInfoDto UserInfoDetail(String userName) {
		return dao.UserInfoDetail(userName);
	}

}

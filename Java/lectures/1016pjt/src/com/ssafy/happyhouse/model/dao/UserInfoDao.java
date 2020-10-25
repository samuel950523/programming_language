package com.ssafy.happyhouse.model.dao;

import com.ssafy.happyhouse.model.UserInfoDto;


public interface UserInfoDao {
	public int UserInfoUpdate(UserInfoDto userInfoDto);
	public int UserInfoDelete(String userInfoId);
	public UserInfoDto UserInfoDetail(String userName);
}

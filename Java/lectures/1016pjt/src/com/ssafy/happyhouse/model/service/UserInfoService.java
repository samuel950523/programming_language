package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.UserInfoDto;

public interface UserInfoService {
	public int UserInfoUpdate(UserInfoDto dto);
	public int UserInfoDelete(String string);
	public UserInfoDto UserInfoDetail(String userName);
}

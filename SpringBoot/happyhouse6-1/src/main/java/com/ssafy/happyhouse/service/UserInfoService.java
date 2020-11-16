package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.UserDto;

public interface UserInfoService {
	public int UserInfoUpdate(UserDto dto);
	public int UserInfoDelete(String userName);
	public UserDto UserInfoDetail(String userName);
}

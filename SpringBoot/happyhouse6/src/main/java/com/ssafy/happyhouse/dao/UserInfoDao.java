package com.ssafy.happyhouse.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.UserDto;

@Mapper
public interface UserInfoDao {
	public int UserInfoUpdate(UserDto userDto);
	public int UserInfoDelete(String userName);
	public UserDto UserInfoDetail(String userName);
}

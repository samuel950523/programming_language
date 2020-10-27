package com.ssafy.guestbook.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.guestbook.model.MemberDto;

public interface UserMapper {

	public MemberDto login(Map<String, String> map) throws SQLException;
	
	public List<MemberDto> userList();
	public MemberDto userInfo(String userid);
	public void userRegister(MemberDto memberDto);
	public void userModify(MemberDto memberDto);
	public void userDelete(String userid);
	
}

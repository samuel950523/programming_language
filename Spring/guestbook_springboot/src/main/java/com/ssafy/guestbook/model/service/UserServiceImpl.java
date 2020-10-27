package com.ssafy.guestbook.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		if(map.get("userid") == null || map.get("userpwd") == null)
			return null;
		return sqlSession.getMapper(UserMapper.class).login(map);
	}

	@Override
	public List<MemberDto> userList() {
		return sqlSession.getMapper(UserMapper.class).userList();
	}

	@Override
	public MemberDto userInfo(String userid) {
		return sqlSession.getMapper(UserMapper.class).userInfo(userid);
	}

	@Override
	public void userRegister(MemberDto memberDto) {
		sqlSession.getMapper(UserMapper.class).userRegister(memberDto);
	}

	@Override
	public void userModify(MemberDto memberDto) {
		sqlSession.getMapper(UserMapper.class).userModify(memberDto);
	}

	@Override
	public void userDelete(String userid) {
		sqlSession.getMapper(UserMapper.class).userDelete(userid);
	}

}

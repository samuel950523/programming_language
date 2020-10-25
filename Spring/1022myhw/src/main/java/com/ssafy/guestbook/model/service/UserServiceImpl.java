package com.ssafy.guestbook.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		if(map.get("userid") == null || map.get("userpwd") == null)
			return null;
		return userDao.login(map); //======================= 3)  여기에 들어갈 적절한 코드를 작성하세요 
	}

}

package com.ssafy.term4.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.term4.model.dao.UserDao;

import model.MemberDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		if(map.get("id") == null || map.get("pw") == null)
			return null;
		System.out.println(map);
		return userDao.login(map);
	}

}

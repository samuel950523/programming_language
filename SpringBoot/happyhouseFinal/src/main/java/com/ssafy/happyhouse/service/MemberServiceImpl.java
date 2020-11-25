package com.ssafy.happyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.MemberDao;
import com.ssafy.happyhouse.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao dao;
	
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		System.out.println(memberDto.getUserName()); // 제대로 뜸
//		System.out.println(memberDto.getUserPassword());
		System.out.println(dao.login(memberDto.getUserName()).getUserRegisterDate()); // dao갔다오면 null
		return dao.login(memberDto.getUserName());
	}

	@Override
	public String getServerInfo() {
		return "사용자에게 전달하고 싶은 중요정보";
	}

	@Override
	public int join(MemberDto memberDto) {
		System.out.println("this is join service");
		System.out.println(memberDto.getUserName());
		int get = dao.join(memberDto);
		System.out.println(get);
		return get;
	}
	
	@Override
	public void update(MemberDto memberDto) {
		System.out.println(memberDto.getUserName() + " now service");
		dao.loginUpdate(memberDto);
	}
	
	public void delete(int id) {
		dao.loginDelete(id);
	}

}

package com.ssafy.happyhouse.service;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.MemberDto;

@Service
public interface MemberService {
	
	public MemberDto login(MemberDto memberDto) throws Exception;
	public String getServerInfo();
	public int join(MemberDto memberDto);
	
	public void update(MemberDto memberDto);
	public void delete(int id);
}

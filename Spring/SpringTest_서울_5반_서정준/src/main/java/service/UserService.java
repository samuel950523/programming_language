package service;

import java.util.Map;

import model.MemberDto;

public interface UserService {

	public MemberDto login(Map<String, String> map) throws Exception;
	
}

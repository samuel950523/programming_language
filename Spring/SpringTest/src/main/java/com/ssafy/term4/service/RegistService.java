package com.ssafy.term4.service;

import java.util.List;
import java.util.Map;

import model.RegistDto;

public interface RegistService {

	public void createRegist(RegistDto registDto) throws Exception;
	public List<RegistDto> listRegist(Map<String, String> map) throws Exception;
	
	public RegistDto getRegist(int ccode) throws Exception;
	public void deleteRegist(int ccode) throws Exception;
	
}

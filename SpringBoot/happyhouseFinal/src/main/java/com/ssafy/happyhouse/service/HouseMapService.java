package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.HouseMapDao;
import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.HouseInfoDto;

@Service
public class HouseMapService {
	
	@Autowired
	HouseMapDao dao;
	

	public List<HouseDealDto> getAptInDong(String dong) throws Exception {
		return dao.getAptInDong(dong);
	}
	
	public List<HouseInfoDto> getAptDetail(String aptdetail) throws Exception {
		return dao.getAptDetail(aptdetail);
	}
	
	public HouseDealDto getDetail(String aptName, String dongCode) throws Exception {
		return dao.getDetail(aptName, dongCode);
	}

}

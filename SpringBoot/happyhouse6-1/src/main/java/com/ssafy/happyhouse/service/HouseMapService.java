package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.HouseInfoDto;
import com.ssafy.happyhouse.dto.SidoGugunCodeDto;

public interface HouseMapService {
	
	public List<SidoGugunCodeDto> getSido() throws Exception;
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;
	public List<HouseInfoDto> getAptInDong(String dong) throws Exception;
	public List<HouseInfoDto> getAptDetail(String aptdetail) throws Exception;
	public HouseDealDto getDetail(String aptName, String dongCode) throws Exception;
	
}

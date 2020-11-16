package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.HouseMapDao;
import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.HouseInfoDto;
import com.ssafy.happyhouse.dto.SidoGugunCodeDto;

@Service
public class HouseMapServiceImpl implements HouseMapService {
	
	@Autowired
	HouseMapDao dao;
	
	private static HouseMapService houseMapService;
	
//	private HouseMapServiceImpl() {}
//	
//	public static HouseMapService getHouseMapService() {
//		if(houseMapService == null)
//			houseMapService = new HouseMapServiceImpl();
//		return houseMapService;
//	}

	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return dao.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return dao.getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		System.out.println(gugun);
		List<HouseInfoDto> litt = dao.getDongInGugun(gugun);
		System.out.println(litt.size());
		return litt;
//		return dao.getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
		return dao.getAptInDong(dong);
	}
	
	@Override
	public List<HouseInfoDto> getAptDetail(String aptdetail) throws Exception {
		return dao.getAptDetail(aptdetail);
	}
	
	@Override
	public HouseDealDto getDetail(String aptName, String dongCode) throws Exception {
		return dao.getDetail(aptName, dongCode);
	}

}

package com.ssafy.term4.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.term4.model.dao.RegistDao;

import model.RegistDto;

@Service
public class RegistServiceImpl implements RegistService {
	
	@Autowired
	private RegistDao registDao;

	@Override
	public void createRegist(RegistDto registDto) throws Exception {
		registDao.createRegist(registDto);
	}

	@Override
	public List<RegistDto> listRegist(Map<String, String> map) throws Exception {
		return registDao.listRegist(map);
	}

	@Override
	public RegistDto getRegist(int ccode) throws Exception {
		return registDao.getRegist(ccode);
	}

	@Override
	public void deleteRegist(int ccode) throws Exception {
		registDao.deleteRegist(ccode);
	}

	
}

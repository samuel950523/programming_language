package com.mycom.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.dao.BasicDao;

@Service
public class BasicServiceImpl implements BasicService {

	@Autowired
	BasicDao basicDao;
	
	@Override
	public String basic() {
		return basicDao.basic();
	}

}

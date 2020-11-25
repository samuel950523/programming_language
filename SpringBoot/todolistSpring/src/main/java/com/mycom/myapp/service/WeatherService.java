package com.mycom.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.dao.WeatherDao;
import com.mycom.myapp.dto.Weather;

@Service
public class WeatherService {
	@Autowired
	WeatherDao dao;
	
	public List<Weather> list(){
		return dao.list();
	}
}

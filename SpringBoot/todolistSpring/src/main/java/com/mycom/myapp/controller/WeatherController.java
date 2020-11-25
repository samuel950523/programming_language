package com.mycom.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.dto.Weather;
import com.mycom.myapp.service.WeatherService;

@RestController
public class WeatherController {
	
	@Autowired
	WeatherService weatherService;
	
	@CrossOrigin(origins = "http://localhost:4000")
	@GetMapping("/weather")
	public List<Weather> showWeather () {
		
		List<Weather> weather = weatherService.list();
		
		return weather;
	}
}
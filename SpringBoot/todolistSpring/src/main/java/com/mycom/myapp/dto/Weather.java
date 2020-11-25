package com.mycom.myapp.dto;

public class Weather {
	String region;
	String time;
	String weather;
	int rain;
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getRain() {
		return rain;
	}
	public void setRain(int rain) {
		this.rain = rain;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
}

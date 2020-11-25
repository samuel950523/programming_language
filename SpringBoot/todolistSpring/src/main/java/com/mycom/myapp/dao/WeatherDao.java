package com.mycom.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mycom.myapp.dto.Weather;

@Mapper
public interface WeatherDao {
	@Select("SELECT * from weather")
    public List<Weather> list();
}

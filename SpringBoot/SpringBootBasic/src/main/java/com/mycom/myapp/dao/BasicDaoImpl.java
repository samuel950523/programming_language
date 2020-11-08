package com.mycom.myapp.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BasicDaoImpl implements BasicDao{

	@Override
	public String basic() {
		return "Spring Boot ÀßµÈ´Ù!!!!!!!!!!!!!!!!!";
	}

}
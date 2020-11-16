package com.ssafy.happyhouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ssafy.happyhouse.dao")
public class Happyhouse61Application {

	public static void main(String[] args) {
		SpringApplication.run(Happyhouse61Application.class, args);
	}

}

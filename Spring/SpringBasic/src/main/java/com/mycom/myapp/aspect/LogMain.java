package com.mycom.myapp.aspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aspect.xml");

		Logger log = (Logger) context.getBean(Logger.class);
		log.log();
		
		context.close();
	}
}

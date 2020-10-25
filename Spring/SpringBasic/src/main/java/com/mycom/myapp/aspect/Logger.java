package com.mycom.myapp.aspect;

import org.springframework.stereotype.Component;

@Component 
public class Logger {
	public void log() {
		System.out.println("Logger : log() is called!!");
	}
}

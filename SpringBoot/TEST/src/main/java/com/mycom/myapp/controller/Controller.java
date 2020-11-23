package com.mycom.myapp.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {
 
	@CrossOrigin(origins = "http://localhost:4000")
	@GetMapping("/test")
	public String test() {
		
		return "asdfasdfasdf";
	}
}

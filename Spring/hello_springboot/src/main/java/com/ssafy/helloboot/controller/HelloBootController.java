package com.ssafy.helloboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloBootController {
	@GetMapping(value="/")
	public String hello(Model model) {
		model.addAttribute("message","안녕하세요 Spring Boot@@@");
		return "hello";
	}
}

package com.mycom.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoggerController {
	private static final Logger logger = LoggerFactory.getLogger(LoggerController.class);

	@RequestMapping("/logger")
	public void logger() {
		logger.error(this.getClass().getName() + " : Custom Error Code : " + HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping("/logger2")
	public void logger2(String code) {
		switch (code) {
		case "trace": logger.trace(this.getClass().getName() + " : Custom trace Message : Test Trace"); break;
		case "debug": logger.debug(this.getClass().getName() + " : Custom debug Message : Test Debug"); break;
		case "info": logger.info(this.getClass().getName() + " : Custom info Message : Test Info"); break;
		case "warn": logger.warn(this.getClass().getName() + " : Custom warn Message : Test Warn"); break;
		case "error": logger.error(this.getClass().getName() + " : Custom error Message : " + HttpStatus.INTERNAL_SERVER_ERROR); break;
		}
	}
}

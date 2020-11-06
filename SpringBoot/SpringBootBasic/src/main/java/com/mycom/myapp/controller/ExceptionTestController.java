package com.mycom.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionTestController {
	@GetMapping(value = "/exceptions")
	private void makeException() {
		throw new RuntimeException();
	}

//	@ExceptionHandler(Exception.class)
//	public ModelAndView handleErrorView(HttpServletRequest req, Exception ex) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception", ex);
//		mav.addObject("url", req.getRequestURL());
//		mav.setViewName("error");
//		return mav;
//	}

//	@ExceptionHandler(Exception.class)
//	public String hadleErrorView() {
//		return "error";
//	}
	
}

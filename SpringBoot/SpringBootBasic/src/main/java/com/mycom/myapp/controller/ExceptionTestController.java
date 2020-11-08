package com.mycom.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionTestController {
   
   @GetMapping(value="/exceptions")
   private void makeException() {
      throw new RuntimeException();
   }
   
//   @ExceptionHandler(Exception.class)
//   public ModelAndView handleErrorView(HttpServletRequest req, Exception ex) {
//      ModelAndView mav = new ModelAndView();
//      mav.addObject("exception", ex);
//      mav.addObject("url", req.getRequestURL());
//      mav.setViewName("error");
//      return mav;
//   }
   
}
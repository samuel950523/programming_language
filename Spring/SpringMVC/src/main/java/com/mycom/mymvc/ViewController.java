package com.mycom.mymvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.mymvc.dto.EmpDto;

@Controller
public class ViewController {
	// String
	@GetMapping(value = "/viewTest1")
	public String viewTest1() {
		System.out.println("viewTest1");
		return "viewTest1";
	}

	// String
	@GetMapping(value = "/viewTest2")
	public String viewTest2() {
		System.out.println("viewTest2");
		return "sub/viewTest2";
	}

	// String - model
	@GetMapping(value = "/viewTest3")
	public String viewTest3(Model model) {
		System.out.println("viewTest3");
		model.addAttribute("seq", "12345");
		model.addAttribute("empDto", new EmpDto(2001, "Gang-In", "Lee", "loveyou@heroes.com", "2001-02-19"));
		return "viewTest3";
	}

	// ModelAndviewTest
	@GetMapping(value = "/viewTest4")
	public ModelAndView viewTest4() {
		System.out.println("viewTest4");

		ModelAndView mav = new ModelAndView("viewTest4");

		// mav.setViewName("viewTest4");
		mav.addObject("seq", "98765");
		mav.addObject("empDto", new EmpDto(1953, "Boom", "Cha", "cha@heroes.com", "1953-05-22"));
		return mav;
	}
	
    // Redirect
    @GetMapping(value="/redirect")
    public String redirect() {
        System.out.println("redirect");
        return "redirect:/viewTest1";
    }
}

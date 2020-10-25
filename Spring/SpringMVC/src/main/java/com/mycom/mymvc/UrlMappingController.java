package com.mycom.mymvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="mvc")
public class UrlMappingController {

	@RequestMapping(value = "/hello")

	public void m1() {
		System.out.println("/hello");
	}

	// Sub URL
	@RequestMapping(value = "/hello/ssafy")
	public void m2() {
		System.out.println("/hello/ssafy");
	}

	// Ambiguos Mapping
//	@RequestMapping(value = "/hello")
//	public void m3() {
//		System.out.println("/hello");
//	}

	// Multiple URL Mapping
	@RequestMapping(value = { "/url1", "url2" })
	public void m4() {
		System.out.println("/url1 /url2");
	}

	// With Http Request Method
	@RequestMapping(value = "/method", method = RequestMethod.GET)
	public void m5() {
		System.out.println("/get");
	}

	@RequestMapping(value = "/method", method = RequestMethod.POST)
	public void m6() {
		System.out.println("/post");
	}

	@RequestMapping(value = "/method", method = RequestMethod.PUT)
	public void m7() {
		System.out.println("/put");
	}

	@RequestMapping(value = "/method", method = RequestMethod.DELETE)
	public void m8() {
		System.out.println("/delete");
	}
	
	// Get Only
	@GetMapping(value="/getMapping")
	public void m9() {
		System.out.println("/getmapping");
	}
	
	// Post Only
	@PostMapping(value="/postMapping")
	public void m10() {
		System.out.println("/postmapping");
	}
	
	
	

}

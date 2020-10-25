package com.mycom.mymvc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycom.mymvc.dto.CarDto;

@Controller
public class ParamController {

	// http://localhost:8080/mymvc/param1?seq=123
	@GetMapping(value = "/param1")
	public void m1(HttpServletRequest request) {
		String seq = request.getParameter("seq");
		System.out.println("param1 seq : " + seq);
	}

	// http://localhost:8080/mymvc/param2?seq=123
	@GetMapping(value = "/param2")
	public void m2(String seq) {
		System.out.println("param2 seq : " + seq);
	}

	// http://localhost:8080/mymvc/param3?seq=123
	@GetMapping(value = "/param3")
	public void m3(@RequestParam(name = "seq") String str) {
		System.out.println("param3 seq : " + str);
	}

	// http://localhost:8080/mymvc/car1?name=GENESIS&price=40000
	@GetMapping("/car1")
	public void v4(String name, int price) {
		System.out.println("car1 name : " + name);
		System.out.println("car1 price : " + price);
	}

	// CarDto #1
	// Check Owner -> null
	// Change setName() -> setName2()
	// http://localhost:8080/mymvc/car2?name=GENESIS&price=40000
	@GetMapping("/car2")
	public void m5(CarDto dto) {
		System.out.println("car2 Name : " + dto.getName());
		System.out.println("car2 Price : " + dto.getPrice());
		System.out.println("car2 Owner : " + dto.getOwner());
	}

	// CarDto #2
	// Check Owner -> null
	// paramController.html
	@PostMapping("/car3")
	public void m6(CarDto dto) {
		System.out.println("car3 Name : " + dto.getName());
		System.out.println("car3 Price : " + dto.getPrice());
		System.out.println("car3 Owner : " + dto.getOwner());
	}

	// @PathVarialbe
	// Test: http://localhost:8080/mymvc/pathvariable/12345
	@GetMapping(value = "pathvariable/{seq}")
	public void m7(@PathVariable int seq) {
		System.out.println("pathvariable/{seq} seq : " + seq);
	}

	// Map for Multiple Parameters Together
	// http://localhost:8080/mymvc/map?name=hong&phone=01000001111&email=hong@abc.com
	@GetMapping("/map")
	public void m8(@RequestParam Map<String, String> params) {
		System.out.println(params.entrySet());
		System.out.println(params.get("name"));
		System.out.println(params.get("phone"));
		System.out.println(params.get("email"));
	}

	// @RequestHeader
	@GetMapping("/requestHeader")
	public void m9(
			@RequestHeader(value = "Accept") String accept,
			@RequestHeader(value = "User-Agent", defaultValue = "myBrowser") String userAgent,
			@RequestHeader(value = "Host") String host
			) {
		System.out.println("requestHeader accept : " + accept);
		System.out.println("requestHeader userAgent : " + userAgent);
		System.out.println("requestHeader host : " + host);
	}
}

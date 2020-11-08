package com.mycom.myboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@GetMapping(value = { "/", "/board" })
	private String home() {
		return "board/boardMain";
	}

	@GetMapping("/login")
	private String login() {
		return "login";
	}

}

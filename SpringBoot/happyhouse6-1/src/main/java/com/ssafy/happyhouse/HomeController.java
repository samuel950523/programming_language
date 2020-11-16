package com.ssafy.happyhouse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

   @GetMapping(value = { "/search" })
   private String search() {
      return "search";
   }

   @GetMapping(value = { "/", "Main" })
   private String login() {
      return "Main";
   }

   @GetMapping(value = { "/hospital" })
   private String hospital() {
      return "hospital";
   }
   
   @GetMapping(value = { "/corona" })
   private String corona() {
      return "corona";
   }
   
   @GetMapping(value = { "/interestsearch" })
   private String interest() {
      return "interestsearch";
   }
   
   @GetMapping(value = {"/notice"})
   private String notice() {
       return ("board/boardMain");
   }
}
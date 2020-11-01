package com.ssafy.term4.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.term4.service.RegistService;

import model.MemberDto;
import model.RegistDto;

@Controller
@RequestMapping("/regist")
public class RegistController {

	@Autowired
	private RegistService registService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "regist/create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(RegistDto registDto, Model model, HttpSession session) {
		try {
			registService.createRegist(registDto);
			return "include/regist";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "등록 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@RequestParam Map<String, String> map, Model model) {
		try {
			List<RegistDto> list = registService.listRegist(map);
			model.addAttribute("countrystatuss", list);
			return "regist/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "글목록을 얻어오는 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("ccode") int ccode, Model model) {
		try {
			registService.deleteRegist(ccode);;
			return "redirect:list?pg=1&key=&word=";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "글삭제 처리 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
}

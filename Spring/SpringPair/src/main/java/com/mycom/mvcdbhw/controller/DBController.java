package com.mycom.mvcdbhw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.mvcdbhw.dto.QuizDto;
import com.mycom.mvcdbhw.service.DBService;

@Controller
public class DBController {

	@Autowired
	DBService service;

	@GetMapping(value = "/quizDetail/{quizloyeeId}")
	@ResponseBody
	public QuizDto quizDetail(@PathVariable int quizloyeeId) {
		System.out.println(quizloyeeId);
		QuizDto quizDto = service.quizDetail(quizloyeeId);
		return quizDto;
	}

	@GetMapping(value = "/quizDetailNormal/{quizloyeeId}")
//	@ResponseBody
	public String quizDetailNormal(@PathVariable int quizloyeeId, Model model) {
		System.out.println(quizloyeeId);
		QuizDto quizDto = service.quizDetail(quizloyeeId);
		model.addAttribute("quizDto", quizDto);
		return "detail";
	}

	@GetMapping(value = "/quizList")
	@ResponseBody
	public List<QuizDto> quizList() {
		List<QuizDto> list = service.quizList();
		return list;
	}

	@PostMapping(value = "/quizInsert")
	@ResponseBody
	public int quizInsert(QuizDto quizDto) {
		System.out.println(quizDto);
		int ret = service.quizInsert(quizDto);
		return ret;
	}

	@PostMapping(value = "/quizInsertJSON")
	@ResponseBody
	public int quizInsertJSON(@RequestBody QuizDto quizDto) {
		System.out.println(quizDto);
		int ret = service.quizInsert(quizDto);
		return ret;
	}

	@PostMapping(value = "/quizUpdate")
	@ResponseBody
	public int quizUpdate(QuizDto quizDto) {
		System.out.println(quizDto);
		int ret = service.quizUpdate(quizDto);
		return ret;
	}

	@PostMapping(value = "/quizDelete")
	@ResponseBody
	public int quizDelete(int quizloyeeId) {
		System.out.println(quizloyeeId);
		int ret = service.quizDelete(quizloyeeId);
		return ret;
	}
}

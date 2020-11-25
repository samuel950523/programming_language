package com.mycom.myapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.dto.Memo;
import com.mycom.myapp.service.TodolistService;

@RestController
public class BoardController {
	
	@Autowired
	TodolistService todolistService;
	
	@CrossOrigin(origins = "http://localhost:4000")
	@PostMapping("/todo")
	public int createTodo ( @RequestBody Memo memo ) {
		
		int result = todolistService.create(memo);
		System.out.println("create만들기");
		return result;
	}
	
	@CrossOrigin(origins = "http://localhost:4000")
	@GetMapping("/todolist")
	public List<Memo> showTodolist(@RequestParam(value="createdAt", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate createdAt) {
		System.out.println(createdAt); //날짜 출력해주고
		
		List<Memo> memo = todolistService.list(createdAt); //service에 내가 선택한 날짜를 파라미터로 넣기 
		
		return memo;
	}
	@CrossOrigin(origins = "http://localhost:4000")
	@PutMapping("/todo")
	public void memoUpdate (@RequestBody Memo memo) {
		
		System.out.println(memo.getId() +" "+ memo.getContent());
		todolistService.update(memo);
	}
	
	@CrossOrigin(origins = "http://localhost:4000")
	@DeleteMapping("/todo/{id}")
	public void memoDelete (@PathVariable int id) {
		todolistService.delete(id);
	}
}

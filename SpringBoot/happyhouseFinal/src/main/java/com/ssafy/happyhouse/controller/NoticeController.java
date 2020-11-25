package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Notice;
import com.ssafy.happyhouse.service.NoticeService;


@RestController
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	@CrossOrigin(origins = "http://localhost:4000")
	@PostMapping("/notice")
	public int createNotice ( @RequestBody Notice notice ) {
		
		int result = noticeService.create(notice);
		System.out.println("create");
		return result;
	}
	
	@CrossOrigin(origins = "http://localhost:4000")
	@GetMapping("/noticelist")
	public List<Notice> showNotice () {
		
		List<Notice> notice = noticeService.list();
		
		
		return notice;
	}
	
	@CrossOrigin(origins = "http://localhost:4000")
	@PutMapping("/notice")
	public void noticeUpdate (@RequestBody Notice notice) {
		
		System.out.println(notice.getId() +" "+ notice.getContent());
		noticeService.update(notice);
	}
	
	@CrossOrigin(origins = "http://localhost:4000")
	@DeleteMapping("/notice/{id}")
	public void noticeDelete (@PathVariable int id) {
		noticeService.delete(id);
	}
}

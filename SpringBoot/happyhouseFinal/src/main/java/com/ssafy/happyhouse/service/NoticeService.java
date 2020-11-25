package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.NoticeDao;
import com.ssafy.happyhouse.dto.Notice;

@Service
public class NoticeService {
	
	@Autowired
	NoticeDao dao;
	
	public int create(Notice notice) {
		
		int get = dao.save(notice);
		
		System.out.println(notice.getId());
		
		return notice.getId();
		
	}
	
	public List<Notice> list(){
		return dao.list();
	}
	
	public void update(Notice notice) {
		dao.noticeUpdate(notice);
	}
	
	public void delete(int id) {
		dao.noticeDelete(id);
	}
}

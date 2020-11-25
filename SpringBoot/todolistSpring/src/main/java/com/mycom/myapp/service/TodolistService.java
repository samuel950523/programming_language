package com.mycom.myapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.dao.MemoDao;
import com.mycom.myapp.dto.Memo;

@Service
public class TodolistService {
	
	@Autowired
	MemoDao dao;
	
	public int create(Memo memo) {
		System.out.println("³¯Â¥ : " + memo.getCreatedAt());
		int get = dao.save(memo);
		System.out.println(memo.getId());
		return memo.getId();
		
	}
	
	public List<Memo> list(LocalDate createdAt){
		if(createdAt != null) {
			return dao.getListByCreatedAt(createdAt);
		}else {
			return dao.list();
		}	
	}
	
	public void update(Memo memo) {
		dao.memoUpdate(memo);
	}
	
	public void delete(int id) {
		dao.memoDelete(id);
	}
}

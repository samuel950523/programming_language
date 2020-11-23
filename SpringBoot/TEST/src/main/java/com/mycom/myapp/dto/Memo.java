package com.mycom.myapp.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Memo {
	String content;
	int id;
	LocalDate createdAt;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(@DateTimeFormat(pattern="yyyy-MM-dd") LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
//	public void setCreatedAt(String createdAt) {
//		System.out.println(createdAt);
//		//System.out.println("@@@@@@@");
//		//this.createdAt = LocalDate.now();
//	}
	
}

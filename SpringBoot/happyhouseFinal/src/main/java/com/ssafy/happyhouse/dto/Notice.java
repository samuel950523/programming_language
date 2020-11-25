package com.ssafy.happyhouse.dto;

import java.time.LocalDate;

public class Notice {
	int id;
	String title;
	String content;
	LocalDate createtime = LocalDate.now();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDate getCreatetime() {
		return createtime;
	}
	public void setCreatetime(LocalDate createtime) {
		this.createtime = createtime;
	}
	
	
	
}

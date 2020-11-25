package com.ssafy.happyhouse.dto;

import java.time.LocalDate;

public class MemberDto {
	private int userSeq;
	private String userName;
	private String userPassword;
	private String userEmail;
//	private String userRegisterDate;
	LocalDate userRegisterDate = LocalDate.now();

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public LocalDate getUserRegisterDate() {
		return userRegisterDate;
	}

	public void setUserRegisterDate(LocalDate userRegisterDate) {
		this.userRegisterDate = userRegisterDate;
	}

}

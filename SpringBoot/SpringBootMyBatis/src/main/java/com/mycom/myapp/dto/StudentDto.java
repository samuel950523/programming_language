package com.mycom.myapp.dto;

public class StudentDto {
	private int studentId;
	private String studentNm;
	private String email;
	private int phone;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentNm() {
		return studentNm;
	}

	public void setStudentNm(String studentNm) {
		this.studentNm = studentNm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}

	public StudentDto() {}
	
	public StudentDto(int studentId, String studentNm, String email, int phone) {
		super();
		this.studentId = studentId;
		this.studentNm = studentNm;
		this.email = email;
		this.phone = phone;
	}

	
}

package com.mycom.mvcdbhw.dto;

public class QuizDto {
	private int q_index;
	private String first_name;
	private String last_name;
	private String email;
	private String joindate;

	public QuizDto() {}
	
	public QuizDto(int q_index, String first_name, String last_name, String email, String joindate) {
		super();
		this.q_index = q_index;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.joindate = joindate;
	}

	public int getQ_index() {
		return q_index;
	}

	public void setQ_index(int q_index) {
		this.q_index = q_index;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "QuizDto [q_index=" + q_index + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", joindate=" + joindate + "]";
	}

}
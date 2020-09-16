package com.ssafy.employee.sub;

import com.ssafy.employee.Employee;

public class Engineer extends Employee {
	String skill = "기술";

	public Engineer(String name, int salary, String skill) {
		super(name, salary);
		this.skill = skill;
	}

	public Engineer() {
		super();
	}

//	public String getInfo() { // 새로운 메소드 추가
//		return "이름 : " + name + ", 월급여 : " + salary + "원, 기술 : " + skill;
//	}

	// 재정의1 : 부모의 메소드 내용 전부를 변경
	// 재정의2 : 부모의 메소드 내용에 자신이 확장한 상황을 반영하는 변경
	public String getInformation() { // 기존 메소드 재정의
		return super.getInformation() + ", 기술 : " + skill;
	}
}

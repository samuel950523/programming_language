package com.ssafy.employee;

public class Employee {
	protected String name;
	protected int salary;

	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Employee() {

	}

	public String getInformation() {
		return "이름 : " + name + ", 월급여 : " + salary + "원";
	}
}

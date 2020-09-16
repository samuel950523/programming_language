package com.ssafy.employee.sub;

import com.ssafy.employee.Employee;

public class Manager extends Employee {
	String department;
	
	
	public Manager(String name, int salary, String department) {
		super(name, salary);
		this.department = department;
	}


	public Manager() {
		super();
	}
}

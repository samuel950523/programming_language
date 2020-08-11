package com.ssafy.employee;

public class Company {

	public static void increaseSalary(Employee emp) {
		emp.salary += 1000000;
		if (emp instanceof Engineer) {
			Engineer eg = (Engineer) emp;
			eg.skill += ",AI";
		}
	}
}

package com.ssafy.employee;

public class PolymorphismTest {
	public static void main(String[] args) {
		Employee eg = new Engineer("김태희", 5000000, "자바");
		eg = new Manager("홍길동", 7000000, "개발2팀");

//		eg.skill += ", 알고리즘"; // Engineer
		eg.salary += 1000000; // Employee
//		System.out.println(eg.getInformation());
//		System.out.println(eg.toString());

		Employee[] emps = new Employee[2];

		emps[0] = new Engineer("김태희", 5000000, "자바");
		emps[1] = new Manager("홍길동", 7000000, "개발2팀");
		
		for (Employee employee : emps) {
			System.out.println(employee.getInformation());
		}
		
		Company.increaseSalary(new Engineer("김태희", 5000000, "자바"));
		Company.increaseSalary(new Manager("홍길동", 7000000, "개발2팀"));
	}
}

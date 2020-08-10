package com.ssafy.employee.sub;

public class InheritanceTest {
	public static void main(String[] args) {
		Engineer eg = new Engineer("김태희", 5000000, "자바");
		System.out.println(eg.getInformation());

		Manager m = new Manager("홍길동", 7000000, "개발2팀");
		System.out.println(m.getInformation());
	}
}

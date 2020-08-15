package com.ssafy;

public class FactorialTest {

	// 메소드 정의 : n! 계산
	private static int factorial(int n) {

		if (n <= 1)
			return 1;
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		int N = 5;
		System.out.println(factorial(N));
	}	
}

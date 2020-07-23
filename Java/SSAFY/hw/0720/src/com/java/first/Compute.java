package com.java.first;
import java.util.Scanner;

public class Compute {
	public static void main(String[] args) {
		// 두 개의 정수를 입력 받아 곱과 몫을 출력
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.println("곱="+num1*num2);
		System.out.println("몫="+num1/num2);
		sc.close();
	}
}

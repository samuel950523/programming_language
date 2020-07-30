package com.ssafy;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수, 실수, 문자열을 차례로 입력하세요.");
		System.out.println(sc.nextInt());
		System.out.println(sc.nextDouble());
//		System.out.println(sc.next());
		System.out.println(sc.nextLine());
		sc.close();
	}
}

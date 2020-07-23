package com.java.first;
import java.util.Scanner;

public class CheckPoint {
	public static void main(String[] args) {
		// 비만 여부 출력
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		int bmi = w+100-h;
		System.out.println("비만수치는 "+bmi+"입니다.");
		
		if (bmi>0) {
			System.out.println("당신은 비만이군요");
		}
		
		sc.close();
	}
}

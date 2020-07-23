package com.ssafy.condition;

public class LoopTest {
	public static void main(String[] args) {
		// 선조건 후수행
		// 0 ~ N
		// for : 반복 횟수가 명확, while : 반복 횟수가 불명확(조건이 만족할동안 수행)

//		int sum=0;
//		for (int i = 1; i <= 10; ++i) {
//			if (i==7) continue;
//			sum+=i;
//		}
//		System.out.println(sum);
//
//		int i = 1;
//		int sum = 0;
//		while (i <= 10) {
//			if (i==7) continue;
//			sum += i;
//			i++;
//		}
//		System.out.println(sum);

	//		int i = 0, sum = 0;
	//		while (++i <= 10) {
	//			if (i == 7)
	//				continue;
	//			sum += i;
	//		}
	//		System.out.println(sum);

		// 선수행 후조건 후수행
		// 1 ~ N
		// do~while

//		int i = 1, sum=0;
//		
//		do {
//			sum+=i;
//			i++;
//		} while (i<=10);
//		System.out.println(sum);
	}
}

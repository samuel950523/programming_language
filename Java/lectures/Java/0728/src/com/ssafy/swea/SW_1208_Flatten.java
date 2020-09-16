package com.ssafy.swea;
import java.util.Scanner;

public class SW_1208_Flatten {

	static int[] floor;
	static int minIdx = 99, maxIdx = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {

			int dump = sc.nextInt();
			sc.nextLine();

			floor = new int[100]; // 0 ~ 100

			// 가로 길이는 항상 100
			for (int i = 0; i < 100; i++) {
				floor[i] = sc.nextInt();
			}

			// 최초 최소, 최대 값 index 계산
			resetMinMax();

			for (int i = 0; i < dump; i++) {

				if (floor[maxIdx] - floor[minIdx] == 0 || floor[maxIdx] - floor[minIdx] == 1) {
					break;
				}

				floor[maxIdx]--;
				floor[minIdx]++;

				resetMinMax();
			}

			int result = floor[maxIdx] - floor[minIdx];
			System.out.println("#" + t + " " + result);
		}

		sc.close();
	}

	// floor[] 값 중 최대, 최소 의 index 계산
	static void resetMinMax() {
		for (int i = 0; i < 100; i++) {

			if (floor[i] < floor[minIdx]) {
				minIdx = i;
			}

			if (floor[i] > floor[maxIdx]) {
				maxIdx = i;
			}
		}
	}
}

/*
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=
 * AV139KOaABgCFAYh
 */


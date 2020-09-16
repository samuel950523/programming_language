package com.ssafy.swea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SW_1208_Flatten2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {

			int dump = sc.nextInt();
			sc.nextLine();

			ArrayList<Integer> floor = new ArrayList<>();

			// 가로 길이는 항상 100
			for (int i = 0; i < 100; i++) {
				floor.add(i);
			}

			for (int i = 0; i < 100; i++) {
				int tmp = sc.nextInt();
				floor.set(i, tmp);

			}

			Collections.sort(floor);

			for (int i = 0; i < dump; i++) {

				if (floor.get(99) - floor.get(0) == 0 || floor.get(99) - floor.get(0) == 1) {
					break;
				}

				floor.set(0, floor.get(0) + 1);
				floor.set(99, floor.get(99) - 1);

				Collections.sort(floor);
			}

			int result = floor.get(99) - floor.get(0);
			System.out.println("#" + t + " " + result);
		}

		sc.close();
	}
}

/*
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=
 * AV139KOaABgCFAYh
 */

/*
 * Collection.sort() 이용 <-- ArrayList 로 저장소 구현
 * 
 * sort 하고 최소 최대 바꾸고 다시 sort 하고...계속
 */

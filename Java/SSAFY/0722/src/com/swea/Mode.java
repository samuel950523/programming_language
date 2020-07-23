package com.swea;

import java.util.Scanner;

public class Mode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int trash = sc.nextInt(); // 테케 번호는 왜 주는지 모르겠다.
			// 학생의 점수는 0점 이상 100점 이하 (101개의 점수)
			int[] score = new int[101];
			// 학생 수는 항상 1000명
			for (int i = 0; i < 1000; i++) {
				score[sc.nextInt()]++;
			}

			int mode = score[0];
			int ans = 0;
			for (int i = 1; i < score.length; i++) {
				if (mode <= score[i]) {
					mode = score[i];
					ans = i;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}

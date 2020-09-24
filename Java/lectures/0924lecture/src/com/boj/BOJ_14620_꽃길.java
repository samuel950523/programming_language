package com.boj;

import java.util.Scanner;

public class BOJ_14620_꽃길 {
	static int n, ans;
	static int[][] map;
	static int[][] costmap;

	public static void main(String[] args) {

		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// cost map 만들어줌
		costmap= new int[n][n];
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				costmap[i][j] = map[i][j] + map[i - 1][j] + map[i][j + 1] + map[i + 1][j] + map[i][j - 1];
			}
		}

		ans = Integer.MAX_VALUE;

		// 동작
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				first(i, j, costmap[i][j]); // 첫번째 꽃 심기
			}
		}
		
		System.out.println(ans);
		sc.close();
	}

	private static void first(int fr, int fc, int cost) {
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				int d = (int) (Math.pow((Math.abs(fr - i)), 2) + Math.pow(Math.abs(fc - j), 2));
				if (d < 5)
					continue; // 겹치는 경우
				second(fr, fc, i, j, cost + costmap[i][j]); // 두번째 꽃 심기
			}
		}
	}

	private static void second(int fr, int fc, int sr, int sc, int cost) {
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				int d1 = (int) (Math.pow((Math.abs(fr - i)), 2) + Math.pow(Math.abs(fc - j), 2));
				int d2 = (int) (Math.pow((Math.abs(sr - i)), 2) + Math.pow(Math.abs(sc - j), 2));
				if (d1 < 5 || d2 < 5)
					continue; // 둘 중 하나라도 겹치는 경우
				// 심을 수 있을 때 cost 계산
				ans = Math.min(ans, cost + costmap[i][j]);

			}
		}
	}

}

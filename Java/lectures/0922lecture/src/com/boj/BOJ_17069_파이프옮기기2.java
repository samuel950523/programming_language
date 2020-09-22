package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17069_파이프옮기기2 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static long ans;
	static int[][] map;
	static long[][][] dp;
	static int[] dx = { 0, 1, 1 }; // 가로 세로 대각선
	static int[] dy = { 1, 0, 1 };

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new long[n][n][3]; // direction
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		func(0, 1, 0);
	}

	private static void func(int r, int c, int dir) {
		if (r == n - 1 && c == n - 1) {
			ans++;
			return;
		}
		
	}

}

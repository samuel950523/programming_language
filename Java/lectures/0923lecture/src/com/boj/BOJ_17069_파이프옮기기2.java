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
		map = new int[n+2][n+2]; // n+2로 크기를 주면 절대 밖을 벗어나지 않는다.
		dp = new long[n+2][n+2][3]; // direction
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[1][2][0] = 1; // 맨 처음 파이프
		System.out.println(func());
	}

	private static long func() {
		for (int r = 1; r < n+1; r++) {
			for (int c = 1; c < n+1; c++) {
				// 현재 방향에서 놓을 수 있는 경우의 수
				if (map[r][c + 1] == 0) // 가로
					dp[r][c + 1][0] += dp[r][c][0] + dp[r][c][2];
				if (map[r + 1][c] == 0) // 세로
					dp[r + 1][c][1] += dp[r][c][1] + dp[r][c][2];
				if (map[r + 1][c] == 0 && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0) // 대각선
					dp[r + 1][c + 1][2] += dp[r][c][0] + dp[r][c][1] + dp[r][c][2];
			}
		}
		ans = 0;
		for (int i = 0; i < 3; i++) {
			ans += dp[n][n][i];
		}
		return ans;
	}

}

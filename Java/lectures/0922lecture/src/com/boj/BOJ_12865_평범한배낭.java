package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, k, w, v, ans;
	static int[][] item;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[n + 1][k + 1];
		item = new int[n + 1][2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			item[i][0] = Integer.parseInt(st.nextToken());
			item[i][1] = Integer.parseInt(st.nextToken());
		}

		// 동작
		for (int i = 1; i <= n; i++) {
			w = item[i][0];
			v = item[i][1];
			for (int j = 0; j <= k; j++) {
				if (w > j) // 물건 못 담을때
					dp[i][j] = dp[i - 1][j];
				else // 담을 수 있을 때
					// 이전 최대가치 vs 이 물건을 담고 남은 공간에 채웠을때 최대 가치
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
			}
		}
		System.out.println(dp[n][k]);
	}
}

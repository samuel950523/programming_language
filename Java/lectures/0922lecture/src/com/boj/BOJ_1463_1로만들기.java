package com.boj;

import java.util.Scanner;

public class BOJ_1463_1로만들기 {
	static int n, ans;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[1000001];
		ans = 0;
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i < n + 1; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
		}

		System.out.println(dp[n]);
		sc.close();
	}

}

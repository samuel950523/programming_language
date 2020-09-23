package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7393_대규의팬덤활동 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, t;
	static int visit;
	static long MOD = 1000000000;
	static long ans;
	static long[][][] dp;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			visit = 1 << 10; // 체크용
			dp = new long[101][10][visit];
			ans = 0;
			System.out.println("#" + tc + " " + func());
		}
	}

	private static long func() {
		for (int i = 1; i <= 9; i++) { // 0으로 시작하는 수는 없다.
			dp[1][i][1 << i] = 1; // n=1일때 채워주기 (맨 앞자리)
		}

		for (int i = 2; i <= n; i++) { // 2자리수부터 n자리수까지
			for (int j = 0; j <= 9; j++) { // 0~9
				for (int k = 0; k < visit; k++) {
					int temp = k | (1 << j);
					// 1씩 차이나게
					if (j == 0) {
						dp[i][0][temp] = (dp[i][0][temp] + dp[i - 1][1][k]) % MOD;
					} else if (j == 9) {
						dp[i][9][temp] = (dp[i][9][temp] + dp[i - 1][8][k]) % MOD;
					} else {
						dp[i][j][temp] = (dp[i][j][temp] + dp[i - 1][j - 1][k]) % MOD;
						dp[i][j][temp] = (dp[i][j][temp] + dp[i - 1][j + 1][k]) % MOD;
					}
				}
			}
		}

		for (int j = 0; j <= 9; j++) {
			ans = (ans + dp[n][j][visit - 1]) % MOD;
		}
		
		return ans;
	}
}

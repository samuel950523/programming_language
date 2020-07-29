/* 2001. 파리 퇴치 [D2]
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq
 */

package com.hw;

import java.util.Scanner;

public class hw_algo0729_서울_5반_서정준 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			// 입력
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 구현
			int ans = 0;
			for (int i = 0; i <= n - m; i++) {
				for (int j = 0; j <= n - m; j++) {
					int cnt = 0;
					for (int k = 0; k < m; k++) {
						for (int k2 = 0; k2 < m; k2++) {
							cnt += map[i + k][j + k2];
						}
					}
					if (ans < cnt)
						ans = cnt;
				}
			}
			// 출력
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}

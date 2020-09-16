package com.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static int n, t;
	static int[][] map;
	static int ans;
	static int[] numbers;
	static int sum;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		for (int tt = 1; tt <= t; tt++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				str = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
				}
			}

			// 동작
			numbers = new int[n / 2];
			ans = Integer.MAX_VALUE;
			// nC(n/2)
			comb(0, 0);
			bw.write("#" + tt + " " + ans + "\n");
			bw.flush();
		}
		bw.close();
	}

	private static void comb(int cnt, int start) {
		if (cnt == n / 2) {
			func();
			return;
		}

		for (int i = start; i < n; i++) {
			numbers[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	private static void func() {
		int[] others = new int[n / 2];
		int j = 0;
		for (int i = 0; i < n; i++) {
			boolean flag = false;
			for (int k = 0; k < n / 2; k++) {
				if (i == numbers[k]) { // i가 numbers에 포함되어있는지 확인
					flag = true;
					break;
				}
			}
			if (!flag) // 그대로 내려오면
				others[j++] = i; // 그 숫자는 여기에 포함
		}

		// 한 음식의 시너지 계산
		int si1 = 0;
		for (int i = 0; i < n / 2; i++) {
			for (j = 0; j < n / 2; j++) {
				si1 += map[numbers[i]][numbers[j]];
			}
		}
		
		int si2 = 0;
		for (int i = 0; i < n / 2; i++) {
			for (j = 0; j < n / 2; j++) {
				si2 += map[others[i]][others[j]];
			}
		}
		
		int diff = Math.abs(si1-si2);
		ans = Math.min(ans, diff);
	}

}

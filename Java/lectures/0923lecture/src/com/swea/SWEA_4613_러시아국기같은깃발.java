package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4613_러시아국기같은깃발 {
	static BufferedReader br;
	static StringTokenizer st;
	static int t, n, m, ans;
	static int[][] map;
	static int[] numbers;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < m; j++) {
					char c = str.charAt(j);
					if (c == 'W')
						map[i][j] = 1;
					else if (c == 'B')
						map[i][j] = 2;
					else
						map[i][j] = 3;
				}
			}
			// 맨 위는 흰색, 맨 뒤는 빨 고정 (2 빼줌)
//			3Hn-2
			numbers = new int[n - 2];
			ans = Integer.MAX_VALUE;
			comb(0, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void comb(int cnt, int start) {
		if (cnt == n - 2) { // 2 빼주기
			// 조합 완성
			// 여기서 2를 포함한 것만 고려한다.
			for (int i = 0; i < n - 2; i++) {
				if (numbers[i] == 2) {
					func(); // 2를 포함한 것만
					break;
				}
			}
			return;
		}
		for (int i = start; i < 3; i++) {
			numbers[cnt] = i + 1;
			comb(cnt + 1, i);
		}
	}

	private static void func() {
		int cnt = 0;
		// 첫번째 줄을 흰색으로 바꾸는 연산
		for (int j = 0; j < m; j++) {
			if (map[0][j] != 1)
				cnt++;
		}
		// 마지막 줄을 빨간색으로 바꾸는 연산
		for (int j = 0; j < m; j++) {
			if (map[n - 1][j] != 3)
				cnt++;
		}
		// 그 외 줄을 해당되는 색으로 바꾸는 연산
		for (int i = 1; i <= n - 2; i++) {
			int num = numbers[i - 1];
			for (int j = 0; j < m; j++) {
				if (map[i][j] != num) // 해당 색으로 바꿔줌
					cnt++;
			}
		}
		ans = Math.min(ans, cnt);
	}
}

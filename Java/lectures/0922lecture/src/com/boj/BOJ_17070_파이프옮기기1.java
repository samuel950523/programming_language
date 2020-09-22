package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static long ans;
	static int[][] map;
	static int[] dx = { 0, 1, 1 }; // 가로 세로 대각선
	static int[] dy = { 1, 0, 1 };

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 동작
		ans = 0;
		func(0, 1, 0);
		System.out.println(ans);
	}

	private static void func(int r, int c, int pipe) {
		if (r == n - 1 && c == n - 1) { // 도착시
			ans++;
			return;
		}

		for (int dir = 0; dir < 3; dir++) {
			if (dir == 0 && pipe == 1) // 가로 파이프 -> 가로 이동 불가
				continue;
			if (dir == 1 && pipe == 0) // 세로 파이프 -> 세로 이동 불가
				continue;

			int nr = r + dx[dir];
			int nc = c + dy[dir];

			if (nr >= 0 && nc >= 0 && nr < n && nc < n && map[nr][nc] != 1) { // 범위체크
				if (dir == 2 && (map[r][c + 1] == 1 || map[r + 1][c] == 1)) // 대각선일경우 두 개의 벽도 추가로 비어있어야
					continue;

				func(nr, nc, dir); // 이 방향으로 pipe를 놓아서 출발
			}
		}
	}
}

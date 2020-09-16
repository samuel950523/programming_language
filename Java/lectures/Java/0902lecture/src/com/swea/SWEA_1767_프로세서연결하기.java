package com.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서연결하기 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n, maxcnt, ans;
	static int[][] map;
	static ArrayList<int[]> list;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());

			map = new int[n][n];
			list = new ArrayList<int[]>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i == 0 || j == 0 || i == n - 1 || j == n - 1)
						continue; // 이미 전원 연결
					if (map[i][j] == 1) // 전원을 연결해야할 리스트
						list.add(new int[] { i, j });
				}
			}

			// 동작
			maxcnt = Integer.MIN_VALUE;
			ans = Integer.MAX_VALUE;

			func(0, 0, 0);

			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void func(int number, int corecnt, int len) {
		if (number == list.size()) { // 다 탐색하면
			if (maxcnt < corecnt) { // 최대로 많이 연결했으면
				maxcnt = corecnt;
				ans = len; // 그때의 전선 길이 저장
			} else if (maxcnt == corecnt) { // 만약에 여러 방법이 있으면
				ans = Math.min(ans, len); // 전선 길이가 최소가 되게
			}
			return;
		}

		int r = list.get(number)[0];
		int c = list.get(number)[1];
		for (int dir = 0; dir < 4; dir++) {
			int cnt = 0; // 전선 길이 카운트
			int nr = r;
			int nc = c;
			int er = r;
			int ec = c;
			while (true) {
				nr += dx[dir];
				nc += dy[dir];
				// 벽에 닿을때까지 이동
				if (!(nr >= 0 && nc >= 0 && nr <= n - 1 && nc <= n - 1)) // 벽에 닿으면 이 방향(dir)이 맞는 것이다.
					break;
				// 코어를 만나면
				if (map[nr][nc] == 1) { // 처음에는 전류가 흐르는 코어와 전선으로 연결, 또는 붙어있으면 전류가 흐르는 줄 알았다.
					cnt = 0; // 이 방향이 아닌 것
					break;
				}
				cnt++;
			}

			if (cnt == 0) { // while문을 다 돌았는데 cnt가 0이면 이 코어는 전선과 연결이 불가능한것이다.
				func(number + 1, corecnt, len); // 다음 코어를 본다.
			} else {
				// 전선 놓기
				for (int i = 0; i < cnt; i++) { // dir방향으로 전선을 놓는다.
					er += dx[dir];
					ec += dy[dir];
					map[er][ec] = 1; // 전선을 놓았다.
				}

				func(number + 1, corecnt + 1, len + cnt); // 다음 코어를 본다.

				// 백트래킹
				er = r;
				ec = c;

				for (int i = 0; i < cnt; i++) {
					er += dx[dir];
					ec += dy[dir];
					map[er][ec] = 0;
				}
			}

		}

	}
}

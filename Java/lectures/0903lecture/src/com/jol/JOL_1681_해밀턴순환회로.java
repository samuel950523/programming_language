package com.jol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class JOL_1681_해밀턴순환회로 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n, start, sum;
	static int[][] map;
	static int[] distance;
	static boolean[] visited;
	static int ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 단방향
			}
		}

		// 동작
		start = 0;
		ans = Integer.MAX_VALUE;
		visited = new boolean[n];
		visited[start] = true;

		func(0, 1, 0);

		System.out.println(ans);
	}

	private static void func(int loc, int cnt, int sum) {
		if (sum > ans) // 가지치기
			return;


		if (cnt == n) { // 이제 회사로만 돌아가면 됨
			if (map[loc][0] == 0) // 길이 없음
				return;
			ans = Math.min(ans, sum + map[loc][0]); // 최소값 갱신
			return;
		}

		for (int i = 1; i < n; i++) {
			if (loc == i)
				continue;
			if (!visited[i] && map[loc][i] != 0) { // 방문하지 않았고 갈 수 있을 때
				visited[i] = true;
				func(i, cnt + 1, sum + map[loc][i]); // 다음 곳으로
				visited[i] = false; // 백트래킹
			}
		}

	}

}

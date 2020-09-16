package com.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static int n;
	static int t;
	static int ans;
	static int[] c; // company
	static int[] h; // home
	static int[][] map; // 고객

	static int[] numbers;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		for (int tt = 1; tt <= t; tt++) {
			n = Integer.parseInt(br.readLine());
			c = new int[2];
			h = new int[2];
			map = new int[n][2];
			str = new StringTokenizer(br.readLine());
			c[0] = Integer.parseInt(str.nextToken());
			c[1] = Integer.parseInt(str.nextToken());
			h[0] = Integer.parseInt(str.nextToken());
			h[1] = Integer.parseInt(str.nextToken());
			for (int i = 0; i < n; i++) {
				map[i][0] = Integer.parseInt(str.nextToken());
				map[i][1] = Integer.parseInt(str.nextToken());
			}

			// 동작
			ans = Integer.MAX_VALUE;
			numbers = new int[n];
			visited = new boolean[n];
			permutation(0);
			
			// 출력
			bw.write("#" + tt + " " + ans + "\n");
		}
		// 마무리
		bw.flush();
		bw.close();
	}

	private static void permutation(int cnt) {
		if (cnt == n) {
			calc();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			numbers[cnt] = i;
			visited[i] = true;
			permutation(cnt + 1);
			visited[i] = false;
		}
	}

	private static void calc() {
		int d=0;
		// 회사 출발
		d += (Math.abs(c[0]-map[numbers[0]][0]) + Math.abs(c[1]-map[numbers[0]][1]));
		
		// 거기서부터 고객들 방문
		for (int i = 0; i < n-1; i++) {
			d+=(Math.abs(map[numbers[i]][0]-map[numbers[i+1]][0]) + Math.abs(map[numbers[i]][1]-map[numbers[i+1]][1]));
			if(d>ans)
				return;
		}
		
		// 마지막 고객에서 본인 집으로
		d += (Math.abs(h[0]-map[numbers[n-1]][0]) + Math.abs(h[1]-map[numbers[n-1]][1]));
		
		ans = Math.min(ans, d);
	}
}

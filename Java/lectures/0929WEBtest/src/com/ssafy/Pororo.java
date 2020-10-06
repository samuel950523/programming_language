package com.ssafy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Pororo {
	static int r, c, ans;
	static char[][] map;
	static int[][] maxD;
	static int[][] minD;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static int execute(File path) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader(path));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 동작

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'L') {
//					minD = new int[r][c];
					for (int k = 0; k < r; k++) {
						for (int s = 0; s < c; s++) {
							minD[k][s] = 10000;
						}
					}
					bfs(i, j);
				}
			}
		}
		return ans; // 리턴값을 수정하세요
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { i, j, 0 });
		visited = new boolean[r][c];
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			int cnt = cur[2];
			minD[cr][cc] = Math.min(minD[cr][cc], cnt);
			if (visited[cr][cc])
				continue;
			visited[cr][cc] = true;
			for (int dir = 0; dir < 4; dir++) {
				int nr = cr + dx[dir];
				int nc = cc + dy[dir];
				if (nr >= 0 && nc >= 0 && nr < r && nc < c && map[nr][nc] == 'L') {
					q.offer(new int[] { nr, nc, cnt + 1 });
				}
			}
		}
		
		for (int k = 0; k < r; k++) {
			for (int k2 = 0; k2 < c; k2++) {
				if(minD[k][k2]==10000)
					minD[k][k2]=0;
				ans = Math.max(ans, minD[k][k2]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.println(execute(new File("input.txt")));
	}
}
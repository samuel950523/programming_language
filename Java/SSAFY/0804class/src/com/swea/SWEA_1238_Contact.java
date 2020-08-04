package com.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238_Contact {
	static int len, start, temp, ans;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int tc = 1; tc <= 10; tc++) {

			// 입력
			map = new int[101][101];
			visited = new boolean[101];
			StringTokenizer str = new StringTokenizer(br.readLine());
			len = Integer.parseInt(str.nextToken());
			start = Integer.parseInt(str.nextToken());
			str = new StringTokenizer(br.readLine());
			for (int i = 0; i < len / 2; i++) {
				map[Integer.parseInt(str.nextToken())][Integer.parseInt(str.nextToken())] = 1;
			}

			// 동작
			bfs(start);

			bw.write("#" + tc + " " + ans + "\n");
		}
		bw.flush();
		bw.close();
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		ans = 0;
		while (!queue.isEmpty()) {
			temp = queue.poll(); // 맨 앞에있는 것을 빼서 동작

			for (int i = 1; i < 101; i++) {
				if (map[temp][i] == 1 && visited[i] == false) { // i로 연결은 되어있지만 아직 가지 않았다면
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}

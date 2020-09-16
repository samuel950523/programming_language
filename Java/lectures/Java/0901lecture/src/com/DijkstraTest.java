package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int start = 0;
		int end = V - 1;
		final int INF = Integer.MAX_VALUE;

		int[][] matrix = new int[V][V];
		int[] distance = new int[V]; // 출발지에서 자신까지 오는 최단거리
		boolean[] visited = new boolean[V]; // 처리한 정점 여부

		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.fill(distance, INF);
		distance[start] = 0;

		int min = 0, current = 0;

		for (int i = 0; i < V; i++) {
			min = INF;
			// 1. 방문하지 않은 정점들 중에 출발지에서 자신까지 오는 비용이 최단인 정점을 고려할 경유지로 선택
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j; // 현재 고려해야되는 경유지
				}
			}

			visited[current] = true;

			if(current == end) break;
			
			// 2. 선택된 current 정점을 경유지로해서 아직 방문하지 않은 다른 정점으로의 최단거리 비용 계산하여 유리하면 업데이트
			for (int j = 0; j < V; j++) {
				// min : distance[current]
				// 방문하지 않았고, 인접해있으며,
				if (!visited[j] && matrix[current][j] != 0 && distance[j] > min + matrix[current][j]) {
					distance[j] = min + matrix[current][j];
				}
			}
		}
		
		System.out.println(distance[end]);
	}
}

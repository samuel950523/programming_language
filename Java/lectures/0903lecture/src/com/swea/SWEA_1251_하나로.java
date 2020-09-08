package com.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class SWEA_1251_하나로 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int t, n, x, y;
	static double e;
	static long ans, cnt;
	static int[] xloc;
	static int[] yloc;
	static int[][] map;
	static ArrayList<Edge> edgeList;
	private static int[] parents;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			xloc = new int[n];
			yloc = new int[n];
			edgeList = new ArrayList<Edge>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				xloc[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				yloc[i] = Integer.parseInt(st.nextToken());
			}
			e = Double.parseDouble(br.readLine());

			// 동작

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) { // 모든 조합 구하기
					edgeList.add(new Edge(i, j, getCost(i, j)));
				}
			}

			parents = new int[n];

			// 정렬
			Collections.sort(edgeList, new Comparator<Edge>() {
				@Override
				public int compare(Edge o1, Edge o2) {
//					return o1.weight - o2.weight; // 이렇게 하면 return 타입이 맞지 않는다.
					if (o1.weight - o2.weight > 0)
						return 1;
					else if (o1.weight - o2.weight < 0)
						return -1;
					else
						return 0;
				}
			});

			make();
			double result = 0;
			int count = 0;
			for (Edge edge : edgeList) {
				if (union(edge.start, edge.end)) {
					result += edge.weight;
					count++;
					if (count == n)
						break;
				}
			}
			bw.write("#"+tc+" "+Math.round(result)+"\n");
		}
		bw.flush();
		bw.close();
	}

	private static double getCost(int i, int j) {
		double l = 0; // 매우 큰 값 가능
		l = e * ((double)(xloc[i] - xloc[j]) * (double)(xloc[i] - xloc[j]) + (double)(yloc[i] - yloc[j]) * (double)(yloc[i] - yloc[j]));
		return l;
	}

	static class Edge {
		int start;
		int end;
		double weight;

		public Edge(int start, int end, double weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
	}

	private static void make() {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a > b) {
			parents[a] = b;
			return true;
		} else if (a < b) {
			parents[b] = a;
			return true;
		}
		return false;
	}

}

package com.swea;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SWEA_2382_미생물격리 {
	static class Micro {
		int y;
		int x;
		int count;
		int dir;

		public Micro(int y, int x, int count, int dir) {
			this.y = y;
			this.x = x;
			this.count = count;
			this.dir = dir;
		}
	}	

	static int T, N, M, K;
	static ArrayList<Micro> list;
	static int[][] mapCnt;
	static int[][] mapMaxDir;
	static int[][] mapMaxCnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			list = new ArrayList<Micro>();

			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();

			mapCnt = new int[N][N];
			mapMaxDir = new int[N][N];
			mapMaxCnt = new int[N][N];

			for (int i = 0; i < K; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				int cnt = sc.nextInt();
				int dir = sc.nextInt();
				list.add(new Micro(y, x, cnt, dir));
			}

			for (int i = 0; i < M; i++) {
				init();
				move();
				arrange();
			}

			System.out.println("#" + tc + " " + sum());
		}
		sc.close();
	}

	static void move() {
		Iterator<Micro> itr = list.iterator();
		while (itr.hasNext()) {
			Micro m = itr.next();
			if (m.dir == 1) { // 상

				if (--m.y == 0) {
					m.count /= 2;
					m.dir = 2; // 하
				}
			} else if (m.dir == 2) { // 하

				if (++m.y == N - 1) {
					m.count /= 2;
					m.dir = 1; // 상
				}
			} else if (m.dir == 3) { // 좌

				if (--m.x == 0) {
					m.count /= 2;
					m.dir = 4; // 우
				}
			} else if (m.dir == 4) { // 우

				if (++m.x == N - 1) {
					m.count /= 2;
					m.dir = 3; // 우
				}
			}
		}
	}

	static void arrange() {

		Iterator<Micro> itr = list.iterator();
		while (itr.hasNext()) {
			Micro m = itr.next();

			if (m.count == 0) {
				itr.remove();
				continue;
			}
			if (mapCnt[m.y][m.x] != 0) {
				mapCnt[m.y][m.x] += m.count;
				if (mapMaxCnt[m.y][m.x] < m.count) {
					mapMaxCnt[m.y][m.x] = m.count;
					mapMaxDir[m.y][m.x] = m.dir;
				}
			} else {
				mapCnt[m.y][m.x] = m.count;
				mapMaxCnt[m.y][m.x] = m.count;
				mapMaxDir[m.y][m.x] = m.dir;
			}
		}

		list.clear();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (mapCnt[i][j] != 0) {
					list.add(new Micro(i, j, mapCnt[i][j], mapMaxDir[i][j]));
				}
			}
		}
	}

	static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				mapCnt[i][j] = 0;
				mapMaxCnt[i][j] = 0;
				mapMaxDir[i][j] = 0;
			}
		}
	}

	static int sum() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (mapCnt[i][j] != 0)
					sum += mapCnt[i][j];
			}
		}
		return sum;
	}
}

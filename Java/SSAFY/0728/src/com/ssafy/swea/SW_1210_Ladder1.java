package com.ssafy.swea;

import java.util.Scanner;

public class SW_1210_Ladder1 {
	// 왼-오-위
	static int[] dx = { -1, 1, 0 };
	static int[] dy = { 0, 0, -1 };

	static int[][] ladder;

	// 시작 좌표
	static int sx = 0;
	static int sy = 0;

	// 정답
	static int ans = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int t = 0; t < 10; t++) {

			int N = sc.nextInt();
			ladder = new int[100][100];
			sx = 0;
			sy = 0;

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {

					ladder[i][j] = sc.nextInt();

					// 시작좌표 확보
					if (ladder[i][j] == 2) {
						sy = i;
						sx = j;
					}
				}
			}

			// 탐색 시작

			int direction = 2; // 위 방향으로 시작

			while (true) {

				// 위로 갈 경우 왼쪽 오른쪽을 먼저 고려 없으면 계속 위로
				if (direction == 2) {

					// 왼 - 오 - 위 순으로 탐색
					for (int d = 0; d < dx.length; d++) {

						int nx = sx + dx[d];
						int ny = sy + dy[d];

						// 범위 안에서 1 이면 새 좌표로 이동하고 바로 나옴.
						if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && ladder[ny][nx] == 1) {
							sx = nx;
							sy = ny;

							direction = d;
							break;
						}
					}

					// 왼쪽 또는 오른쪽으로 이동 중에는 위로 가는 것을 먼저 고려하고 아니면 계속 그 방향으로
				} else if (direction == 0 || direction == 1) {

					// 위로 가는 좌표
					int nx = sx + dx[2];
					int ny = sy + dy[2];

					// 범위 안에서 1 이면 새 좌표로 이동하고 바로 나옴.
					if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && ladder[ny][nx] == 1) {
						sx = nx;
						sy = ny;

						direction = 2;
					} else {
						sx = sx + dx[direction];
						sy = sy + dy[direction];
					}
				}

				// y가 첫 줄까지 왔으면, x가 답
				if (sy == 0) {
					ans = sx;
					break;
				}
			}

			System.out.println("#" + N + " " + ans);

		}

		sc.close();
	}
}

package com.ssafy;

import java.util.Scanner;

public class Maze {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// 좌표는 (1,1)부터 시작
		for (int tt = 0; tt < t; tt++) {
			int size = sc.nextInt();
			int startr = sc.nextInt() - 1;
			int startc = sc.nextInt() - 1;
			int numjump = sc.nextInt();
			int[][] maze = new int[size][size];
			for (int i = 0; i < numjump; i++) {
				// 점퍼
				int r = sc.nextInt() - 1;
				int c = sc.nextInt() - 1;
				maze[r][c] = -1;
			}
			int nnn = sc.nextInt(); // 이동지시 개수
			int ans = 1;
			for (int i = 0; i < nnn; i++) {
				// 이동지시
				// 1:상, 2:우, 3:하, 4:좌
				int dir = sc.nextInt();
				int num = sc.nextInt();
				int cnt = 0;
				if (dir == 1) {
					// 상
					while (cnt != num) {
						if (startr == 0) {
							ans = 0;
							break;
						} else {
							startr--;
							cnt++;
							if (maze[startr][startc] == -1) {
								ans = 0;
								break;
							}
						}
					}
				} else if (dir == 2) {
					// 우
					while (cnt != num) {
						if (startc == size-1) {
							ans = 0;
							break;
						} else {
							startc++;
							cnt++;
							if (maze[startr][startc] == -1) {
								ans = 0;
								break;
							}
						}
					}
				} else if (dir == 3) {
					// 하
					while (cnt != num) {
						if (startr == size-1) {
							ans = 0;
							break;
						} else {
							startr++;
							cnt++;
							if (maze[startr][startc] == -1) {
								ans = 0;
								break;
							}
						}
					}
				} else {
					// 좌
					while (cnt != num) {
						if (startc == 0) {
							ans = 0;
							break;
						} else {
							startc--;
							cnt++;
							if (maze[startr][startc] == -1) {
								ans = 0;
								break;
							}
						}
					}
				}
			}
			System.out.println();
			if (ans == 0) {
				System.out.println("0 0");
			} else {
				System.out.print((++startr) + " " + (++startc));
			}
		}
		sc.close();
	}

}

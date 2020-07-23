package com.ssafy;

import java.util.Scanner;

public class Robot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tt = 0; tt < t; t++) {
			// input
			int n = sc.nextInt();
			char[][] map = new char[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			// S : 공백, W : 벽, ABC : 로봇
			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int curi = i;
					int curj = j;
					if (map[i][j] == 'A') {
						// 우
						while (true) {
							if (j == n - 1)
								break;
							else {
								j++;
								if (map[i][j] != 'S')
									break;
								else
									ans++;
							}
						}
					} else if (map[i][j] == 'B') {
						// 우
						while (true) {
							if (j == n - 1)
								break;
							else {
								j++;
								if (map[i][j] != 'S')
									break;
								else
									ans++;
							}
						}
						i = curi;
						j = curj;
						// 좌
						while (true) {
							if (j == 0)
								break;
							else {
								j--;
								if (map[i][j] != 'S')
									break;
								else
									ans++;
							}
						}
						i=curi;
						j=curj;
					} else if (map[i][j] == 'C') {
						// 우
						while (true) {
							if (j == n - 1)
								break;
							else {
								j++;
								if (map[i][j] != 'S')
									break;
								else
									ans++;
							}
						}
						i = curi;
						j = curj;
						// 좌
						while (true) {
							if (j == 0)
								break;
							else {
								j--;
								if (map[i][j] != 'S')
									break;
								else
									ans++;
							}
						}
						i = curi;
						j = curj;
						// 상
						while (true) {
							if (i == 0)
								break;
							else {
								i--;
								if (map[i][j] != 'S')
									break;
								else
									ans++;
							}
						}
						i = curi;
						j = curj;
						// 하
						while (true) {
							if (i == n - 1)
								break;
							else {
								i++;
								if (map[i][j] != 'S')
									break;
								else
									ans++;
							}
						}
						i=curi;
						j=curj;
					} else {
						continue;
					}
					i=curi;
					j=curj;
				}
			}
			System.out.println(ans);
		}
		sc.close();
	}
}

/*

3
6
S A S S W S
S W A S C S
S W S W S S
S W S S W S
S B S S W S
S S S S S S
3
S S A
B W W
S W C
10
C S S S S S S S S C
S W S S S S S S W S
S S W S S S S W S S
A S S W S S W S S A
S S S S S B S S S S
S S S S B S S S S S
A S S W S S W S S A
S S W S S S S W S S
S W S S S S S S W S
C S S S S S S S S C

*/

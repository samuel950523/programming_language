package com.ssafy;

import java.util.Scanner;

public class Building {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 0; tt < t; tt++) {
			// input
			int n = sc.nextInt();
			char[][] map = new char[n + 2][n + 2];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = 'N';
				}
			}

			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			

			// search
			int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
			int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
			
			int max=0;
			// 먼저 한 번 탐색을 하여 2층 높이인 것을 정해준다.
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (map[i][j] == 'B') {
						for (int dir = 0; dir < 8; dir++) {
							if(map[i+dy[dir]][j+dx[dir]]=='G') {
								// 2층높이
								map[i][j]='2';
								max=2;
							}
						}
					}
				}
			}	
			for (int i = 1; i < n+1; i++) {
				for (int j = 1; j < n+1; j++) {
					if (map[i][j] == 'B') {
						int cnt=-1; // 현 위치의 B가 두 번 포함되어 -1부터 시작
						for (int k = 1; k < n+1; k++) {
							if(map[i][k]=='B' || map[i][k]=='2') cnt++;
							if(map[k][j]=='B' || map[k][j]=='2') cnt++;
						}
						if (max<cnt) max=cnt;
					}
				}
			}
			
			System.out.println("#"+(tt+1)+" "+max);
			
		}
		sc.close();
	}
}

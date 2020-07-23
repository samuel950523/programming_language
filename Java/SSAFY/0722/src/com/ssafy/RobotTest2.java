package com.ssafy;

import java.util.Scanner;

public class RobotTest2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <=T; tc++) {
			int N = sc.nextInt();
			
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			
			int ans = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					char robot = map[r][c];
					if(robot=='A') {
						// 우
						for (int k = c+1; k < N; k++) {
							if(map[r][k]=='S') ans++;
							else break;
						}
						
					}else if (robot=='B') {
						//좌 
						for (int k = c-1; k >= 0; k--) {
							if(map[r][k]=='S') ans++;
							else break;
						}
						//우
						for (int k = c+1; k < N; k++) {
							if(map[r][k]=='S') ans++;
							else break;
						}
					}else if (robot=='C') {
						//좌 
						for (int k = c-1; k >= 0; k--) {
							if(map[r][k]=='S') ans++;
							else break;
						}
						//우
						for (int k = c+1; k < N; k++) {
							if(map[r][k]=='S') ans++;
							else break;
						}
						//상 
						for (int k = r-1; k >= 0; k--) {
							if(map[k][c]=='S') ans++;
							else break;
						}
						//하
						for (int k = r+1; k < N; k++) {
							if(map[k][c]=='S') ans++;
							else break;
						}
					}
				}
			}
			System.out.println("#"+tc+" "+ans);			
		}
		sc.close();
	}

}









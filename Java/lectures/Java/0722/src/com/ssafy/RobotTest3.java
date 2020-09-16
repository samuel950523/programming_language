package com.ssafy;

import java.util.Scanner;

public class RobotTest3 {

	static int[][][] dir = {
			{ {0,1} } ,//A  : 우
			{{0,-1},{0,1} }, //B : 좌, 우
			{{0,-1},{0,1},{-1,0},{1,0} }, //C : 좌, 우, 상, 하
	};
	
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
					int robot = map[r][c] -'A';
					if(robot>2) continue;
					
					int direction[][] = dir[robot];
					for (int d = 0; d < direction.length; d++) { // 방향만큼 반복
						int nr=r,nc=c;
						
						while(true) {
							nr += direction[d][0];
							nc += direction[d][1];
							if(nr<0 || nr>=N || nc<0 || nc>=N) break; // 경계 체크
							if(map[nr][nc]=='S') ans++;
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









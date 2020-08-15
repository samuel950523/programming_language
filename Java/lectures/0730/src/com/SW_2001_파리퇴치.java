package com;

import java.util.Scanner;

public class SW_2001_파리퇴치 {

	static int[][] map;
	
	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
				
			}
			
			int max = 0;
			for (int i = 0; i < N-M+1; i++) { // 파리채 가로가 1이면 N 번 길이가2이면 N-1 ...--> N-M=1
				for (int j = 0; j < N-M+1; j++) {
					int temp = flyCount(i, j);
					if( temp > max ) max = temp;
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
		
		sc.close();
	}
	
	static int flyCount(int y, int x) {
		
		//System.out.print("fly - ["+y+","+x+"] sum - ");
		// MxM 합
		// 자기 자신
		int count = 0;
		
		for (int i = y; i < y+M && y<N; i++) {
			for (int j = x; j < x+M && x<N; j++) {
				count += map[i][j]; 
			}
		}
		
		//System.out.println(count);
		return count;
	}
}


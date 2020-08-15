package com.ssafy.algo;

import java.util.Scanner;

public class Solution22 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt(); // 연못 크기
			int num = sc.nextInt(); // 소금쟁이 수
			int[][] box = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					box[i][j] = 0;
				}
			}
			int alive=num; // 살아있는 소금쟁이 수
			int [] step = {3,5,6}; // 누적으로 빼준다.
			for (int i = 0; i < num; i++) {
				// 소금쟁이 input
				int r = sc.nextInt();
				int c = sc.nextInt();
				int dir = sc.nextInt();
				if(box[r][c]==-1) {
					alive--;
					continue;
				}
				boolean flag=true;
				// 상:1 하:2 좌:3 우:4
				if(dir==1) {
					if(r-6<0) { // 세번째까지 뛰었을 때 연못 안이어야한다.
						alive--;
						continue;
					}
					// 충돌
					for (int j = 0; j < 3; j++) {
						if(box[r-step[j]][c]==-1) {
							flag=false;
							alive--;
							break;
						}
					}
					if(flag==true) box[r-6][c]=-1;
				}
				else if(dir==2) {
					if(r+6>=n) { // 세번째까지 뛰었을 때 연못 안이어야한다.
						alive--;
						continue;
					}
					// 충돌
					for (int j = 0; j < 3; j++) {
						if(box[r+step[j]][c]==-1) {
							flag=false;
							alive--;
							break;
						}
					}
					if(flag==true) {
						box[r+6][c]=-1;
					}
				}
				else if(dir==3) {
					if(c-6<0) { // 세번째까지 뛰었을 때 연못 안이어야한다.
						alive--;
						continue;
					}
					// 충돌
					for (int j = 0; j < 3; j++) {
						if(box[r][c-step[j]]==-1) {
							flag=false;
							alive--;
							break;
						}
					}
					if(flag==true) box[r][c-6]=-1;
				}
				else{
					if(c+6>=n) { // 세번째까지 뛰었을 때 연못 안이어야한다.
						alive--;
						continue;
					}
					// 충돌
					for (int j = 0; j < 3; j++) {
						if(box[r][c+step[j]]==-1) {
							flag=false;
							alive--;
							break;
						}
					}
					if(flag==true) box[r][c+6]=-1;
				}
			}
			System.out.println("#"+tc+" "+alive);
		}
		sc.close();
	}
}

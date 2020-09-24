package com.swea;

import java.util.Scanner;

public class SWEA_3307_최장증가부분수열 {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] lis = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 동작
			int ans = 0;
			for (int i = 0; i < n; i++) {
				lis[i] = 1; // 자기 혼자 수열
				// 자기 앞에 있는 lis 원소들과 비교
				for (int j = 0; j <= i - 1; j++) {
					// 앞쪽 원소보다 자신이 큰 경우
					if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
						lis[i] = lis[j] + 1;
					}
				}
				// 최대값 갱신
				ans = Math.max(ans, lis[i]);
			}
			System.out.println("#"+tc+" "+ans);
			
		}
		sc.close();
	}
}

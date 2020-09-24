package com.boj;

import java.util.Scanner;

public class BOJ_11722_가장긴감소하는부분수열 {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] lds = new int[n];
		for (int i = 0; i < lds.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 동작 O(N^2)
		int ans = 0; 
		for (int i = 0; i < n; i++) {
			lds[i] = 1; // 자기 혼자 수열
			for (int j = 0; j < i; j++) {
				if(arr[i]<arr[j] && lds[i]<lds[j]+1)
					lds[i] = lds[j]+1;
			}
			ans = Math.max(ans, lds[i]);
		}
		System.out.println(ans);
		sc.close();
	}
}

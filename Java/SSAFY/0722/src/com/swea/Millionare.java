// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LrsUaDxcDFAXc
// 1859. 백만 장자 프로젝트
package com.swea;

import java.util.Scanner;

public class Millionare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 0; tt < t; tt++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			long ans=0;
			int cnt=0;
			int max=arr[n-1];
			for (int i = n-2; i >= 0 ; i--) {
				if(max>arr[i]) {
					ans-=arr[i];
					cnt++;
				}
				else {
					ans+=(max*cnt);
					cnt=0;
					max=arr[i];
				}
				if(i==0 && cnt>0) {
					ans+=(max*cnt);
				}
			}
			

			System.out.println("#"+(tt+1)+" "+ ans);
		}
		sc.close();
	}

}

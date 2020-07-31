package com.boj;

import java.util.Scanner;


public class BOJ_2751_수정렬하기2 {
	static int n;
	static int[] numArr;
	static int temp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		numArr = new int[n];
		for (int i = 0; i < n; i++) {
			numArr[i]=sc.nextInt();
		}
		numArr = sort(numArr);
		for (int i = 0; i < n; i++) {
			System.out.println(numArr[i]);
		}
		sc.close();
	}
	static int[] sort(int[] numArr) {
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) {
				if(numArr[j]>numArr[j+1]) {
					temp = numArr[j];
					numArr[j]=numArr[j+1];
					numArr[j+1]=temp;
				}
			}
		}
		return numArr;
	}
}

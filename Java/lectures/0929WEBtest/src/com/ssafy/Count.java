package com.ssafy;

import java.util.Scanner;

public class Count {
	public static int execute(int N) {
		if(N==1)
			return 0;
		int cnt = 1;
		int d = 1;
		while(true) {
			if(cnt>=N) {
				return d;
			}
			cnt+=d*6;
			d++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(Count.execute(N)); // 3
		sc.close();
	}

}

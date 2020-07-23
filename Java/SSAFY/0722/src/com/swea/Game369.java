package com.swea;

import java.util.*;

public class Game369 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			int hun = i / 100;
			int ten = i / 10;
			int one = i % 10;
			int cnt = 0;
			if (hun == 3 || hun == 6 || hun == 9)
				cnt++;
			if (ten == 3 || ten == 6 || ten == 9)
				cnt++;
			if (one == 3 || one == 6 || one == 9)
				cnt++;
			if (cnt == 0)
				System.out.print(i + " ");
			else {
				for (int c = 0; c < cnt; c++) {
					System.out.print("-");
				}
				System.out.print(" ");
			}	
		}
		sc.close();
	}
}

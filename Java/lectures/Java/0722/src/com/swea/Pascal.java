package com.swea;

import java.util.Scanner;

public class Pascal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 0; tt < t; tt++) {
			int n = sc.nextInt();
			int[][] tri = new int[n][];
			for (int i = 0; i < tri.length; i++) {
				tri[i]=new int[i+1];
				tri[i][0] = 1;
				tri[i][i]=1;
			}

			if (n >= 3) {
				for (int i = 2; i < tri.length; i++) {
					for (int j = 1; j < i; j++) {
						tri[i][j] = (tri[i - 1][j - 1] + tri[i - 1][j]);
					}
				}
			}
			System.out.println("#"+(tt+1));
			for (int i = 0; i < tri.length; i++) {
				for (int j = 0; j < tri[i].length; j++) {
					System.out.print(tri[i][j] + " ");
				}
				System.out.println();
			}

		}
		sc.close();
	}
}

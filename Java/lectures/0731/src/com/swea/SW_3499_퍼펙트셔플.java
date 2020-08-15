package com.swea;

import java.util.Scanner;

public class SW_3499_퍼펙트셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		String[] strArr;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt();

			strArr = new String[N];

			for (int i = 0; i < N; i++) {
				strArr[i] = sc.next();
			}

			sb.append("#" + t + " ");

			for (int i = 0; i < N / 2; i++) {

				if (N % 2 == 0) {

					sb.append(strArr[i]).append(" ");
					sb.append(strArr[N / 2 + i]).append(" ");

				} else {

					sb.append(strArr[i]).append(" ");
					sb.append(strArr[N / 2 + i + 1]).append(" ");

				}
			}

			if (N % 2 == 1) {

				sb.append(strArr[N / 2]).append(" ");

			}

			sb.append("\n");
		}

		System.out.println(sb);
		sc.close();
	}
}

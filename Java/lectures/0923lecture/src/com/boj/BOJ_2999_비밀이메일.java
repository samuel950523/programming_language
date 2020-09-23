package com.boj;

import java.util.Scanner;

public class BOJ_2999_비밀이메일 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next(); // 알파벳 소문자로만(공백 x)
		// r과 c 고르기
		int n = s.length();
		int r = 0, c = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0 && i <= n / i) {
				r = i;
				c = n / i;
			}
		}
		if (r == 0 && c == 0) {
			r = 1;
			c = 1;
		}
		int index = 0;
		char[][] ans = new char[r][c];
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				ans[j][i] =s.charAt(index++);
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(ans[i][j]);
			}
		}
		sc.close();
	}
}

package com.swea;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			String word = sc.next();
			int ans=1;
			for (int i = 0; i < word.length()/2+1; i++) {
				if(word.charAt(i)!=word.charAt(word.length()-1-i)) {
					ans=0;
					break;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
		sc.close();
	}
}

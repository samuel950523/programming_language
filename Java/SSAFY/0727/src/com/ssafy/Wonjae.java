package com.ssafy;

import java.util.Scanner;

public class Wonjae {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String str = sc.next();
			boolean flag = true; // flag가 true면 제대로된 상태, false면 뒤집어져있는 상태
			int ans = 0;
			int index = 0;
			while (true) {
				if (index == str.length())
					break; // 끝까지 가면 break
				
				if (str.charAt(index) == '0') {
					if (!flag) { // 0이 1로 되어있기때문에 0으로 뒤집어준다.
						ans++;
						while (str.charAt(index) == '0') { // 뒤에 있는 0들을 다 뒤집어준다.
							index++;
							if (index == str.length())
								break; // 끝까지 가면 break
						}
						flag = true; // 제대로 된 상태라 true로 변경
					} 
					else
						index++; // 아무일도 일어나지 않을 때는 다음 index로
				} 
				else {
					if (flag) { // 1로 되어있는 것들을 0으로
						ans++;
						while (str.charAt(index) == '1') {
							index++;
							if (index == str.length())
								break;
						}
						flag = false;
					} 
					else
						index++;
				}
			}
			System.out.println("#" + (tc + 1) + " " + ans);
		}
		sc.close();
	}
}

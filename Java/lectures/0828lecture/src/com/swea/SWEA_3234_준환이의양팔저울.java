package com.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3234_준환이의양팔저울 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static int t, n;
	static int[] arr;
	static int ans;
	static int l, r;
	static int[] numbers;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tt = 1; tt <= t; tt++) {
			n = Integer.parseInt(br.readLine());
			str = new StringTokenizer(br.readLine());
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str.nextToken());
			}
			numbers = new int[n];
			visited = new boolean[n];
			
			// 동작
			// nPn
			ans=0;
			perm(0);
			
			// 출력
			System.out.println("#" + tt + " " + ans);
		}

	}

	// n! 개의 순열 만들기
	private static void perm(int cnt) {
		if (cnt == n) {
			func(0, 0, 0);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			numbers[cnt] = arr[i];
			visited[i] = true;
			perm(cnt + 1);
			visited[i] = false;
		}
	}

	// 왼쪽이 같거나 큰 경우만 됨
	private static void func(int l, int r, int i) {
		if (i == n) { // 다 올렸으면
			ans++; // 카운트
			return;
		}
		if (l >= r + numbers[i]) { // 올릴 수 있으면
			func(l, r + numbers[i], i + 1); // 오른쪽에 올리고 탐색
			func(l + numbers[i], r, i + 1); // 왼쪽에 올리고 탐색
		} else { // 올릴 수 없으면
			func(l + numbers[i], r, i + 1); // 왼쪽에 올리고 탐색
		}
	}
}

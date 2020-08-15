package com.lecture;

import java.util.*;

public class SW_3289_서로소집합 {

	static int[] parent;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt();
			int M = sc.nextInt(); // 연산 갯수

			parent = new int[N + 1];

			// 자기 자신과 동일하게
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < M; i++) {

				int op = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();

				if (op == 1) {
					// a, b 가 같은 집합이면 1, 아니면 0 출력
					if (isSameSet(a, b))
						System.out.print(1);
					else
						System.out.print(0);
				} else {
					// 합집합 연산
					union(a, b);
				}
			}

			System.out.println();
		}
		sc.close();
	}

	public static int findSet(int x) {
		// 대표자가 자신이면 자신을 return
		if (x == parent[x])
			return x;
		// 아니면 부모로 한번 더 찾는다. 재귀 호출로 최종 부모를 찾게 됨.
		else
			return parent[x] = findSet(parent[x]);

	}

	public static void union(int x, int y) {
		// 두 집합의 대표자를 찾아 합친다.
		x = findSet(x);
		y = findSet(y);

		if (x > y)
			parent[x] = y; // x가 더 크면 x의 부모는 y
		else
			parent[y] = x; // y가 더 크면 y의 부모는 x
	}

	public static boolean isSameSet(int x, int y) {
		return findSet(x) == findSet(y);
	}
}

/*
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr
 * 
 */

/*
 * 1 7 8 0 1 3 1 1 7 0 7 6 1 7 1 0 3 7 0 4 2 0 1 1 1 1 1
 * 
 * 
 * #1 001
 */
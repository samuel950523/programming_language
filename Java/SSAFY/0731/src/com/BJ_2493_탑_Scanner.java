package com;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BJ_2493_탑_Scanner {
	public static void main(String[] args) throws Exception, IOException {

		Scanner sc = new Scanner(System.in);
		Stack<int[]> stack = new Stack<>();

		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			int height = sc.nextInt();
			while (!stack.isEmpty()) {
				if (stack.peek()[1] >= height) {
					System.out.print(stack.peek()[0] + " ");
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) {
				System.out.print("0 ");
			}
			stack.push(new int[] { i, height });
		}

		sc.close();
	}
}
/*
 * 사용자의 입력이 굉장히 긴 경우 Scanner 메모리를 많이 사용 백준 Test 통과 X
 */

/*
 * https://www.acmicpc.net/problem/2493
 */
/*
 * 현재 탑의 수신은 탑의 왼쪽에서만 일어남 stack 으로 생각해 보면 먼저 들어간 것 들 중에 답이 있어야 함. 없으면 0 -->
 * stack 에 넣으면서 문제를 풀어야 함
 */

/*
 * 5 6 9 5 7 4
 * 
 * 0 0 2 2 4
 */
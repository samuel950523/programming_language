package com;

import java.util.LinkedList;
import java.util.Queue;

public class Q2_MyChew {
	public static void main(String[] args) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int N = 20;
		int person = 1;

		queue.offer(new int[] { 1, 1 }); // 번호, 받아야하는 마이쮸개수

		while (N > 0) {
			// 줄 서 있는 첫번재 사람에게 마이쮸 주기
			if (!queue.isEmpty()) {
				int[] p = queue.poll();
				int availableCnt = (N >= p[1]) ? p[1] : N;
				N-=availableCnt;
				if (N == 0) { // 더이상 마이쮸 없음
					System.out.println("마지막 마이쮸를 가져간 사람 : " + p[0] + ", 가져간개수 : " + availableCnt);
				} else {
					System.out.println(p[0] + "번이" + availableCnt + "개수만큼 가져갑니다. 남은 개수 : " + N);
					p[1]++; // 받고 줄의 맨 뒤로 갈 때 받아야하는 개수 늘려줘야함
					queue.offer(p); // 다시 줄 서기
					queue.offer(new int[] { ++person, 1 });
				}
			}
		}
	}
}

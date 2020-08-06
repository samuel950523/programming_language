package com.lecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*10
1 1 4
2 1 6
3 6 10
4 5 7
5 3 8
6 5 9
7 3 5
8 8 11
9 2 13
10 12 14*/


// VO를 이용한 1차원배열 버전
public class Greedy_MeetingRoom {

	public static List<Meeting> getSchedule(Meeting[] m) {
		List<Meeting> sche = new ArrayList<Meeting>();

		Arrays.sort(m); // 회의 종료시간(오름) 순서대로 정렬
		sche.add(m[0]); // 첫번째 회의 확정
		for (int j = 1; j < m.length; j++) {
			// 확정된 앞 회의의 종료시간이 다음 회의시작보다 같거나 크다면 회의 확정
			if (sche.get(sche.size() - 1).end <= m[j].start) {
				sche.add(m[j]);
			}
		}
		return sche;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		Meeting m[] = new Meeting[count];

		for (int i = 0; i < count; i++) {
			m[i] = new Meeting(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		List<Meeting> sche = getSchedule(m);
		System.out.println(sche.size());
		for (Meeting me : sche) {
			System.out.print(me.num + " ");
		}
		sc.close();

	}
	static class Meeting implements Comparable<Meeting> {
		int num;
		int start;
		int end;
		
		public Meeting(int num, int start, int end) {
			super();
			this.num = num;
			this.start = start;
			this.end = end;
		}

		// 끝나는 시간 기준으로 오름차순 정렬해서 비교해야 최대개수의 회의를 배정할수 있음.
		// 끝나는 시간이 같은 회의의 경우 다음과 같은 경우(회의 시작시간과 종료시간이 같은 경우가 포함된 경우)로 인해 시작시간에 대한 오름차순이 필요함.
		// (1,2)  (2,3)  (3,3) ==> 3개
		// (1,2)  (3,3)  (2,3) ==> 시작시간 빠른 순으로 정렬안할시에 이런 가능성이 있음. : 2개
		@Override
		public int compareTo(Meeting o) {
			
			int value = end - o.end; 
			if(value != 0){ // 종료시간이 다르다면
				return value;
			}
			return start - o.start; // 종료시간이 같을 경우 시작시간이 빠른 순으로 정렬되도록 한다.
		}

		@Override
		public String toString() {
			return "Meeting [num=" + num + ", start=" + start + ", end=" + end
					+ "]";
		}

	}

}


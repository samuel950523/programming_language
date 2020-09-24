package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14003_가장긴증가하는부분수열5 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] lis = new int[n]; // 각 lis의 길이를 만족하는 맨 끝에 오는 최소값을 저장
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] indexArr = new int[n];

		// 동작
		int size = 0; // lis 길이 (뒤에 0들은 빼주기 위해)
		for (int i = 0; i < n; i++) {
			int temp = Arrays.binarySearch(lis, 0, size, arr[i]); // arr[i]:탐색 키 => 찾으면 인덱스, 못찾으면 음수값으로 자신이 삽입 될 위치
			if (temp >= 0) // (-index-1)
				continue;
			// 중복 값이 없다면 temp : 음수 값
			temp = Math.abs(temp) - 1; // 삽입위치 환산
			lis[temp] = arr[i];
			if (temp == size) { // 맨 뒤에 추가하는 상황
				size++;
				indexArr[i] = size;
			} else { // 업데이트 하는 상황이면
				indexArr[i] = temp+1;
			}
		}
		bw.write(size+"\n");

		// 배열 출력
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = n - 1; i >= 0; i--) {
			if(size==0)break;
			if(indexArr[i] == size) {
				stack.push(arr[i]);
				size--;
			}
		}
		
		while(!stack.isEmpty()) {
			bw.write(stack.pop()+" ");
		}
		bw.flush();
		bw.close();
	}
}

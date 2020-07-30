package com.swea;

import java.util.Scanner;
import java.util.Stack;

public class SW_1218_괄호짝짓기 {

	static char[] beginTokens = {'<','{','(','['};
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			
			int N = sc.nextInt();

			String str = sc.next();
			
			int answer = 1;
			
			for (int i = 0; i < N; i++) {
				
				char token = str.charAt(i);
				
				if( contains(token) ) { // 여는 태그이면 push
					stack.push(token);
				}else {
					
					boolean result = false;
					
					if (!stack.isEmpty()) {
						char prev = stack.pop();
						if (token == '>' && prev == '<') {
							result = true;
						}else if (token == ']' && prev == '[') {
							result = true;
						}else if (token == '}' && prev == '{') {
							result = true;
						}else if (token == ')' && prev == '(') {
							result = true;
						}

						if (!result) {
							answer = 0;
							break;
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
		
		sc.close();
	}
	
	static boolean contains(char c) {
		for (int i = 0; i < beginTokens.length; i++) {
			if( c == beginTokens[i] ) {
				return true;
			}
		}
		return false;
	}
}



/*
테스트 케이스 10 고정
Stack 사용
주어진 문자열을 순회하면서
  글자 하나가  여는 token ({[< 4개는 stack 언제나 push
                    닫는 token 일 경우 stack 에서 마지막 것을 꺼내서 짝 비교 
 비교가 맞지 않는 경우 중단 break
*/                 

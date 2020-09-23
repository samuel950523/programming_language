package com.boj;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_17413_단어뒤집기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Stack<Character> stack = new Stack<Character>();
		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '<') {
				flag = true;
				while(!stack.isEmpty()) 
					System.out.print(stack.pop());
				
			} else if (c == '>') {
				System.out.print(c);
				flag = false;
			}
			if (flag)
				System.out.print(c);
			else {
				if(c==' ') {
					while(!stack.isEmpty()) 
						System.out.print(stack.pop());
					System.out.print(c);
				}
				if(c!='>' && c!=' ')
					stack.push(c);
			}
		}
		
		while(!stack.isEmpty()) 
			System.out.print(stack.pop());
		

		sc.close();
	}
}

package com.linkedlist;

public class SimpleLinkedListStackTest {
	public static void main(String[] args) {
		SimpleLinkedListStack stack = new SimpleLinkedListStack();
		
		System.out.println(stack.isEmpty());
		
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.printStack();
		
		System.out.println(stack.isEmpty());
		
		System.out.println(stack.pop());
		stack.printStack();
		
		stack.push("4");

		System.out.println("peek() : " + stack.peek());
		
		stack.push("5");
		System.out.println("peek() : " + stack.peek());
		System.out.println(stack.pop());
		
		stack.printStack();
	}
}

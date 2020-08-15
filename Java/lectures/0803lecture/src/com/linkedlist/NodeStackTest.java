package com.linkedlist;

public class NodeStackTest {
	public static void main(String[] args) {
		NodeStack stack = new NodeStack();
		stack.push(new Node("1"));
		stack.push(new Node("2"));
		stack.push(new Node("3"));
		stack.printStack();
		
		System.out.println(stack.pop());
		stack.printStack();
		
		stack.push(new Node("4"));
		System.out.println("peek() : " + stack.peek());
		
		stack.push(new Node("5"));
		System.out.println("peek() : " + stack.peek());
		System.out.println(stack.pop());
		
		stack.printStack();
	}
}

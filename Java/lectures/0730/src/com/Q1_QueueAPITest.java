package com;

import java.util.LinkedList;

public class Q1_QueueAPITest {
	public static void main(String[] args) {
		LinkedList<String> queue = new LinkedList<String>();
		System.out.println(queue.size()+"//"+queue.isEmpty());
		queue.offer("이동욱");
		queue.offer("이지아");
		queue.offer("김태희");
		System.out.println(queue.size()+"//"+queue.isEmpty());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.size()+"//"+queue.isEmpty());
	}
}

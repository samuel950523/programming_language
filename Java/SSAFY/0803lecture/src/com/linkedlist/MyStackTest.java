package com.linkedlist;

public class MyStackTest {
	public static void main(String[] args) {
		// 공백 리스트의 상태
        // 스택의 push를 구현한 것과 같다.
        MyStack list = new MyStack();
        list.addFirstNode("이동욱");
        list.printList();
        list.addFirstNode("이지아");
        list.printList();
        list.addFirstNode("김재환");
        
        // 맨 앞쪽에서부터 프린트 되므로 넣는 순서와 반대로 출력된다. 
        list.printList();
	}
}

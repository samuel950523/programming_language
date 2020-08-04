package com.linkedlist;

public class NodeStack{

	private Node head;

	// 연결리스트의 마지막 원소 찾기
	public Node getLastNode() {
		Node currNode = head;
		if (currNode != null) {
			while (currNode.link != null) {
				currNode = currNode.link;
			}
		}
		return currNode;
	}

	// 연결리스트의 마지막 원소로 삽입하기
	public void addLastNode(String data) {
		Node newNode = new Node(data);
		Node lastNode = getLastNode();

		// 마지막 노드가 없는 경우(공백리스트)
		// 새 노드를 head 노드에 연결한다.
		if (lastNode == null) {
			head = newNode;
		} else {
			// 마지막 노드가 있는 경우
			// 마지막 노드에 새 노드를 연결한다.
			lastNode.link = newNode;
		}
	}
	
	// 연결리스트의 첫번째 원소로 삽입하기
	public void addFirstNode(String data){
		Node newNode = new Node(data,head);
		head = newNode;
	}	
	public void printList() {
		for (Node currNode = head; currNode != null; currNode = currNode.link) {
			System.out.print(currNode);
		}
		System.out.println();
	}

	public Node peek() {
		return getLastNode();
	}

	public Node pop() {
		
		Node currNode = head;
		Node lastPrevNode = null;
		if (currNode != null) {
			while (currNode.link != null) {
				if( currNode.link.link == null ) lastPrevNode = currNode;
				currNode = currNode.link;
			}
		}
		
		Node lastNode = currNode;
		lastPrevNode.link = null;

		return lastNode;
	}
	
	public void push(Node n) {
		Node lastNode = getLastNode();

		// 마지막 노드가 없는 경우(공백리스트)
		// 새 노드를 head 노드에 연결한다.
		if (lastNode == null) {
			head = n;
		} else {
			// 마지막 노드가 있는 경우
			// 마지막 노드에 새 노드를 연결한다.
			lastNode.link = n;
		}
	}

	public void printStack() {
		printList();
	}

	public boolean isEmpty() {
		return head == null ? true : false;
	}
	
}

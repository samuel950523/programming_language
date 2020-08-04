package com.linkedlist;

public class MyStack {

	// 헤드 잘못되면 리스트가 망가질 수 있으므로 private으로 선언
	// 노드 타입, 저장하려는 타입에 맞추면 된다.
	private Node head; // addFirstLinkedList 가 스택의 형태이므로 head는 top의 역할이라고 생각하면 된다.
	// 데이터 이동해서 노드 만든다음에 첫번째에 삽입

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

	public void addFirstNode(String data) {
		// (data, link)가 기본인데 내가 첫번째가 되려면 첫번째가 가리키는 값을 내가 가지도록 해야하므로 link -> head로 바
		Node newNode = new Node(data, head);
		// 헤드는 첫 노드를 저장하고 있는 첫 노드 자기 자신
		head = newNode;
	}

	public void printList() {

		for (Node currNode = head; currNode != null; currNode = currNode.link) {
			System.out.print(currNode.data + " ");
		}
		System.out.println();
	}

	public void push(String data) {

	}

//	public String pop() {
//
//	}
//
//	public String peek() {
//
//	}
//
//	public boolean isEmpty() {
//
//	}
}

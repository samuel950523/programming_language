package com.linkedlist;

public class Node {

    // 알고리즘 문제 풀 때는 private, get/set 사용하지 않고 직접 접근하는 게 시간적으로 더 이점임!!!!
    // 데이터 필드
    String data;
    // 링크 필드
    Node link;

    public Node(String data, Node link) {
        this(data); // this.data = data; 형태로 선언해도 가능
        this.link = link;
    }

    // data만 갖는 생성자
    public Node(String data) {
        this.data = data;
    }
}

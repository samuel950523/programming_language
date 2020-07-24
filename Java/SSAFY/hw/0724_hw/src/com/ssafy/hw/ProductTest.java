package com.ssafy.hw;

import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ProductMgr mg = ProductMgr.getInstance();

		while (true) {
			System.out.println("<<< 상품 관리 프로그램 >>>");
			System.out.println("1. 상품 정보 입력");
			System.out.println("2. 상품 정보 전체보기");
			System.out.println("3. 상품 번호로 검색");
			System.out.println("4. 상품 번호로 삭제");
			System.out.println("5. 특정 가격 이하의 상품만 검색");
			System.out.println("0. 종료");
			System.out.print("원하는 번호를 선택하세요 : ");

			// 번호 선택
			int inputNum = Integer.parseInt(sc.nextLine());

			switch (inputNum) {
			case 1: // 상품 정보 입력
				Product p = new Product();
				System.out.println("[상품 정보 입력]");
				System.out.print("상품 번호를 입력하세요 : ");
				p.setNum(Integer.parseInt(sc.nextLine()));
				System.out.print("상품 이름을 입력하세요 : ");
				p.setName(sc.nextLine());
				System.out.print("상품 가격을 입력하세요 : ");
				p.setPrice(Integer.parseInt(sc.nextLine()));
				System.out.print("상품 수량을 입력하세요 : ");
				p.setAmount(Integer.parseInt(sc.nextLine()));
				mg.add(p);
				System.out.println("상품 정보 입력이 완료되었습니다.\n");
				break;

			case 2: // 상품 정보 전체보기
				mg.list();
				break;

			case 3: // 상품 번호로 검색
				System.out.println("검색하고자 하는 상품 번호를 입력하세요 : ");
				mg.list(Integer.parseInt(sc.nextLine()));
				break;

			case 4: // 상품 번호로 삭제
				System.out.println("삭제하고자 하는 상품 번호를 입력하세요 : ");
				mg.delete(Integer.parseInt(sc.nextLine()));
				System.out.println("삭제가 완료되었습니다.");
				break;

			case 5: // 특정 가격 이하의 상품만 검색
				System.out.println("가격을 입력하세요 : ");
				mg.priceList(Integer.parseInt(sc.nextLine()));
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				return;

			default:
				System.out.println("잘못된 번호입니다. 다시 입력하세요");
				break;
			}
		}
	}
}

/* 상품 정보 입력 예시

1
1
p1
1000
100
1
2
p2
2000
200
1
3
p3
3000
300

*/
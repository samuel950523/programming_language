package com.ssafy;

import java.util.List;
import java.util.Scanner;

public class BookTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IBookMgr bookMgr = new BookMgrImpl();

		while (true) {
			System.out.println("****************************");
			System.out.println("기능을 선택하세요.");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 전체 검색");
			System.out.println("3. 도서 판매");
			System.out.println("4. 도서 구매");
			System.out.println("0. 종료");
			System.out.println("****************************");

			int caseNum = Integer.parseInt(sc.nextLine());
			if (caseNum == 0)
				break;

			switch (caseNum) {
			case 1:
				System.out.println("책의 종류를 선택하시오.");
				System.out.println("-> 1. Book");
				System.out.println("-> 2. Magazine");
				int kinds = Integer.parseInt(sc.nextLine());
				if (kinds == 1) {
					System.out.println("책 정보를 입력하시오.");
					System.out.println("ex)고유번호 제목 가격 수량");
					String arr[];
					String str = sc.nextLine();
					arr = str.split(" ");
					bookMgr.add(new Book(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3])));
				} else if (kinds == 2) {
					System.out.println("잡지 정보를 입력하시오.");
					System.out.println("ex)고유번호 제목 가격 수량 달");
					String arr[];
					String str = sc.nextLine();
					arr = str.split(" ");
					bookMgr.add(new Magazine(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]),
							Integer.parseInt(arr[4])));
				}
				break;
			case 2:
				List<Book> list =bookMgr.search();
				for (Book book : list) {
					System.out.println(book);
				}
				break;
			case 3:
				System.out.println("판매할 책의 isbn과 수량을 입력하세요.");
				try {
					bookMgr.sell(sc.nextLine(), sc.nextInt());
					System.out.println("판매 완료되었습니다.");
				} catch (ISBNNotFoundException e) {
					System.out.println("검색 실패 :" + e.getMessage());
					e.printStackTrace();
				} catch (QuantityException e) {
					System.out.println("수량 부족:" + e.getMessage());
				}
				break;
			case 4:
				System.out.println("구매할 책의 isbn과 수량을 입력하세요.");
				try {
					bookMgr.buy(sc.nextLine(), sc.nextInt());
					System.out.println("구매 완료되었습니다.");
				} catch (ISBNNotFoundException e) {
					System.out.println("검색 실패 :" + e.getMessage());
					e.printStackTrace();
				}
				break;
			}
		}
	}
}

/*
 * abc123 title1 1000 10
 * abc234 title2 2000 20
 * m123 title3 3000 30 3
 * m234 title4 4000 40 4
 */

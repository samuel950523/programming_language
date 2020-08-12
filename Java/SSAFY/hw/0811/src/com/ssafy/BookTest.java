package com.ssafy;

import java.util.List;
import java.util.Scanner;

public class BookTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IBookMgr bookMgr = new BookMgrImplList();
		
		while (true) {
			System.out.println("****************************");
			System.out.println("기능을 선택하세요.");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 전체 검색");
			System.out.println("3. 고유번호로 검색");
			System.out.println("4. 재목으로 검색");
			System.out.println("5. 책만 검색");
			System.out.println("6. 잡지만 검색");
			System.out.println("7. 올해의 잡지만 검색(2020)");
			System.out.println("8. 출판사로 검색");
			System.out.println("9. 가격으로 검색(가격미만)");
			System.out.println("10. 모든 도서의 금액 합");
			System.out.println("11. 모든 도서의 금액 평균");
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
					System.out.println("ex)고유번호 제목 작가 출판사 가격 설명");
					String arr[];
					String str = sc.nextLine();
					arr = str.split(" ");
					bookMgr.input(new Book(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), arr[5]));
				}
				else if(kinds == 2) {
					System.out.println("잡지 정보를 입력하시오.");
					System.out.println("ex)고유번호 제목 작가 출판사 가격 설명 연도 달");
					String arr[];
					String str = sc.nextLine();
					arr = str.split(" ");
					bookMgr.input(new Magazine(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), arr[5], Integer.parseInt(arr[6]), Integer.parseInt(arr[7])));
				}
				break;
			case 2:
				print(bookMgr.searchAll());
				break;
			case 3:
				System.out.println("검색할 고유번호를 입력하시오.");
				System.out.println(bookMgr.searchIsbn(sc.nextLine()));
				break;
			case 4:
				System.out.println("검색할 제목을 입력하시오.");
				print(bookMgr.searchTitle(sc.nextLine()));
				break;
			case 5:
				print(bookMgr.searchBook());
				break;
			case 6:
				print2(bookMgr.searchMagazine());
				break;
			case 7:
				print2(bookMgr.searchMagazineByCurrentYear());
				break;
			case 8:
				System.out.println("검색할 출판사를 입력하시오.");
				print(bookMgr.searchPublisher(sc.nextLine()));
				break;
			case 9:
				System.out.println("검색할 가격을 입력하시오.(미만으로 검색)");
				print(bookMgr.searchPrice(Integer.parseInt(sc.nextLine())));
				break;
			case 10:
				System.out.println("모든 도서 가격의 합 : "+bookMgr.getSum());
				break;
			case 11:
				System.out.println("모든 도서 가격의 평균 : "+bookMgr.getAverage());
				break;

			}
		}
	}
	private static void print(List<Book> list) {
		for (Book book : list) {
			System.out.println(book.toString());
		}
	}
	private static void print2(List<Magazine> list) {
		for (Magazine book : list) {
			System.out.println(book.toString());
		}
	}	
}

/*
abc123 나의라임오렌지나무 여인구 행복출판사 20000 행복하다
aaa112 나니아연대기 여인팔 불행출판사 30000 불행하다
m1 월간알고 김태희 싸피 10000 알고정복 2020 8
m2 주간알고 홍길동 삼성출판사 12000 알고기초 2019 8
*/

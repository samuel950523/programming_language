package com.ssafy;

import java.util.Scanner;

public class BookTest {
	Scanner sc = new Scanner(System.in);
	BookManager bmr = new BookManager();

	public static void main(String[] args) {
		BookTest m = new BookTest();
		int num = 0;
		while (true) {
			num = m.menu();
			if (num == 0)
				break;
			switch (num) {
			case 1:
				m.insert();
				break;
			case 2:
				m.search();
				break;
			case 3:
				m.searchIsbn();
				break;
			case 4:
				m.searchTitle();
				break;
			case 5:
				m.searchBook();
				break;
			case 6:
				m.searchMagazine();
				break;
			case 7:
				m.searchPublisher();
				break;
			case 8:
				m.searchPrice();
				break;
			default:
				System.err.println("메뉴 번호를 정확히 입력해 주세요.");
				continue;
			}// end switch

		} // end while

	}

	public int menu() {
		int result = 0;
		System.out.println("==================================");
		System.out.println("========== 도서 관리 프로그램 ==========");
		System.out.println("==================================");
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 전체 목록 보기");
		System.out.println("3. 도서 검색(Isbn으로 검색)");
		System.out.println("4. 도서 검색(Title로 검색)");
		System.out.println("5. Book 검색");
		System.out.println("6. Magazine 검색");
		System.out.println("7. 도서 검색(출판사로 검색)");
		System.out.println("8. 도서 검색(가격으로 검색)");
		System.out.println("0. 종료");
		System.out.println("원하는 번호를 선택 하세요.");

		result = sc.nextInt();

		return result;
	}


	public void insert() {
		System.out.println("도서 정보를 입력하세요.\n형식(Book):Isbn,title,author,publisher,price,desc");
		String[] info = sc.next().split(",");
		bmr.add(new Book(info[0], info[1], info[2], info[3], Integer.parseInt(info[4]), Integer.parseInt(info[5])));

	}

	public void search() {
		System.out.println(">>>>>>>> 도서 목록 보기 ");
		Book[] books = bmr.search();
		if (books.length == 0) {
			System.err.println("도서 정보가 없습니다.");
			return;
		}
		for (Book e : books) {
			System.out.println(e);
		}
	}

	public void searchIsbn() {
		System.out.println(">>>>>>>>  도서  검색 (Isbn으로 검색) ");
		System.out.println("검색하고자하는 도서의 Isbn을 입력하세요.");
		String isbn = sc.next();
		Book e = bmr.searchIsbn(isbn);
		if (e != null)
			System.out.println(e);
		else
			System.err.println("검색 실패~~~ Isbn을 확인하세요.");
	}

	public void searchTitle() {
		System.out.println(">>>>>>>>  도서  검색 (제목으로 검색) ");
		System.out.println("검색하고자하는 제목을 입력하세요.");
		String title = sc.next();
		Book[] e = bmr.searchTitle(title);
		if (e != null) {
			for (int i = 0; i < e.length; i++) {
				System.out.println(e[i]);
			}
		} else
			System.err.println("검색 실패~~~ 제목을 확인하세요.");
	}

	public void searchBook() {
		Book[] books = bmr.searchBook();
		if (books.length == 0) {
			System.err.println("Book 정보가 없습니다.");
			return;
		}
		for (Book e : books) {
			System.out.println(e);
		}

	}

	public void searchMagazine() {
		Book[] books = bmr.searchMagazine();
		if (books.length == 0) {
			System.err.println("Magazine 정보가 없습니다.");
			return;
		}
		for (Book e : books) {
			System.out.println(e);
		}
	}

	public void searchPublisher() {
		System.out.println(">>>>>>>>  도서  검색 (출판사로 검색) ");
		System.out.println("검색하고자하는 출판사를 입력하세요.");
		String publisher = sc.next();
		Book e = bmr.searchPublisher(publisher);
		if (e != null)
			System.out.println(e);
		else
			System.err.println("검색 실패~~~ 출판사를 확인하세요.");
	}

	public void searchPrice() {
		System.out.println(">>>>>>>>  도서  검색 (가격으로 검색) ");
		System.out.println("검색하고자하는 가격을 입력하세요.");
		int price = sc.nextInt();
		Book[] e = bmr.searchPrice(price);
		if (e != null) {
			for (int i = 0; i < e.length; i++) {
				System.out.println(e[i]);
			}
		} else
			System.err.println("검색 실패~~~ 가격을 확인하세요.");
	}
}

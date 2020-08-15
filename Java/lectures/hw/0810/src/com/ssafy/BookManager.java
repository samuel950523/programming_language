package com.ssafy;

public class BookManager {

	Book[] books = new Book[100];

	int index = 0;

	/** 데이터 입력 */
	public void add(Book b) {
		books[index] = b;
		index++;
	}

	/** 데이터 전체검색 */
	public Book[] search() {
		Book[] newbooks = new Book[index];
		for (int i = 0; i < index; i++) {
			newbooks[i] = books[i];
		}
		return newbooks;
	}

	/** isbn으로 검색 */
	public Book searchIsbn(String isbn) {
		for (int i = 0; i < index; i++) {
			if (books[i].getIsbn().equals(isbn))
				return books[i];
		}
		return null;
	}

	/** title로 검색 (제목을 포함하는 모든 정보) */
	public Book[] searchTitle(String title) {
		Book[] newbooks = new Book[index];
		int idx = 0;
		for (int i = 0; i < index; i++) {
			if (books[i].getTitle().contains(title)) {
				newbooks[idx] = books[i];
				idx++;
			}

		}
		return newbooks;
	}

	/** Book만 검색하는 기능 */
	public Book[] searchBook() {
		Book[] newbooks = new Book[index];
		int idx = 0;
		for (int i = 0; i < index; i++) {
			if (books[i] instanceof Book) {
				newbooks[idx] = books[i];
				idx++;
			}
		}
		return newbooks;
	}

	/** Magazine만 검색하는 기능 */
	public Book[] searchMagazine() {
		Book[] newbooks = new Book[index];
		int idx = 0;
		for (int i = 0; i < index; i++) {
			if (books[i] instanceof Magazine) {
				newbooks[idx] = books[i];
				idx++;
			}
		}
		return newbooks;
	}

	/** 출판사로 검색 */
	public Book searchPublisher(String publisher) {
		for (int i = 0; i < index; i++) {
			if (books[i].getPublisher().equals(publisher))
				return books[i];
		}
		return null;
	}

	/** 가격으로 검색 기능(파라메터로 주어진 가격보다 낮은 도서 정보 검색) */
	public Book[] searchPrice(int price) {
		Book[] newbooks = new Book[index];
		for (int i = 0; i < index; i++) {
			if (books[i].getPrice() <= price) {
				newbooks[i] = books[i];
			}
		}
		return newbooks;
	}
}

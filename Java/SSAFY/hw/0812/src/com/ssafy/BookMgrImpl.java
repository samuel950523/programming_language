package com.ssafy;

import java.util.ArrayList;
import java.util.List;

public class BookMgrImpl implements IBookMgr {
	List<Book> list = new ArrayList<Book>();

	@Override
	public void add(Book b) {
		list.add(b);
	}

	@Override
	public List<Book> search() {
		return list;
	}

	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {
		for (Book book : list) {
			if (book.getIsbn().equals(isbn) && book.getQuantity() >= quantity) { // isbn이 있고 수량이 있다면
				book.setQuantity(book.getQuantity() - quantity); // 수량 줄여준다.
				if (book.getQuantity() == 0) // 모두 소진되었으면
					list.remove(book);
			}
		}
		throw new QuantityException();
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		for (Book book : list) {
			if (book.getIsbn().equals(isbn)) { // isbn이 있으면
				book.setQuantity(book.getQuantity() + quantity); // 수량 늘려줌
			}
		}
		throw new ISBNNotFoundException(isbn);
	}

	@Override
	public int getTotalAmount() {
		int sum = 0;
		for (Book book : list) {
			sum += book.getQuantity() * book.getPrice();
		}
		return sum;
	}

}

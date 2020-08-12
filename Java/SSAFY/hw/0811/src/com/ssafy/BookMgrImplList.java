package com.ssafy;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class BookMgrImplList implements IBookMgr {
	List<Book> list = new ArrayList<Book>();

	@Override
	public void input(Book book) {
		list.add(book);
	}

	@Override
	public List<Book> searchAll() {
		return list;
	}

	@Override
	public Book searchIsbn(String isbn) {
		for (Book book : list) {
			if(book.getIsbn().equals(isbn)) return book;
		}
		return null;
	}

	@Override
	public List<Book> searchTitle(String title) {
		ArrayList<Book> result = new ArrayList<Book>();
		for (Book book : list) {
			if(book.getTitle().contains(title)) result.add(book);
		}
		return result;
	}

	@Override
	public List<Book> searchBook() {
		ArrayList<Book> result = new ArrayList<Book>();
		for (Book book : list) {
			if(book instanceof Magazine) continue;
			result.add(book);
		}
		return result;
	}

	@Override
	public List<Magazine> searchMagazine() {
		ArrayList<Magazine> result = new ArrayList<Magazine>();
		for (Book book : list) {
			if(book instanceof Magazine) {
				Magazine m = (Magazine)book;
				result.add(m);
			}
		}
		return result;
	}

	public List<Magazine> searchMagazineByCurrentYear2() {
		ArrayList<Magazine> result = new ArrayList<Magazine>();
		for (Book book : list) {
			if(book instanceof Magazine) {
				Magazine m = (Magazine)book;
				if(m.getYear() == Calendar.getInstance().get(Calendar.YEAR)) result.add(m);
			}
		}
		return result;
	}
	@Override
	public List<Magazine> searchMagazineByCurrentYear() {
		List<Magazine> temp = searchMagazine();
		ArrayList<Magazine> result = new ArrayList<Magazine>();
		for (Magazine magazine : temp) {
			if(magazine.getYear() == 2020) result.add(magazine);
		}
		return result;
	}
	@Override
	public List<Book> searchPublisher(String publisher) {
		ArrayList<Book> result = new ArrayList<Book>();
		for (Book book : list) {
			if(book.getPublisher().equals(publisher)) result.add(book);
		}
		return result;
	}

	@Override
	public List<Book> searchPrice(int price) {
		ArrayList<Book> result = new ArrayList<Book>();
		for (Book book : list) {
			if(book.getPrice()<price) result.add(book);
		}
		return result;
	}

	@Override
	public int getSum() {
		int result =0;
		for (Book book : list) {
			result += book.getPrice();
		}
		return result;
	}

	@Override
	public double getAverage() {
		return (double)getSum()/list.size() ;
	}

}








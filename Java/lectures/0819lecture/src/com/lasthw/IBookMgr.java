package com.lasthw;

import java.util.List;

public interface IBookMgr {
	public abstract void input(Book book);
	public List<Book> searchAll();
	public Book searchIsbn(String isbn) throws ISBNNotFoundException ;
	public List<Book> searchTitle(String title);
	public List<Book> searchBook();
	public List<Magazine> searchMagazine();
	public List<Magazine> searchMagazineByCurrentYear();
	public List<Book> searchPublisher(String publisher);
	public List<Book> searchPrice(int price);
	public int getSum();
	public double getAverage();
	public void open();
	public void save();
	public void send();
}

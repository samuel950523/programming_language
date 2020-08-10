package com.ssafy;

public class Book {
	private String isbn, title, author, publisher;
	private int price, desc;

	public Book() {

	}

	public Book(String isbn, String title, String author, String publisher, int price, int desc) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", price=" + price + ", desc=" + desc + "]";
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDesc() {
		return desc;
	}

	public void setDesc(int desc) {
		this.desc = desc;
	}

}

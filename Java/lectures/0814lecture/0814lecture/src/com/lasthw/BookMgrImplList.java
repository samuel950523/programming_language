package com.lasthw;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class BookMgrImplList implements IBookMgr {
	List<Book> list = null;

	
	public BookMgrImplList() {
		open();
	}

	@Override
	public void input(Book book) {
		list.add(book);
	}

	@Override
	public List<Book> searchAll() {
		return list;
	}

	@Override
	public Book searchIsbn(String isbn) throws ISBNNotFoundException {
		for (Book book : list) {
			if(book.getIsbn().equals(isbn)) return book;
		}
		throw  new ISBNNotFoundException(isbn);
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

	@Override
	public void open() {
		File f = new File("book.dat");
		if(!f.exists()) {
			System.out.println("데이터파일이 없습니다.");
			list = new ArrayList<Book>();
			return;
		}
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
			System.out.println("데이터파일에서 데이터를 불러옵니다.");
			list = (List<Book>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save() {
		if(list ==null || list.size()==0) return;
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("book.dat"))) {
			out.writeObject(list);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}









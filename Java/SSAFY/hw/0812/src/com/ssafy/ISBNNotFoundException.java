package com.ssafy;

public class ISBNNotFoundException extends Exception {
	public ISBNNotFoundException(String isbn) {
		super("ISBN이 존재하지 않습니다. : " + isbn);
	}
}

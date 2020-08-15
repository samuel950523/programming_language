package com.lasthw;
public class ISBNNotFoundException extends Exception {

	public ISBNNotFoundException(String isbn) {
		super("isbn이 존재하지 않습니다. : "+isbn);
	}
}

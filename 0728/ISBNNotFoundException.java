package com.ssafy.ws08.fin;

public class ISBNNotFoundException extends RuntimeException {
	public ISBNNotFoundException() {
	}
	public ISBNNotFoundException(String isbn) {
		super(String.format("isbn %s번에 해당하는 책이 등록되지 않았습니다.", isbn));
	}
}

package com.ssafy.ws08.fin;

public class QuantityException extends RuntimeException {
	public QuantityException() {
	}
	public QuantityException(String isbn) {
		super("재고 수량이 부족합니다.");
	}
}

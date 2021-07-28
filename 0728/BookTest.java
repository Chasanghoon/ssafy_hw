package com.ssafy.ws05;

public class BookTest {
	public static void main(String[] args) {
		Book book1 = new Book();
		System.out.println(book1.toString());
		
		Book book2 = new Book("1", "자바와 함께하는 ssafy", "김싸피", "멀캠", 30000, "쉬운 자바를 더 쉽게!!!");
		System.out.println(book2);
	}
}

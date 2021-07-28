package com.ssafy.ws05;

public class BookManagerTest {

	public static void main(String[] args) {
		BookManager  mgr = new BookManager();
		
		
		mgr.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		mgr.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		mgr.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘",2021,1));
		
		printBooks(mgr.getList(),"도서 전체 목록");
		printBooks(mgr.getBooks(),"일반 도서 목록");
		printBooks(mgr.getMagazines(),"잡지 목록");
		printBooks(mgr.searchByTitle("java"),"도서 제목으로 검색:java");
		
		System.out.println(mgr.getTotalPrice());
		System.out.println(mgr.getPriceAvg());
		
		
	}
	
	public static void printBooks(Book[] books, String msg) {
		System.out.println("============================"+msg+"============================");
		for (Book book : books) {
			System.out.println(book);
		}
		
	}
}

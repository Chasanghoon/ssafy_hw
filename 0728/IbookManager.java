package com.ssafy.ws08.fin;

public interface IbookManager {

	Book searchByIsbn(String isbn);
	Book[] searchByTitle(String title);
	void add(Book book);
	void remove(String isbn);

	/**
	 * 저장된 book 정보를 반환하는 기능
	 * @return
	 */
	
	Book[] getList();
	Book[] getBooks();
	Magazine[] getMagazines();
	int getTotalPrice();
	double getPriceAvg();	
	void sell(String isbn, int quantity);
	void buy(String isbn, int quantity);

}
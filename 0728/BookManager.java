package com.ssafy.ws05;

import java.util.Arrays;

public class BookManager {
	private Book[] books;
	private int index;
	private final int MAX=100;
	public BookManager() {
		books=new Book[MAX];
	}
	private int fineIndex(String isbn) {
		if(isbn != null) {
			for (int i = 0; i < index; i++) {
				if(isbn.equals(books[i].getIsbn())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public Book searchByIsbn(String isbn) {
		int index = fineIndex(isbn);
		if(index==-1) {
			System.err.println(String.format("isbn %s번의 책을 찾을 수 없습니다.", isbn));
			return null;
		}else {
			return books[index];
		}
	}
	public Book[] searchByTitle(String title) {
		if(title!=null) {
			Book[] findBooks= new Book[index];
			int fIndex=0;
			title = title.toUpperCase();
			for(int i=0; i<index; i++) {
				if(books[i].getTitle().toUpperCase().contains(title)) {
					findBooks[fIndex++] = books[i];
				}
			}
			return Arrays.copyOfRange(findBooks, 0, fIndex);
		}else {
			System.err.println(String.format("찾을 책의 제목이 없습니다.", title));
			return null;
		}
	}
	
	
	public void add(Book book) {
		if(book !=null) {
			String isbn = book.getIsbn();
			if(isbn != null) {
				int findex = fineIndex(book.getIsbn());
				if(findex==-1) {
					if(index>=books.length) {
						System.err.println("더이상 저장할 공간이 없습니다. ");
					}else {
						books[index++] = book;
					}
				}
			}else {
				System.err.println("등록 책에 isbn을 입력하세요");
			}
		}else {
			System.err.println("등록 책 정보를 입력하세요");
		}
	}
	
	public void remove(String isbn) {
		int findex = fineIndex(isbn);
		if(findex==-1) {
			System.err.println("삭제할 책 정보를 찾지 못했습니다.");
		}else {
			books[findex] = books[--index];
		}
	}
	
	/**
	 * 저장된 book 정보를 반환하는 기능
	 * @return
	 */
	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, index);
	}
	
	public Book[] getBooks() {
		Book[] newBooks = new Book[index];
		int mIndex=0;
		for(int i=0; i<index; i++) {
			if (!(books[i] instanceof Magazine)) {
				newBooks[mIndex++] = books[i];
			}
		}
		return Arrays.copyOfRange(newBooks, 0, mIndex);
	}
	
	public Book[] getMagazines() {
		Book[] newBooks = new Book[index];
		int mIndex=0;
		for(int i=0; i<index; i++) {
			if (books[i] instanceof Magazine) {
				newBooks[mIndex++] = books[i];
			}
		}
		return Arrays.copyOfRange(newBooks, 0, mIndex);
	}
	
	public int getTotalPrice() {
		int total = 0;
		for(int i=0; i<index; i++) {
			total+= books[i].getPrice();
		}
		return total;
	}
	public double getPriceAvg() {
		return getTotalPrice()/(double)index;
	}
}

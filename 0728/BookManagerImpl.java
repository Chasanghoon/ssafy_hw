package com.ssafy.ws08.fin;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

// Singleton Pattern 적용
public class BookManagerImpl implements IbookManager {
	private List<Book> books = new ArrayList<>();
	//Singleton Pattern 적용
	private static IbookManager instance = new BookManagerImpl();
	private BookManagerImpl() { }
	public static IbookManager getInstance() {
		return instance;
	}
	
	private int fineIndex(String isbn) {
		if(isbn != null) {
			for (int i = 0, size=books.size(); i<size; i++) {
				if(isbn.equals(books.get(i).getIsbn())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public Book searchByIsbn(String isbn) {
		int index = fineIndex(isbn);
		if(index==-1) {
			throw new ISBNNotFoundException(isbn);			
		}else {
			return books.get(index);
		}
	}

	public Book[] searchByTitle(String title) {
		if(title!=null) {
			ArrayList<Book> temp = new ArrayList<Book>(10);
			int fIndex=0;
			title = title.toUpperCase();
			for(Book book : books) {
				if(book.getTitle().toUpperCase().contains(title)) {
					temp.add(book);
				}
			}
			
			Book[] result = new Book[temp.size()];
			return temp.toArray(result);
		}else {
			throw new BookException(String.format("책의 제목이 없음", title));
		}
	}
		
	
	public void add(Book book) {
		if(book !=null) {
			String isbn = book.getIsbn();
			if(isbn != null) {
				int findex = fineIndex(book.getIsbn());
				if(findex==-1) {
						books.add(book);
					}else {
						throw new BookException("이미 등록된 isbn입니다.");
					}
				}else {
					throw new BookException("등록된 책에 isbn을 입력하세여");
				}
			}else {
				throw new BookException("등록된 책에 isbn을 입력하세요");
		}
	}
	
	public void remove(String isbn) {
		int findex = fineIndex(isbn);
		if(findex==-1) {
			throw new ISBNNotFoundException(isbn);
		}else {
			books.remove(findex);
		}
	}
	
	public Book[] getList() {
		Book[] temp = new Book[books.size()];
		return books.toArray(temp);
	}
	
	public Book[] getBooks() {
		ArrayList<Book> temp = new ArrayList<>(10);
		for(Book book : books) {
			if(!(book instanceof Magazine)) {
				temp.add(book);
			}
		}
		Book[] result = new Book[temp.size()];
		return temp.toArray(result);
	}
	
	public Magazine[] getMagazines() {
		ArrayList<Book> temp = new ArrayList<>(10);
		for(Book book : books) {
			if(book instanceof Magazine) {
				temp.add(book);
			}
		}
		Magazine[] result = new Magazine[temp.size()];
		return temp.toArray(result);
	}
	
	public int getTotalPrice() {
		int total = 0;
		for(Book book : books) {
			total+= book.getPrice();
		}
		return total;
	}
	
	public double getPriceAvg() {
		return getTotalPrice()/(double)books.size();
	}
	
	public void sell(String isbn, int quantity) {
		Book findBook = searchByIsbn(isbn);
		int res = findBook.getQuantity() - quantity;
		if(res<0) throw new QuantityException();
		findBook.setQuantity(res);
	}
	
	public void buy(String isbn, int quantit){
		Book findBook = searchByIsbn(isbn);
		findBook.setQuantity(findBook.getQuantity()+quantit);
	}
}


package com.ssafy.ws05;

public class Magazine extends Book{
	private int year;
	private int month;
	public Magazine() {}
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month) {
		super(isbn, title, author, publisher, price, desc);
		setYear(year);
		setMonth(month);
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("\t| ").append(year).append("\t| ").append(month);
		return builder.toString();
	}
	
}
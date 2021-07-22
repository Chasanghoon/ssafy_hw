package com.ssafy.Product;

public class Product2 {
	// 냉장고의 정보를 표현
	private String number = "0002";
	private String name = "Refrigertor";
	private int price = 5000000;
	private int num = 2000;
	private String W = "500Wh";

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Refrigertor [제품 번호=").append(number).append(", 제품 이름=").append(name).append(", 가격=")
				.append(price).append(", 수량=").append(num).append(", 용량=").append(W).append("]");
		return builder.toString();
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getNum() {
		return num;
	}

	public String getW() {
		return W;
	}

}

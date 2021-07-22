package com.ssafy.Product;

public class Product1 {
	// TV의 정보를 표현
	private String number = "0001";
	private String name = "TV";
	private int price = 3000000;
	private int num = 5000;
	private int inch = 78;
	private String DisplayType = "Qled";

	// to String() 설정
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TV [제품 번호=").append(number).append(", 제품 이름=").append(name).append(", 가격=").append(price)
				.append(", 수량=").append(num).append(", 인치=").append(inch).append(", 디스플레이 타입=")
				.append(DisplayType).append("]");
		return builder.toString();
	}

	// Getter and Setter 설정
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

	public int getInch() {
		return inch;
	}

	public String getDisplayType() {
		return DisplayType;
	}
}

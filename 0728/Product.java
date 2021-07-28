package hwjava07_부울경_04반_차상훈;

public class Product {
	private String isbn;
	private String title;
	private int price;
	private int number;
	public Product() {}
	public Product(String isbn, String title, int price, int number) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.number = number;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String toString() {
		return isbn+"\t| "+title+"\t| "+price+"\t| "+number;
	}
}
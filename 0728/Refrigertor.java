package hwjava07_부울경_04반_차상훈;

public class Refrigertor extends Product {
	private int quantity;
	private int Wh;
	public Refrigertor() {}
	
	public Refrigertor(String isbn, String title, int price, int number, int quantity, int Wh) {
		super(isbn, title, price, number);
		setQuantity(quantity);
		setWh(Wh);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getWh() {
		return Wh;
	}

	public void setWh(int wh) {
		this.Wh = wh;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("\t| ").append(quantity).append("\t| ").append(Wh);
		return builder.toString();
	}
}

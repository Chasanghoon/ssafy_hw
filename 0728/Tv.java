package hwjava07_부울경_04반_차상훈;

public class Tv extends Product {
	private int inch;
	private String displaytype;
	public Tv() {}
	
	public Tv(String isbn, String title, int price, int number, int inch, String displaytype) {
		super(isbn, title, price, number);
		setInch(inch);
		setDisplaytype(displaytype);
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public String getDisplaytype() {
		return displaytype;
	}

	public void setDisplaytype(String displaytype) {
		this.displaytype = displaytype;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("\t| ").append(inch).append("\t| ").append(displaytype);
		return builder.toString();
	}
}
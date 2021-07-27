package hwjava06_부울경_04반_차상훈;

public class Refrigertor extends Product {
	public static void main(String[] args) {
		Refrigertor ref = new Refrigertor();
		System.out.println(ref.toString());
	}
	
	public Refrigertor() {}
	
	public Refrigertor(String refnumber, String refname, int refprice, int refnum, String refW) {
		this.refnumber = refnumber;
		this.refname = refname;
		this.refprice = refprice; 
		this.refnum = refnum;
		this.refW = refW;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("냉장고 제품번호: ").append(getRefnumber()).append(", 냉장고 이름: ")
				.append(getRefname()).append(",냉장고 가격: ").append(getRefprice()).append(", 냉장고 갯수: ")
				.append(getRefnum()).append(", 냉장고 전력: ").append(getRefW());
		return builder.toString();
	}
}

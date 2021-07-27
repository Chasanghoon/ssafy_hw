package hwjava06_부울경_04반_차상훈;

public class Tv extends Product {
	public static void main(String[] args) {
		Tv Tv = new Tv();
		System.out.println(Tv.toString());
	}
	
	public Tv() {}
	
	public Tv(String tvnumber, String tvname, int tvprice, int tvnum, int tvinch, String tvDisplayType) {
		this.tvnumber = tvnumber;
		this.tvname = tvname;
		this.tvprice = tvprice;
		this.tvnum = tvnum;
		this.tvinch = tvinch;
		this.tvDisplayType = tvDisplayType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TV 제품번호: ").append(getTvnumber()).append(", TV 이름 : ").append(getTvname())
				.append(", TV 가격 : ").append(getTvprice()).append(", TV 갯수 : ").append(getTvnum())
				.append(", TV 인치 : ").append(getTvinch()).append(", TV 디스플레이 타입 : ").append(getTvDisplayType());
		return builder.toString();
	}	
}
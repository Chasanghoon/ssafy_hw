package hwjava06_부울경_04반_차상훈;

public class Product {
	//공통 
	// TV의 정보를 표현
	public String tvnumber;
	public String tvname;
	public int tvprice;
	public int tvnum;
	public int tvinch;
	public String tvDisplayType;
	
	//Refrigertor의 정보를 표현
	public String refnumber;
	public String refname;
	public int refprice;
	public int refnum;
	public String refW;
	
	public Product() {}
	
	public Product(String tvnumber, String tvname, int tvprice, int tvnum, int tvinch, String tvDisplayType, String refnumber, String refname, int refprice, int refnum, String refW) {
		this.tvnumber = tvnumber;
		this.tvname = tvname;
		this.tvprice = tvprice;
		this.tvnum = tvnum;
		this.tvinch = tvinch;
		this.tvDisplayType = tvDisplayType;
		this.refnumber = refnumber;
		this.refname = refname;
		this.refprice = refprice; 
		this.refnum = refnum;
		this.refW = refW;
	}
	
	public String getTvnumber() {
		return tvnumber;
	}

	public void setTvnumber(String tvnumber) {
		this.tvnumber = tvnumber;
	}

	public String getTvname() {
		return tvname;
	}

	public void setTvname(String tvname) {
		this.tvname = tvname;
	}

	public int getTvprice() {
		return tvprice;
	}

	public void setTvprice(int tvprice) {
		this.tvprice = tvprice;
	}

	public int getTvnum() {
		return tvnum;
	}

	public void setTvnum(int tvnum) {
		this.tvnum = tvnum;
	}

	public int getTvinch() {
		return tvinch;
	}

	public void setTvinch(int tvinch) {
		this.tvinch = tvinch;
	}

	public String getTvDisplayType() {
		return tvDisplayType;
	}

	public void setTvDisplayType(String tvDisplayType) {
		this.tvDisplayType = tvDisplayType;
	}

	public String getRefnumber() {
		return refnumber;
	}

	public void setRefnumber(String refnumber) {
		this.refnumber = refnumber;
	}

	public String getRefname() {
		return refname;
	}

	public void setRefname(String refname) {
		this.refname = refname;
	}

	public int getRefprice() {
		return refprice;
	}

	public void setRefprice(int refprice) {
		this.refprice = refprice;
	}

	public int getRefnum() {
		return refnum;
	}

	public void setRefnum(int refnum) {
		this.refnum = refnum;
	}

	public String getRefW() {
		return refW;
	}

	public void setRefW(String refW) {
		this.refW = refW;
	}

	
	@Override
	public String toString() {
		return tvnumber+"\t| "+ tvname+"\t| "+ tvprice+"\t| "+ tvnum+"\t| "+ tvinch+"\t| "+ tvDisplayType+"\t| "+ refnumber+"\t| "+ refname+"\t| "+ refprice+"\t| "+ refnum+"\t| "+ refW;
	}
	
}

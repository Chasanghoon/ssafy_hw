package hwjava07_부울경_04반_차상훈;

import java.util.ArrayList;

public interface IProductMgr {
	Product searchByIsbn(String isbn);				//상품정보 조회
	ArrayList<Product> getList();					//상품전체 조회-
	ArrayList<Tv> getTv();							//TV 조회
	ArrayList<Refrigertor> getRef();				//냉장고 조회
	int getTotalPrice();							//전체 재고 상품 금액
	ArrayList<Product> searchByTitle(String title);			// title...
	void add(Product prod);							//상품정보 저장-
	void remove(String isbn);						//상품정보 삭제
	void pricechange(String isbn, int quantity);	//상품 가격 변경
	ArrayList<Refrigertor> get400LRefrigerator();	//400L 이상 냉장고 조회
	ArrayList<Tv> get50InchTv();					//50inch이상 Tv 조회
}

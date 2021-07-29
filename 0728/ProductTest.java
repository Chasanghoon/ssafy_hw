package hwjava07_부울경_04반_차상훈;

import java.util.Arrays;

public class ProductTest {
	public static void main(String[] args) {
		IProductMgr mgr = ProductMgrImpl.getInstance();

		mgr.add(new Tv("1", "SamTv", 3000000, 31, 78, "Qled"));
		mgr.add(new Tv("2", "SamTv1", 3200000, 25, 60, "led"));
		mgr.remove("1");
		mgr.add(new Tv("1", "SamTv", 3000000, 36, 78, "50"));
		mgr.add(new Refrigertor("3", "SamRefs",3000000, 38, 80, 50));
		
		System.out.println("**********************제품 전체 목록**********************");
		for (Product p : mgr.getList()) {
			System.out.println(p);
		}
		System.out.println("**********************Tv 전체 목록**********************");
		for (Product p : mgr.getTv()) {
			System.out.println(p);
		}
		System.out.println("**********************Ref 전체 목록**********************");
		for (Product p : mgr.getRef()) {
			System.out.println(p);
		}
		System.out.println("**********************제품 이름 포함검색**********************");
		for (Product p : mgr.searchByTitle("SamRef")) {
			System.out.println(p);
		}
		System.out.println("===================================상품 가격==================================");
		System.out.println(mgr.getTotalPrice());
		System.out.println("===================================번호 조회==================================");
		System.out.println(mgr.searchByIsbn("2"));
		
		try {
			// 상품번호와 가격을 입력받아서 수정
			System.out.println("**********************수량:3000000원->500000원**********************");
			mgr.pricechange("3",500000);
		} catch (ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(mgr.searchByIsbn("3"));
	}	

	public static void printProuds(Product[] prods, String msg) {
			System.out.println("============================"+msg+"============================");
			for (Product prod : prods) {
				System.out.println(prod);
			}	
	}
}


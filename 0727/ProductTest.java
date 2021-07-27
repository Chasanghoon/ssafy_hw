package hwjava06_부울경_04반_차상훈;

import java.util.Arrays;

public class ProductTest {
	public static void main(String[] args) {
		ProductMgr mgr = new ProductMgr();

		mgr.add(new Tv("1", "SamTv", 3000000, 3515, 78, "Qled"));
		mgr.add(new Tv("2", "SamTv1", 3200000, 3625, 60, "led"));
		mgr.remove("1");
		mgr.add(new Tv("1", "SamTv", 3000000, 3515, 78, "Qled"));
		printProuds(mgr.getList(), "제품 전체 목록 ");
		printProuds(mgr.getTv(), "Tv 전체 목록 ");
		printProuds(mgr.searchByTitle("SamTv1"),"제품명으로 검색:SamTv1");
		
		
		
		System.out.println("상품 가격");
		System.out.println(mgr.getTotalPrice());
	}

	public static void printProuds(Product[] prods, String msg) {
			System.out.println("============================"+msg+"============================");
			for (Product prod : prods) {
				System.out.println(prod);
			}	
	}
}

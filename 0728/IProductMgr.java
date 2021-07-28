package hwjava07_부울경_04반_차상훈;

public interface IProductMgr {
	Product searchByIsbn(String isbn);
	Product[] searchByTitle(String title);
	void add(Product prod);
	void remove(String isbn);
	
	Product[] getList();
	Product[] getTv();
	Product[] getRef();
	int getTotalPrice();
	
	void pricechange(String isbn, int quantity);
}

package hwjava07_부울경_04반_차상훈;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PDLOverrideSupported;

public class ProductMgrImpl implements IProductMgr {
	private List<Product> prods = new ArrayList<>();
	private static IProductMgr instance = new ProductMgrImpl();

	private ProductMgrImpl() {
	}

	public static IProductMgr getInstance() {
		return instance;
	}

	private int fineIndex(String isbn) {
		if (isbn != null) {
			for (int i = 0, size = prods.size(); i < size; i++) {
				if (isbn.equals(prods.get(i).getIsbn())) {
					return i;
				}
			}
		}
		return -1;
	}

	//public Product searchByIsbn(String isbn) {
	public Product searchByIsbn(String isbn) {
		int index = fineIndex(isbn);
		if (index == -1) {
			System.err.println(String.format("productnumber %s번의 제품을 찾을 수 없습니다.", isbn));
			return null;
		} else {
			return prods.get(index);
		}
	}

	public ArrayList<Product> searchByTitle(String title) {
		if (title != null) {
			ArrayList<Product> temp = new ArrayList<Product>(10);
			int fIndex = 0;
			title = title.toUpperCase();
			for (Product prod : prods) {
				if (prod.getTitle().toUpperCase().contains(title)) {
					temp.add(prod);
				}
			}
			return temp;
		}else {
			throw new ProductException(String.format("제품의 이름이 없음",title));
		}
	}
			
	public void add(Product product) {
		if (product != null) {
			String prodnum = product.getIsbn();
			if (prodnum != null) {
				int findex = fineIndex(product.getIsbn());
				if (findex == -1) {
					prods.add(product);
				} else {
					throw new ProductException("이미 등록된 isbn입니다.");
				}
			} else {
				throw new ProductException("등록 제품에 isbn을 입력하세요");
			}
		} else {
			throw new ProductException("등록된 제품에 isbn을 입력하세요");
		}
	}

	public void remove(String isbn) {
		int findex = fineIndex(isbn);
		if (findex == -1) {
			throw new ISBNNotFoundException(isbn);
		} else {
			prods.remove(findex);
		}
	}

	/**
	 * 저장된 book 정보를 반환하는 기능
	 * 
	 * @return
	 */

	public ArrayList<Product> getList(){
		ArrayList<Product> temp = new ArrayList<>(10);
		for(Product prod : prods) {
			if(prod instanceof Product) {
				temp.add((Product) prod);
			}
		}
		return temp;
	}
	
	public ArrayList<Tv> getTv(){
		ArrayList<Tv> temp = new ArrayList<>(10);
		for(Product prod : prods) {
			if(prod instanceof Tv) {
				temp.add((Tv) prod);
			}
		}
		return temp;
	}

	public ArrayList<Refrigertor> getRef() {
		ArrayList<Refrigertor> temp = new ArrayList<>(10);
		for (Product prod : prods) {
			if (prod instanceof Refrigertor) {
				temp.add((Refrigertor) prod);
			}
		}
		return temp;
	}
	
	@Override
	public ArrayList<Refrigertor> get400LRefrigerator(){
		ArrayList<Refrigertor> temp = new ArrayList<>(10);
		for (Product prod : prods) {
			if(prod instanceof Refrigertor) {
				Refrigertor r = (Refrigertor) prod;
				if(r.getWh()>=400) {
					temp.add((Refrigertor)prod);
				}
			}
		}
		return temp;
	}
	
	public ArrayList<Tv> get50InchTv(){
		ArrayList<Tv> temp = new ArrayList<>(10);
		for(Product prod : prods) {
			if(prod instanceof Tv) {
				Tv t = (Tv) prod;
				if(t.getInch()>=50) {
					temp.add((Tv)prod);
				}
			}
		}
		return temp;
	}

	public int getTotalPrice() {
		int num = 0;
		int price = 0;
		for (Product prod : prods) {
			price += prod.getPrice();
			num += prod.getNumber();
		}
		int total = price * num;
		return total;
	}

	public void pricechange(String isbn, int quanaity) {
		Product findprod = searchByIsbn(isbn);
		findprod.setPrice(findprod.getPrice() + quanaity);
	}
}

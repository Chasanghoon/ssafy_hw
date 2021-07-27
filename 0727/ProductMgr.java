package hwjava06_부울경_04반_차상훈;

import java.util.Arrays;

import com.ssafy.ws03.step3.Book;

public class ProductMgr extends Product {
	private Tv[] tvs;
	private Refrigertor[] refs;
	private int index;
	private final int MAX = 10000;

	public ProductMgr() {
		tvs = new Tv[MAX];
		refs = new Refrigertor[MAX];
	}

	// Tv
	private int fineIndex(String tvnumber) {
		if (tvnumber != null) {
			for (int i = 0; i < index; i++) {
				if (tvnumber.equals(tvs[i].getTvnumber())) {
					return i;
				}
			}
		}
		return -1;
	}
	/*
	 * //Ref private int fineIndex1(String Refnumber) { if(Refnumber != null) { for
	 * (int i = 0; i < index; i++) { if(Refnumber.equals(refs[i].getRefnumber())) {
	 * return i; } } } return -1; }
	 */

	public Tv searchByTvnum(String tvnumber) {
		int index = fineIndex(tvnumber);
		if (index == -1) {
			System.err.println(String.format("tvnumber %s번의 Tv를 찾을 수 없습니다.", tvnumber));
			return null;
		} else {
			return tvs[index];
		}
	}

	public Tv[] searchByTitle(String Tvname) {
		if (Tvname != null) {
			Tv[] findTvs = new Tv[index];
			int fIndex = 0;
			Tvname = Tvname.toUpperCase();
			for (int i = 0; i < index; i++) {
				if (tvs[i].getTvname().toUpperCase().contains(Tvname)) {
					findTvs[fIndex++] = tvs[i];
				}
			}
			return Arrays.copyOfRange(findTvs, 0, fIndex);
		} else {
			System.err.println(String.format("찾을 책의 제목이 없습니다.", Tvname));
			return null;
		}
	}

	// Tv 추가
	public void add(Tv tvd) {
		if (tvd != null) {
			String tvnumber = tvd.getTvnumber();
			if (tvnumber != null) {
				int findex = fineIndex(tvd.getTvnumber());
				if (findex == -1) {
					if (index >= tvs.length) {
						System.err.println("더이상 저장할 공간이 없습니다. ");
					} else {
						tvs[index++] = tvd;
					}
				}
			} else {
				System.err.println("등록 Tv에 Tvnumber을 입력하세요");
			}
		} else {
			System.err.println("등록 Tv 정보를 입력하세요");
		}
	}

	public void remove(String tvnumber) {
		int findex = fineIndex(tvnumber);
		if (findex == -1) {
			System.err.println("삭제할 책 정보를 찾지 못했습니다.");
		} else {
			tvs[findex] = tvs[--index];
		}
	}
	/*
	 * //Ref 추가 public void addref(Refrigertor refd) { if(refd !=null) { String
	 * Refnumber = refd.getRefnumber(); if(Refnumber != null) { int findex =
	 * fineIndex(refd.getRefnumber()); if(findex==-1) { if(index>=refs.length) {
	 * System.err.println("더이상 저장할 공간이 없습니다. "); }else { refs[index++] = refd; } }
	 * }else { System.err.println("등록 냉장고에 Refnumber을 입력하세요"); } }else {
	 * System.err.println("등록 Ref 정보를 입력하세요"); } }
	 */

	public Tv[] getList() {
		return Arrays.copyOfRange(tvs, 0, index);
	}

	public Tv[] getTv() {
		Product[] newTvs = new Product[index];
		int mIndex = 0;
		for (int i = 0; i < index; i++) {
			if ((tvs[i] instanceof Product)) {
				newTvs[mIndex++] = tvs[i];
			}
		}
		return (Tv[]) Arrays.copyOfRange(tvs, 0, mIndex);
	}

	/*
	 * public Refrigertor[] getRef() { Refrigertor[] newRefs = new
	 * Refrigertor[index]; int mIndex=0; for (int i = 0; i < index; i++) {
	 * if((refs[i] instanceof Refrigertor)) { newRefs[mIndex++] =refs[i]; } } return
	 * (Refrigertor[]) Arrays.copyOfRange(refs, 0, mIndex); }
	 */

	public int getTotalPrice() {
		int num = 0;
		int price1 = 0;
		int price2=0;
		int total=0;
		
		for (int i = 0; i < index; i++) {
			price2 = tvs[i].getTvnum() * tvs[i].getTvprice(); 
			total += price2;
		}
		return total;
	}
}

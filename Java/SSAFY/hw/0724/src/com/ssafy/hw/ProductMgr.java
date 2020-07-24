package com.ssafy.hw;

public class ProductMgr {
	private Product[] products = new Product[100];
	private int index;

	// Singleton Design
	private static ProductMgr instance = new ProductMgr();

	private ProductMgr() {
	}

	public static ProductMgr getInstance() {
		return instance;
	}

	/** 상품을 저장하는 기능 */
	public void add(Product p) {
		products[index] = p;
		index++;
	}

	/** 저장된 상품들을 볼 수 있는 기능 */
	public void list() {
		for (int i = 0; i < index; i++) {
			System.out.println(products[i].toString());
		}
	}

	/** 상품 번호로 검색하는 기능 */
	public void list(int num) {
		for (int i = 0; i < index; i++) {
			if (products[i].getNum() == num) {
				System.out.println(products[i].toString());
			}
		}
	}

	/** 상품 번호로 삭제하는 기능 */
	public void delete(int num) {
		Product[] p = new Product[products.length];
		int cnt = 0;
		for (int i = 0; i < index; i++) {
			if (products[i].getNum() != num) {
				p[cnt] = products[i];
				cnt++;
			}
		}
		// products 업데이트
		products = p;
		index = cnt;
	}

	/** 특정 가격 이하의 상품만 검색하는 기능 */
	public void priceList(int price) {
		for (int i = 0; i < index; i++) {
			if(products[i].getPrice()<=price) {
				System.out.println(products[i].toString());
			}
		}
	}
}

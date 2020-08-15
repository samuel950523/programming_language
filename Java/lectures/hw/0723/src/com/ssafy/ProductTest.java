package com.ssafy;

public class ProductTest {
	public static void main(String[] args) {
		// TV
		TV tv = new TV();
		tv.setNum(1234);
		tv.setName("Samsung TV");
		tv.setPrice(1000000);
		tv.setAmount(5);
		tv.setInch(65);
		tv.setType('Q');
		
		// 냉장고
		Refrigerator fridge = new Refrigerator();
		fridge.setNum(9876);
		fridge.setName("Samsung Fridge");
		fridge.setPrice(1500000);
		fridge.setAmount(20);
		fridge.setVolume(800);
		
		// 출력
		System.out.println(tv.toString());
		System.out.println();
		System.out.println(fridge.toString());

	}
}

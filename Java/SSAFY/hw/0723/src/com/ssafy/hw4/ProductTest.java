package com.ssafy.hw4;

public class ProductTest {
	public static void main(String[] args) {
//		TV tv = new TV(); // new '생성자'호출
//		tv.no = "p01";
//		tv.name = "좋은 TV";
//		tv.price  = 1000000;
//		tv.amount = 100;
//		tv.inch = 56;
//		tv.displayType = "LED";

		TV tv = new TV("p01", "좋은 TV", 1000000, 100, 56, "LED");
		TV tv2 = new TV("p02", "덜 좋은 TV", 500000, 50, 40);
		TV tv3 = new TV("이름만 아는 TV");
		
 		// encapsulation
//		tv.price = -100000; // private으로 설정해야 이렇게 바꿀 수 없다.
//		tv.setPrice(-1000000);
		tv.setPrice(3000000); // write
//		System.out.println(tv.price); // error
		System.out.println(tv.getPrice()); // read
		
		System.out.println(tv); // 재정의를 하지 않으면 com.ssafy.hw4.TV@2a139a55
		System.out.println(tv.toString()); // 재정의를 하지 않으면 com.ssafy.hw4.TV@2a139a55 해쉬코드가 뜬다
	}
}

package com.ssafy.hw4;

public class TV {
	// 멤버 변수
	// private : only 자신
	// 아무것도 지정 안 하면 default : same package (package private)
	// protected : 남 -> default, 자식 -> public
	// public : all

	private String no; // static으로 만들면 class의 상태가 된다.
	private String name;
	private int price;
	private int amount;
	private int inch;
	private String displayType;

	// 생성자 : 아주 특별한 메소드 (객체 생성시에 호출되어 초기화를 담당)
	// 이름 = 클래스이름
	// 리턴 타입의 개념이 없다
	// 한 클래스 안에 여러개의 생성자 정의가 가능 (오버로딩 : 이름은 같고 매개변수가 다름)
	// 생성자는 상속 불가 (이름=클래스이름 때문에)
	// 클래스 내에 생성자가 단 1개도 없을 시, 자동으로 컴파일러가 기본 생성자 추가해줌
	// 생성자가 하나라도 있으면, 자동 추가 없음

	public TV() {
	} // 보통 기본 생성자 하나씩은 둔다.

	public TV(String name) {
		// this
		// 메소드, 생성자 안에서 현재 실행(생성)중인 객체 자기 자신을 가리키는 레퍼런스
		// 1. 지역변수와 멤버 변수 이름이 같을 때 구분 : this.변수
		// 2. 생성자 다중 정의 되어있는 상황에서 자신의 또 다른 생성자 호출 할 때 : this( )
		// 3. 자기 자신을 다른 객체에 전달하기 위해 사용 (매개변수 or 리턴값) : a.xxx(this) / return this
		this.name = name;
	}

	public TV(String no, String name, int price, int amount, int inch, String displayType) {
//		this.no = no;
//		this.name = name;
//		this.price = price;
//		this.amount = amount;
//		this.inch = inch;
		this(no, name, price, amount, inch); // this의 두번째 용법. 맨 처음에 와야한다.
		this.displayType = displayType;
	}

	// 생성자 오버로딩
	public TV(String no, String name, int price, int amount, int inch) {
		this.no = no;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.inch = inch;
	}

	// set+변수명
	public void setPrice(int price) {
//		if (price >= 0) {
//			this.price = price;
//		} else {
//			throw new IllegalArgumentException("가격이 음수가 될 수 없어요");
//		}
		if (price < 0)
			throw new IllegalArgumentException("가격이 음수가 될 수 없어요");
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	// 메소드 재정의 (다시 정의)
	// 전제조건 : 상속
	// 상속 받은 메소드를 다시 정의한다.
	// 1. 메소드 이름은 같아야한다.
	// 2. 매개변수 리스트가 같아야한다.
	// 3. 리턴 타입이 같아야한다.

//	public String toString() {
//		return "상품명 : " + name + " / 가격 : " + price;
//	}

	@Override
	public String toString() {
		return "TV [no=" + no + ", name=" + name + ", price=" + price + ", amount=" + amount + ", inch=" + inch
				+ ", displayType=" + displayType + "]";
	}
}

package com.ssafy.hw;

public class Product {
	// 상품 번호, 상품 이름, 가격, 수량
	private int num;
	private String name;
	private int price;
	private int amount;
	
	// Constructor
	public Product() {}
	
	public Product(int num, String name, int price, int amount) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	
	// encapsulation
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	// toString()
	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}
	
	
}

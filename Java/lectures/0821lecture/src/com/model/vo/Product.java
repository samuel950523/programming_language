package com.model.vo;

public class Product {
	private String no;
	private String name;
	private int price;
	private int amount;

	public Product() {
		super();
	}

	public Product(String no, String name, int price, int amount) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.amount = amount;
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

	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}

	
	
}

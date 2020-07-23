package com.ssafy;

public class Refrigerator {
	// 제품 번호, 제품 이름, 가격, 수량, 용량
	private int num;
	private String name;
	private int price;
	private int amount;
	private int volume;
	
	public Refrigerator(String name) {
		this.name = name;
	}
	public Refrigerator() {}
	
	public int getNum() {return num;}
	public void setNum(int num) {this.num=num;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price=price;}
	
	public int getAmount() {return amount;}
	public void setAmount(int amount) {this.amount=amount;}
	
	public int getVolume() {return volume;}
	public void setVolume(int volume) {this.volume=volume;}
	
	public String toString() {
		return "제품 이름 : "+this.name+" 제품 번호 : "+this.num
				+"\n가격 : "+this.price+" 수량 : "+this.amount
				+ "용량: "+this.volume;
	}
}

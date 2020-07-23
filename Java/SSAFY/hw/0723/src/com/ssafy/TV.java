package com.ssafy;

public class TV {
	// 제품 번호, 제품 이름, 가격, 수량, 인치, 디스플레이 타입
	private int num;
	private String name;
	private int price;
	private int amount;
	private int inch;
	private char type;
	
	public TV(String name) {
		this.name = name;
	}
	public TV() {}
	
	public int getNum() {return num;}
	public void setNum(int num) {this.num=num;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price=price;}
	
	public int getAmount() {return amount;}
	public void setAmount(int amount) {this.amount=amount;}
	
	public int getInch() {return inch;}
	public void setInch(int inch) {this.inch=inch;}
	
	public char getType() {return type;}
	public void setType(char type) {this.type=type;}
	
	public String toString() {
		return "제품 이름 : "+this.name+" 제품 번호 : "+this.num
				+"\n가격 : "+this.price+" 수량 : "+this.amount
				+"\n인치 : "+this.inch+ " 디스플레이 타입 : "+this.type;
	}
}

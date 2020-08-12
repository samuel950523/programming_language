package com.circle.flyer;

public class Bird implements Flyer {

	@Override
	public void land() {
		System.out.println("새가 날개를 이용하여 착륙합니다.");
	}

	@Override
	public void takeOff() {
		System.out.println("새가 날개를 이용하여 이륙합니다.");
	}

}

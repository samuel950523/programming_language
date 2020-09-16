package com.circle.flyer;

public class Airplanes implements Flyer {

	@Override
	public void land() {
		System.out.println("비행기가 착륙합니다.");
	}

	@Override
	public void takeOff() {
		System.out.println("비행기가 이륙합니다.");
	}

	public void chargeFuel() {
		System.out.println("비행기가 주유합니다.");
	}
}

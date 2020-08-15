package com.circle.flyer;

public class FlyerTest {

	public static void main(String[] args) {
		Bird b = new Bird();
		b.takeOff();
		Airplanes a = new Airplanes();
		a.takeOff();

		Airport ap = new Airport();
		ap.giveToLandPermission(b);
		ap.giveToLandPermission(a);
	}
}

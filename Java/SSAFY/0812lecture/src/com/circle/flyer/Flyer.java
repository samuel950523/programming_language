package com.circle.flyer;

public interface Flyer {

	int count = 3;
//	public static final int count = 3;

	// 착륙 가능
	public abstract void land();

	// 이륙 가능
	void takeOff();
//	public abstract void takeOff(); // 위와 같음
	
}

package com.shape;

public abstract class Shape {

	protected double area;

	public abstract void calcArea();

	public void printArea() {
		System.out.println("면적 : " + area);
	}
}

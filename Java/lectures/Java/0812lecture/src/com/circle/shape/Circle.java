package com.circle.shape;

import com.shape.Shape;

public class Circle extends Shape {

	double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public void calcArea() {
		area = Math.PI * radius * radius;
//		printArea();
	}

}

package com.circle.shape;

import com.shape.ShapeCalculator;

public class CircleTest {
	public static void main(String[] args) {
		
		Circle c = new Circle(2.0);
		ShapeCalculator sc = new ShapeCalculator();
		sc.calculate(c);

	}
}

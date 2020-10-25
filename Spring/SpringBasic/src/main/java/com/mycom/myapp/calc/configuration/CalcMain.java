package com.mycom.myapp.calc.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalcMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CalcConfiguration.class);
		
		Calculator calculator = context.getBean(Calculator.class);
		int n = calculator.add(7, 3);
		System.out.println(n);
		
		context.close();
	}
}

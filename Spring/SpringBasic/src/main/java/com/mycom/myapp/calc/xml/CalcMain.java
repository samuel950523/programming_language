package com.mycom.myapp.calc.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("calc-xml.xml");
		
		Calculator calculator = context.getBean(Calculator.class);
		int n = calculator.add(7, 3);
		System.out.println(n);
		
		context.close();
	}
}

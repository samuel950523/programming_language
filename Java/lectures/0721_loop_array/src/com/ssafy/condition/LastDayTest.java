package com.ssafy.condition;

public class LastDayTest {
	public static void main(String[] args) {
		int year = 2100;
		int month = 2;
		int lastDay = 0;
		
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			lastDay = 31;
			System.out.println(year + "년 "+ month + "월의 마지막 날짜는 "+lastDay+"일입니다.");
			break;
		case 4: case 6: case 9: case 11:
			lastDay = 30;
			System.out.println(year + "년 "+ month + "월의 마지막 날짜는 "+lastDay+"일입니다.");
			break;
		case 2:
			lastDay = 28;
			// 윤년 : 4의 배수이면서 100의 배수는 아님
			// 또는 400의 배수
			
//			if ((year%4==0 && year%100!=0) || year%400==0)  {
//				lastDay = 29;
//			}
			
			// 3항 연산자
//			lastDay = 윤년 ? 29 : 28
			lastDay = ((year%4==0 && year%100!=0) || year%400==0) ? 29 : 28;
			
			System.out.println(year + "년 "+ month + "월의 마지막 날짜는 "+lastDay+"일입니다.");
			break;
		default:
			System.out.println("유효하지 않은 달입니다.");
			break;
		}
	}
}

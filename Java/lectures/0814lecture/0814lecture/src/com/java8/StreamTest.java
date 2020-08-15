package com.java8;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {
	public static void main(String[] args) {

		List<String> names = new ArrayList<String>();
		names.add("김태희");
		names.add("이동욱");
		names.add("이지아");
		names.add("김재환");
		
		// '이' 글자가 포함된 이름이 몇 개인가?
		
		int cnt=0;
		for (String name : names) {
			if(name.contains("이"))
				cnt++;
		}
		
		System.out.println(cnt);
		
		System.out.println();
		
		System.out.println(names.stream().filter(name->name.contains("이")).count());
		
	}
}

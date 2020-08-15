package com.java8;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaTest1 {

	static class MyComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}

	}

	public static void main(String[] args) {

		Integer[] arr = { 3, 5, 1, 2, 7 };
		System.out.println(Arrays.toString(arr));

//		Arrays.sort(arr,new MyComparator());

//		Arrays.sort(arr,new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2.compareTo(o1);
//			}
//		});

//		Arrays.sort(arr, (Integer o1, Integer o2) -> {
//			return o2.compareTo(o1);
//		});

//		Arrays.sort(arr, (o1, o2) -> {
//			return o2.compareTo(o1);
//		});
		
		Arrays.sort(arr, (o1, o2) -> o2.compareTo(o1));
		
		System.out.println(Arrays.toString(arr));

	}
}

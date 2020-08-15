package com.ssafy.array;

public class ArrayTest {
	public static void main(String[] args) {

		int[] java = new int[3];
		java[0] = 100;
		java[1] = 90;
		java[2] = 80;

//		int[] algo = {100,99,98,97};
		int[] algo = new int[] { 100, 99, 98, 97 };

		for (int i = 0; i < java.length; i++) {
			System.out.println(java[i]);
		}

		for (int i = 0; i < algo.length; i++) {
			System.out.println(algo[i]);
		}

		int[] subject[] = new int[2][];
//		int[][] subject 
		subject[0] = java;
		subject[1] = algo;
		
		for (int i = 0; i < subject.length; i++) {
			for (int j = 0; j < subject[i].length; j++) {
				System.out.println(subject[i][j]);
			}
			System.out.println("-----------------------");
		}
		
		int[][] students[] = new int[][][] {
			subject,
			{
				{40,50,60,70},
				{55,66,77,88,99},
				{100,95}
			}
		};
		
		System.out.println("------- for each --------");
		for (int[][] student : students) {
			for (int[] sb : student) {
				for (int s : sb) {
					System.out.println(s);
				}
				System.out.println("-----------------------");
			}
			System.out.println("=====================");
		}
	}
}

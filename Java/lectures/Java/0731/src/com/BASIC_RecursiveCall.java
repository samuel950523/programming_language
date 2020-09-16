package com;

public class BASIC_RecursiveCall {
	public static void main(String[] args) {
//		m1();
//		m2();
//		m2_correct();
//		m2_correct2();

//		m3(5);
//		m4(4);
//		m4_reverse(0);
//		m5(0);
//		m6(0);
		factorial(5);
	}

	// #1. dummy - infinite - java.lang.StackOverflowError
	static void m1() {
//		System.out.println("m1");
		m1();
	}

	/* ------------------------------- */

	// #2. limit by count outside of r-call <-- 6/6
	static int m2_count = 5;

	// 쭉 들어갔다가 쭉 나온다.
	static void m2() {
		System.out.println("m2_count : " + m2_count);
		if (m2_count > 0) {
			m2_count--;
			m2();
		}
		System.out.println("m2_count : " + m2_count);
	}

	/* ------------------------------- */

	// #2_correct. limit by count outside of r-call <-- 6/5
	static int m2_correct_count = 5;

	static void m2_correct() {
		System.out.println("m2_correct_count : " + m2_correct_count);
		if (m2_correct_count == 0) {
			return;
		}
		m2_correct_count--;
		m2_correct();
		System.out.println("m2_correct_count : " + m2_correct_count);
	}

	/* ------------------------------- */

	// #2_correct. limit by count outside of r-call <-- 6/5
	static int m2_correct2_count = 5;

	static void m2_correct2() {
		if (m2_correct2_count == 0) {
			return;
		}
		System.out.println("m2_correct2_count : " + m2_correct2_count);
		m2_correct2_count--;
		m2_correct2();
		System.out.println("m2_correct2_count : " + m2_correct2_count);
	}

	/* ------------------------------- */

	// #3. limit by count by parameter
	static void m3(int m3_count) {
		if (m3_count == 0)
			return;
		System.out.println("m3_count : " + m3_count);

		m3_count--;
		m3(m3_count);

		System.out.println("m3_count : " + m3_count);

	}

	/* ------------------------------- */

	// #4. limit by condition with array
	static int[] m4_intArr = { 1, 2, 3, 4, 5 };

	static void m4(int m4_count) {
		if (m4_count < 0) {
			return;
		}
		System.out.println("m4_intArr[m4_count] = " + m4_intArr[m4_count]);

		m4_count--;
		m4(m4_count);

//		System.out.println("m4_intArr[m4_count] = " + m4_intArr[m4_count]);
	}

	/* ------------------------------- */

	// #4. limit by condition with array
	static int[] m4_reverse_intArr = { 1, 2, 3, 4, 5 };

	static void m4_reverse(int m4_count) {
		if (m4_count == m4_reverse_intArr.length) {
			return;
		}
		System.out.println("m4_reverse_intArr[m4_count] = " + m4_reverse_intArr[m4_count]);

		m4_count++;
		m4_reverse(m4_count);

//		System.out.println("m4_intArr[m4_count] = " + m4_intArr[m4_count]);
	}

	/* ------------------------------- */

	// #5. limit by condition with array from 0 & complete code
	static int[] m5_intArr = { 1, 2, 3, 4, 5 };

	static void m5(int m5_count) {
		if (m5_count == m5_intArr.length) {
			System.out.println("Complete Code Here!!");
			return;
		}
		System.out.println("m5_intArr[m5_count] = " + m5_intArr[m5_count]);

		m5_count++;
		m5(m5_count);

//		System.out.println("m4_intArr[m4_count] = " + m4_intArr[m4_count]);
	}

	/* ------------------------------- */

	// #6. limit by condition with array from 0 & do something code &
	static int[] m6_intArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	static int m6_even_count = 0;
	static int m6_even_sum = 0;

	static void m6(int m6_count) { // m6(0)에서 시작
		if (m6_count == m6_intArr.length) {
			System.out.println("m6_even_count = " + m6_even_count);
			System.out.println("m6_even_sum = " + m6_even_sum);
			return;
		}
		if (m6_intArr[m6_count] % 2 == 0) {
			m6_even_count++;
			m6_even_sum += m6_intArr[m6_count];
		}
		m6_count++;
		m6(m6_count);
	}

	/* ------------------------------- */
	static int result = 1;

	static void factorial(int n) {
		if (n == 1) {
			System.out.println("Complete Code Here!!");
			System.out.println("result = " + result);
			return;
		}
		result *= n;
		factorial(n - 1);
	}
	/* ------------------------------- */

}

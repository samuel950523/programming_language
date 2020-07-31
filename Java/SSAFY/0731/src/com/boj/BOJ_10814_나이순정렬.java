package com.boj;

import java.io.*;
import java.util.*;

public class BOJ_10814_나이순정렬 {
	static int n;
	static String[] strArr;
	static int[][] ageArr;
	static String s;
	// for 정렬
	static String tmpstr;
	static int[] tmpage;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력
		n = Integer.parseInt(br.readLine());
		strArr = new String[n];
		ageArr = new int[n][2];

		for (int i = 0; i < n; i++) {
			s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			ageArr[i][0] = Integer.parseInt(st.nextToken());
			ageArr[i][1] = i;
			strArr[i] = st.nextToken();
		}

		// 정렬
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				// 나이순
				if (ageArr[j][0] > ageArr[j + 1][0])
					sort(j);
				// 나이가 같다면 들어온 순서
				else if (ageArr[j][0] == ageArr[j + 1][0]) {
					if (ageArr[j][1] > ageArr[j + 1][1])
						sort(j);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			bw.write(ageArr[i][0] + " " + strArr[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	static void sort(int j) {
		tmpage = ageArr[j];
		ageArr[j] = ageArr[j + 1];
		ageArr[j + 1] = tmpage;

		tmpstr = strArr[j];
		strArr[j] = strArr[j + 1];
		strArr[j + 1] = tmpstr;
	}
}

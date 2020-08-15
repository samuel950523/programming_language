package com.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {
	static int t, n, m, a, b, ans;
	static StringTokenizer str;
	static int op;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {

			System.out.print("#" + tc + " ");
			str = new StringTokenizer(br.readLine());
			n = Integer.parseInt(str.nextToken());
			m = Integer.parseInt(str.nextToken());
			parents = new int[n];
			make();
			for (int i = 0; i < m; i++) {
				str = new StringTokenizer(br.readLine());
				op = Integer.parseInt(str.nextToken());
				a = Integer.parseInt(str.nextToken())-1;
				b = Integer.parseInt(str.nextToken())-1;
				if(op==0)
					union(a, b);
				else {
					if(parents[a]==parents[b])
						ans=1;
					else
						ans=0;
					System.out.print(ans);
				}
			}
			System.out.println(Arrays.toString(parents));
		}
		bw.flush();
		bw.close();
	}

	static void make() {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
//		return find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}
}

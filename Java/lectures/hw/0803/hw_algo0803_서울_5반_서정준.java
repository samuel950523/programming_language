/* 9229. 한빈이와 Spot Mart D3
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN
 */

package com.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class hw_algo0803_서울_5반_서정준 {
	static int tc;
	static int n, m;
	static int[] nArr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			// 입력
			StringTokenizer str = new StringTokenizer(br.readLine());
			n = Integer.parseInt(str.nextToken());
			m = Integer.parseInt(str.nextToken());
			
			nArr = new int[n];
			str = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				nArr[i] = Integer.parseInt(str.nextToken());
			}
			
			// 동작
			int sum=0;
			int curMax=0;
			for (int i = 0; i < n-1; i++) {
				for (int j = i+1; j < n; j++) {
					sum = nArr[i]+nArr[j];
					if(sum<=m && sum>curMax)
						curMax=sum;
				}
			}
			if(curMax==0)
				curMax=-1;
			bw.write("#"+t+" "+curMax+"\n");
		}
		
		bw.flush();
		bw.close();

	}
}

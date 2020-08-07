import java.util.Scanner;

public class BJ_2961_도영이가만든맛있는음식 {
	
	static int[][] tastes;
	static int[][] tgtArr;
	static int minDiff;
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		tastes = new int[N][2];
		
		minDiff = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			tastes[i][0] = sc.nextInt();
			tastes[i][1] = sc.nextInt();
		}
		
		for (int i = 1; i <= N; i++) {
			tgtArr = new int[i][2];
			comb(0, 0, i);
		}
		
		System.out.println(minDiff);
		sc.close();
	}
	
	static void comb(int srcIdx, int tgtIdx, int tgtCnt) {

		if( tgtIdx == tgtCnt ) {
			
			int temp1 = 1; // 계속 곱하기 초기값
			int temp2 = 0; // 계속 더하기 초기값
			
			for(int i=0; i<tgtArr.length; i++ ) {
				temp1 *= tgtArr[i][0];
				temp2 += tgtArr[i][1];
				
			}
			minDiff = Math.min(minDiff, Math.abs(temp1 - temp2));
			return;
		}
		
		if( srcIdx == N ) return;
		
		tgtArr[tgtIdx][0] = tastes[srcIdx][0];
		tgtArr[tgtIdx][1] = tastes[srcIdx][1];
		
		comb(srcIdx+1, tgtIdx+1, tgtCnt);
		comb(srcIdx+1, tgtIdx, tgtCnt);
	}
}

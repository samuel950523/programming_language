import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class hw_algo0805_서울_5반_서정준 {
	static int n;
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static int[][] map;
	static String s;
	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int r, c, nr, nc;
	static int cnt;
	static ArrayList<Integer> nArr;

	public static void main(String[] args) throws Exception {

		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			s = br.readLine();
			for (int j = 0; j < n; j++) {
				if (s.charAt(j) == '0') {
					map[i][j] = 0;
				} else
					map[i][j] = 1;
			}
		}

		// 동작
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					stack.push(i); // 순서
					stack.push(j); // 조심
				}
			}
		}

		cnt = 2; // 단지번호를 2번부터 붙인다.
		while (!stack.isEmpty()) {
			c = stack.pop(); // 순서
			r = stack.pop(); // 조심
			if (map[r][c] == 1) {
				dfs(r, c);
				cnt++;
			}
		}

		int ans = 0;
		nArr = new ArrayList<Integer>();

		bw.write(cnt - 2 + "\n");
		for (int k = cnt - 1; k >= 2; k--) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == k)
						ans++;
				}
			}
			nArr.add(ans);
			ans = 0;
		}
		Collections.sort(nArr);
		for (int i = 0; i < nArr.size(); i++) {
			bw.write(nArr.get(i) + "\n");
		}
		bw.flush();
		bw.close();
	}

	private static void dfs(int r, int c) {
		map[r][c] = cnt;
		for (int dir = 0; dir < 4; dir++) {
			nr = r + dx[dir];
			nc = c + dy[dir];
			if (nr != -1 && nc != -1 && nr != n && nc != n) {
				if (map[nr][nc] == 1) {
					dfs(nr, nc);
				}
			}
		}
	}

}
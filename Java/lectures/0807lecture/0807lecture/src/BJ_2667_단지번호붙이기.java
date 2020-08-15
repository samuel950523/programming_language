import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_2667_단지번호붙이기 {

	static int[][] map;
	static int N, cnt;
	static int[][] visited;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static ArrayList<Integer> al = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		map = new int[N][N];
		visited = new int[N][N];

		for (int i = 0; i < N; i++) {
			String input = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				if (map[i][j] == 1 && visited[i][j] == 0) {
					cnt = 1; // 새로운 단지의 시작
					dfs(i, j); // 연결된 모든 단지를 다 방문 후 방뭍 처리
					al.add(cnt); // 전역변후 cnt 뎐결된 방문마다 증가 후 최종 ArrayList 담는다.
				}
		}

		Collections.sort(al); // 정렬

		System.out.println(al.size());

		for (int i = 0; i < al.size(); i++)
			System.out.println(al.get(i));

		sc.close();
	}

	static int dfs(int x, int y) {
		visited[x][y] = 1;

		for (int i = 0; i < 4; i++) {

			int ny = y + dy[i];
			int nx = x + dx[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (map[nx][ny] == 1 && visited[nx][ny] == 0) {
					dfs(nx, ny);
					cnt++;
				}
			}
		}
		return cnt;
	}

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1863_종교 {
	static int n, m;
	static int i, j;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		parents = new int[n];
		make();
//		System.out.println(Arrays.toString(parents));

		for (int k = 0; k < m; k++) {
			str = new StringTokenizer(br.readLine());
			i = Integer.parseInt(str.nextToken())-1;
			j = Integer.parseInt(str.nextToken())-1;
			union(i, j);
		}

//		System.out.println(Arrays.toString(parents));
		int cnt=0;
		for (int i = 0; i < n; i++) {
			if(parents[i]==i)
				cnt++;
		}
		System.out.println(cnt);
		bw.flush();
		bw.close();
	}

	static int[] parents;

	static void make() {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a]=find(parents[a]);
	}

	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return;
		else {
			parents[bRoot] = aRoot;			
		}
	}
}

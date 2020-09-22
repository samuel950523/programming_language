
public class WS1 {
	public static void main(String[] args) {
		int[] y = new int[10];
		int[] b = new int[10];
		y[1] = 1;
		b[1] = 1;
		y[2] = 2;
		b[2] = 1;
		for (int i = 3; i < 10; i++) {
			y[i] = y[i - 1] + b[i - 1];
			b[i] = y[i - 1];
		}
		System.out.println(y[8] + b[8]);
	}
}

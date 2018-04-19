package algorithmstudy;

import java.util.Scanner;

public class TwoTiling {
		
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int d[] = new int[1001];
		d[0] = 1;
		d[1] = 1;
		
		if (1 <= n && n <= 1000) {
			for (int i = 2; i <= n; i++) {
				d[i] = d[i-1] + d[i-2];
			}
		}
		
		System.out.println(d[n]);
	}
}
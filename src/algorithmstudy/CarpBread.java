package algorithmstudy;

import java.util.Scanner;

public class CarpBread {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // ºØ¾î»§ÀÇ °³¼ö
		int d[] = new int[N+1];
		int p[] = new int[N+1];
		
		for (int i = 0; i < N; i++) {
			p[i] = scanner.nextInt();
		}
		
		maxBenefit(d, p, N);
	}
	
	public static void maxBenefit(int d[], int p[], int N) {
		d[0] = 0;
		for (int i = 1; i <= N; i++) {
			d[i] = 0;
			for (int j = 1; j <= i; j++) {
				d[i] = max(d[i], d[i-j] + p[j]);
			}
		}
		
		System.out.println(d[N]);
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}
}
package algorithmstudy;

import java.util.Scanner;

public class OneToMake {
	
	public static int d[];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		d = new int[N+1];
		// D[N] = N을 1로 만드는데 필요한 연산의 최소값
//		System.out.println(oneToMake(N));
		
		d[1] = 0;
		for (int i = 2; i <= N; i++) {
			d[i] = d[i-1] + 1;
			if (i % 2 == 0 && d[i] > d[i/2] + 1) {
				d[i] = d[i/2] + 1;
			}
			if (i % 3 == 0 && d[i] > d[i/3] + 1) {
				d[i] = d[i/3] + 1;
			}
		}
		
		System.out.println(d[N]);
	}
	
	// N을 N/3으로 바꾸는데 1번 N/3을 1로 만드는데 D[N/3]번이므로
	// D[N/3] + 1 이 된다
//	public static int oneToMake(int n) {
//		if (n == 1) {
//			return 0;
//		}
//		if (d[n] > 0) {
//			return d[n];
//		}
//		d[n] = oneToMake(n-1) +1;
//		if (n%2 == 0) {
//			int temp = oneToMake(n/2) + 1;
//			if (d[n] > temp) {
//				d[n] = temp;
//			}
//		}
//		if (n%3 == 0) {
//			int temp = oneToMake(n/3) + 1;
//			if (d[n] > temp) {
//				d[n] = temp;
//			}
//		}
//		return d[n];
//	}
}
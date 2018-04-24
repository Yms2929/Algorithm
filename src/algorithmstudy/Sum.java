package algorithmstudy;

import java.util.Arrays;
import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] number = new int[N];
		
		for (int i = 0; i < N; i++) {
			number[i] = scanner.nextInt();
		}
		
		Arrays.sort(number);
		
		System.out.println(number[0] + " " + number[number.length - 1]);
	}
	
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int n = scanner.nextInt();
//		int sum = 0;
//		
//		if (1 <= n && n <= 10000) {
//			for (int i = 1; i <= n; i++) {
//				sum = sum + i;
//			}
//		}
//		
//		System.out.println(sum);
//	}

}
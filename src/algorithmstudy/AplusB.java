package algorithmstudy;

import java.util.Scanner;

public class AplusB {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = 0;
		int A, B = 0;
		T = scanner.nextInt();
		int[] result = new int[T];
		
		for (int i = 0; i < T; i++) {
			A = scanner.nextInt();
			B = scanner.nextInt();
			
			if (0 < A && A < 10 && 0 < B && B < 10) {
				result[i] = A + B;
			}
		}
		
		for (int j = 0; j < T; j++) {
			System.out.println(result[j]);
		}	
	}

}
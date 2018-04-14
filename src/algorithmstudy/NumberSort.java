package algorithmstudy;

import java.util.Arrays;
import java.util.Scanner;

public class NumberSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] number = new int[N];
		
		for (int i = 0; i < N; i++) {
			number[i] = scanner.nextInt();
		}
		
		Arrays.sort(number);
		
		for (int i = 0; i < N; i++) {
			System.out.println(number[i]);
		}
	}

}
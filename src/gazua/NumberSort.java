package gazua;

import java.util.Arrays;
import java.util.Scanner;

public class NumberSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] numbers = new int[N];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		
		Arrays.sort(numbers);
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

}
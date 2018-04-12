package algorithmstudy;

import java.util.Scanner;

public class FourNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] input = new String[4];
		String AB = "";
		String CD = "";
		
		for (int i = 0; i < input.length; i++) {
			input[i] = scanner.next();
		}
		
		AB = input[0] + input[1];
		CD = input[2] + input[3];
		
		System.out.println(Long.parseLong(AB) + Long.parseLong(CD));
	}

}
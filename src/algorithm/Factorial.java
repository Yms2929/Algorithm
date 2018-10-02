package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 1;
		if (0 <= N && N <= 12) {
			for (int i = N; i >= 1; i--) {
				result *= i;
			}
			
			System.out.println(result);
		}
	}
}
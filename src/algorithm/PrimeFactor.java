package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeFactor {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int prime = 2;
		while (N > 1) {
			if (N % prime == 0) {
				System.out.println(prime);
				N /= prime;
			}
			else {
				prime++;
			}
		}
	}

}
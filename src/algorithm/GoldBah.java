package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldBah {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 1000000;
		boolean[] prime = new boolean[max + 1];
		
		for (int i = 2; i <= max; i++) {
			prime[i] = true;
		}
		
		for (int i = 2; i <= max; i++) {
			for (int j = 2; i*j <= max; j++) {
				if (!prime[j]) continue;
				prime[i*j] = false;
			}
		}
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			boolean wrong = false;
			
			for (int i = 2; i <= n/2; i++) {
				if (prime[i] && prime[n-i]) {
					System.out.println(n + " = " + i + " + " + (n-i));
					wrong = true;
					break;
				}
			}
			
			if (!wrong) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}	
	}

}
package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCDSUM {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int t = Integer.parseInt(br.readLine());
		long[] result = new long[t];
		
		if (1 <= t && t <= 100) {
			for (int i = 0; i < t; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int[] numbers = new int[n];
				long sum = 0;
								
				for (int j = 0; j < n; j++) {
					numbers[j] = Integer.parseInt(st.nextToken());
				}
				
				for (int j = 0; j < n; j++) {
					for (int k = j + 1; k < n; k++) {
						sum += getGCD(numbers[j], numbers[k]);
					}
				}
				
				result[i] = sum;
			}
			
			for (int i = 0; i < t; i++) {
				System.out.println(result[i]);
			}
		}
	}

	public static int getGCD(int a, int b) {
		if (b == 0) return a;
		return getGCD(b, a % b);
	}
}
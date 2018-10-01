package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimeNumber {

	// 소수 구하기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] numbers = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			numbers[i] = 0;
			numbers[1] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 2; i*j <= N; j++) {
				numbers[i*j] = 1;
			}
		}
		
		for (int i = M; i <= N; i++) {
			if (numbers[i] != 1) {
				System.out.println(i);
			}
		}
	
	}
	
	// 소수 찾기
	/*public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] numbers = new int[N];
		int result = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < numbers.length; i++) {
			int count = 0;
			
			for (int j = 1; j <= numbers[i]; j++) {
				if (numbers[i] % j == 0) {
					count++;
				}
			}
			
			if (count == 2) {
				result++;
			}
		}
		
		System.out.println(result);
	}*/

}
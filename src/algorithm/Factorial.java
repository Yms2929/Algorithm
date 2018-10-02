package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

	// 0의 개수를 구하려면 10의 개수를 구하면되는데 2와 5의 개수를 구해서 적은 숫자가 0의 개수이다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
	
		int countTwo =0;
		int countFive = 0;
		int result = 1;
		for (int i = 1; i <= N; i++) {
			result = i;
			
			while (result % 2 == 0 || result % 5 == 0) {
				if (result % 2 == 0) {
					result /= 2;
					countTwo++;
				}
				else if (result % 5 == 0) {
					result /= 5;
					countFive++;
				}
			}
		}
		
		if (countTwo < countFive) System.out.println(countTwo);
		else System.out.println(countFive);
	}
	
	// 팩토리얼 결과값을 구한뒤 0의 개수를 구함 시간초과
	/*public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
	
		long result = 1;
		if (0 <= N && N <= 500) {
			for (int i = N; i >= 1; i--) {
				result *= i;
			}
			System.out.println(result);
			int count = 0;
			while (true) {
				if (result % 10 == 0) {
					result /= 10;
					count++;
				}
				else {
					break;
				}
			}
			
			System.out.println(count);
		}
	}*/
	
	// 팩토리얼
	/*public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 1;
		if (0 <= N && N <= 12) {
			for (int i = N; i >= 1; i--) {
				result *= i;
			}
			
			System.out.println(result);
		}
	}*/
}
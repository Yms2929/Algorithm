package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

	// 0�� ������ ���Ϸ��� 10�� ������ ���ϸ�Ǵµ� 2�� 5�� ������ ���ؼ� ���� ���ڰ� 0�� �����̴�.
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
	
	// ���丮�� ������� ���ѵ� 0�� ������ ���� �ð��ʰ�
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
	
	// ���丮��
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
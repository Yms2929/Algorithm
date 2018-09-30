package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Remainder {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		for (int i = 0; i < gcd(A, B); i++) { // �ִ�������ŭ 1�� ����
			sb.append(1);			
		}
		System.out.println(sb.toString());
	}
	
	public static long gcd(long a, long b) { // �ִ�����
		if (b == 0) return a;
		return gcd(b, a % b);
	}

	// �ּҰ����
	/*
	 * public static void main(String[] args) throws NumberFormatException,
	 * IOException { BufferedReader br = new BufferedReader(new
	 * InputStreamReader(System.in)); int T = Integer.parseInt(br.readLine());
	 * 
	 * if (1 <= T && T <= 1000) { for (int i = 0; i < T; i++) { StringTokenizer st =
	 * new StringTokenizer(br.readLine()); int A = Integer.parseInt(st.nextToken());
	 * int B = Integer.parseInt(st.nextToken());
	 * 
	 * int aDivide = 0; int bDivide = 0; int maxDivide = 0; int min = 0;
	 * 
	 * if (A > B) { min = B; } else { min = A; }
	 * 
	 * for (int j = 1; j <= min; j++) { if (A % j == 0) { aDivide = j; } if (B % j
	 * == 0) { bDivide = j; } if (aDivide == bDivide) { maxDivide = aDivide; } }
	 * 
	 * aDivide = A / maxDivide; bDivide = B / maxDivide;
	 * System.out.println(maxDivide * aDivide * bDivide); } }
	 * 
	 * }
	 */

	// �ִ�����
	/*
	 * public static void main(String[] args) { String input = new
	 * Scanner(System.in).nextLine().trim(); final StringTokenizer tokenizer = new
	 * StringTokenizer(input);
	 * 
	 * int a = Integer.parseInt(tokenizer.nextToken()); int b =
	 * Integer.parseInt(tokenizer.nextToken()); int aDivide = 0; int bDivide = 0;
	 * int maxDivide = 0; int min = 0;
	 * 
	 * if (a > b) { min = b; } else { min = a; }
	 * 
	 * for (int i = 1; i <= min; i++) { if (a % i == 0) { aDivide = i; } if (b % i
	 * == 0) { bDivide = i; } if (aDivide == bDivide) { maxDivide = aDivide; } }
	 * System.out.println(maxDivide);
	 * 
	 * aDivide = a / maxDivide; bDivide = b / maxDivide;
	 * 
	 * System.out.println(maxDivide * aDivide * bDivide); }
	 */
}

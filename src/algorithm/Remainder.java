package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Remainder {

	// 최소공배수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		if (1 <= T && T <= 1000) {
			for (int i = 0; i < T; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				int aDivide = 0;
		        int bDivide = 0;
		  		int maxDivide = 0;
				int min = 0;
				
				if (A > B) {
					min = B;
				}
				else {
					min = A;
				}
				
				for (int j = 1; j <= min; j++) {
		        	if (A % j == 0) {
		        		aDivide = j;
		        	}
		        	if (B % j == 0) {
		        		bDivide = j;
		        	}
		        	if (aDivide == bDivide) {
		        		maxDivide = aDivide;
		        	}
		        }
				
				aDivide = A / maxDivide;
				bDivide = B / maxDivide;
				System.out.println(maxDivide * aDivide * bDivide);
			}
		}
        
	}
	
	// 최대공약수
	/*public static void main(String[] args) {
		String input = new Scanner(System.in).nextLine().trim();
        final StringTokenizer tokenizer = new StringTokenizer(input);
        
        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        int aDivide = 0;
        int bDivide = 0;
  		int maxDivide = 0;
		int min = 0;
		
		if (a > b) {
			min = b;
		}
		else {
			min = a;
		}
		
		for (int i = 1; i <= min; i++) {
        	if (a % i == 0) {
        		aDivide = i;
        	}
        	if (b % i == 0) {
        		bDivide = i;
        	}
        	if (aDivide == bDivide) {
        		maxDivide = aDivide;
        	}
        }
		System.out.println(maxDivide);
		
		aDivide = a / maxDivide;
		bDivide = b / maxDivide;
		
		System.out.println(maxDivide * aDivide * bDivide);
	}*/
}

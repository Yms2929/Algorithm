package algorithm;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Remainder {

	public static void main(String[] args) {
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
	}
}

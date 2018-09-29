package algorithm;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Icandoit {

	public static void main(String[] args) {
		String input = new Scanner(System.in).nextLine().trim();
        final StringTokenizer tokenizer = new StringTokenizer(input);
        int balance = 20000;
        int charge = 720;
        int result = 0;
        
        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());
            
            if (distance > 178) {
            	System.out.println(balance);
            	break;
            }
                        
            else if (0 < distance && distance <= 40) {
            	charge = 720;
            }
            
            else {
            	int temp = distance - 40;
            	charge = 720;
            	while (temp > 0) {
            		charge += 80;
            		
            		temp -= 8;
            	}
            }
            
            result = balance;
            balance = balance - charge;
            
            if (balance < 0) {
            	balance = result;
            	break;
            }
        }
        
        System.out.println(balance);
	}

}

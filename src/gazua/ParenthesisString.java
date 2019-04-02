package gazua;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class ParenthesisString {
	static Stack<Character> stack = new Stack<Character>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		String[] result = new String[T];
		
		for (int i = 0; i < T; i++) {
			stack.clear();
			String str = sc.next();
			
			result[i] = result(str);
		}
		
		for (int j = 0; j < T; j++) {
			System.out.println(result[j]);
		}
	}
	
	public static String result(String str) {
		char[] ch = str.toCharArray();
		
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '(') {
				stack.push(ch[i]);
			}
			else {
				if (stack.isEmpty()) {
					return "NO";
				}
				else {
					stack.pop();
				}
			}
		}
		
		if (stack.isEmpty()) {
			return "YES";
		}
		else {
			return "NO";
		}
	}

}
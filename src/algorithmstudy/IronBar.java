//package algorithmstudy;
//
//import java.util.Scanner;
//import java.util.Stack;
//
//public class IronBar {
//	static Stack<Object> stack = new Stack<Object>();
//	static int count = 0; // ���
//	
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String input = ""; // ��ȣ �Է�
//		
//		input = scanner.next();
//		countAll(input);
//		
//		System.out.println(count);
//	}
//
//	public static void countAll(String input) {
//		char[] ch = input.toCharArray(); // ��Ʈ���� ���ڹ迭�� ��ȯ
//		
//		for (int i = 0; i < ch.length; i++) {
//			if (ch[i] == '(') {
//				stack.push(i);
//			}
//			
//			else if (ch[i] == ')') {
//				if (ch[i-1] == '(') {
//					stack.pop();
//					count = count + stack.size();
//				}
//				else {
//					stack.pop();
//					count = count + 1;
//				}
//			}
//		}
//	}
//}
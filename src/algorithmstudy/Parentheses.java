//package algorithmstudy;
//
//import java.util.Scanner;
//import java.util.Stack;
//
//public class Parentheses {
//	static Stack<Object> stack = new Stack<Object>();
//	
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int count = scanner.nextInt(); // �Է� ����
//		String result[] = new String[count]; // ���
//		
//		for (int i = 0; i < count; i++) {
//			String input = ""; // ��ȣ �Է�
//			input = scanner.next();
//			
//			result[i] = isValid(input);
//			stack.clear();
//		}
//		
//		for (int j = 0; j < count; j++) {
//			System.out.println(result[j]);
//		}
//	}
//
//	public static String isValid(String input) {
//		char[] ch = input.toCharArray();
//		
//		for (char i : ch) {
//			if (i == '(') {
//				stack.push(i);
//			}
//			else {
//				if (stack.isEmpty() == true) {
//					return "NO";
//				}
//				else {
//					stack.pop();
//				}
//			}
//		}
//		if (stack.isEmpty()) {
//			return "YES";
//		}
//		else {
//			return "NO";
//		}
//	}
//}
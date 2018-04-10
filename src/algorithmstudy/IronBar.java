//package algorithmstudy;
//
//import java.util.Scanner;
//import java.util.Stack;
//
//public class IronBar {
//	static Stack<Object> stack = new Stack<Object>();
//	static int count = 0; // 결과
//	
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String input = ""; // 괄호 입력
//		
//		input = scanner.next();
//		countAll(input);
//		
//		System.out.println(count);
//	}
//
//	public static void countAll(String input) {
//		char[] ch = input.toCharArray(); // 스트링을 문자배열로 변환
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
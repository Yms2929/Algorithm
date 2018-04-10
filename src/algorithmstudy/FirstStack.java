//package algorithmstudy;
//
//import java.util.Scanner;
//import java.util.Stack;
//
//public class FirstStack {
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int countOrder = scanner.nextInt();
//		MyStack myStack = new MyStack();
//		
//		for (int i = 0; i < countOrder; i++) {
//			String order = scanner.next();
//			
//			if (order.equals("push")) {
//				int number = scanner.nextInt();
//				myStack.push(number);
//			}
//			else if (order.equals("pop")) {
//				System.out.println(myStack.pop());
//			}
//			else if (order.equals("size")) {
//				System.out.println(myStack.getSize());
//			}
//			else if (order.equals("empty")) {
//				System.out.println(myStack.isEmpty());
//			}
//			else if (order.equals("top")) {
//				System.out.println(myStack.getTop());
//			}
//		}
//	}
//
//}
//
//class MyStack {
//	private Stack<Integer> stack = new Stack<Integer>();
//	
//	public void push(int number) {
//		stack.add(number);
//	}
//	
//	public int pop() {
//		if (stack.isEmpty()) {
//			return -1;
//		}
//		else {
//			return stack.pop();
//		}
//	}
//	
//	public int getSize() {
//		return stack.size();
//	}
//	
//	public int isEmpty() {
//		if (stack.isEmpty()) {
//			return 1;
//		}
//		else {
//			return 0;
//		}
//	}
//	
//	public int getTop() {
//		if (stack.isEmpty()) {
//			return -1;
//		}
//		else {
//			return stack.peek();
//		}
//	}
//}
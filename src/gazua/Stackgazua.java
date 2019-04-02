package gazua;

import java.util.Scanner;
import java.util.Stack;

public class Stackgazua {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String order = "";
		Stack<Integer> stack = new Stack<Integer>();
		Integer temp = 0;
		int N = sc.nextInt(); // 명령의 수

		while (N >= 0) {
			order = sc.nextLine();
			
			if (order.length() > 5) {
				String[] orders = order.split(" ");
				temp = Integer.parseInt(orders[1]);
				order = "push";
			}

			switch (order) {
			case "push":
				stack.push(temp);
				break;
			case "pop":
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
				break;
			case "top":
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if (stack.isEmpty()) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
				break;
			default:
				break;
			}

			N--;
		}

	}

}

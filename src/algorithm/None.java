package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class None {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int C = scanner.nextInt(); // ī���� ����
		int P = scanner.nextInt(); // ī�� ���� Ƚ��
		int N = scanner.nextInt(); // ���� �Ʒ����� ������ ī���� ����
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> top = new ArrayList<Integer>();
		List<Integer> middle = new ArrayList<Integer>();
		int count = 0;
		
		if (10 <= C && C <= 1000) {
			if (0 <= P && P <= 1000) {
				if (1 <= N && N < Math.ceil(C/2)) {
					for (int i = 10; i >= 1; i--) {
						stack.push(i);
					}
					System.out.println(stack);
					System.out.println(stack.peek());
					System.out.println(stack.get(0));
					
					while (P > 0) {
						for (int i = 0; i < N; i++) {
							top.add(stack.pop());
						}
						
						
						
						
						P--;
					}
				}
			}
		}
		else {
			
		}
	}	
}
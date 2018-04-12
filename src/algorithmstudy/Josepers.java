package algorithmstudy;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Josepers {
	
	public static void main(String[] args) {
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		StringBuilder stringBuilder = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		stringBuilder.append("<");
		
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}
		
		while (!deque.isEmpty()) {
			for (int i = 0; i < M-1; i++) {
				deque.addLast(deque.removeFirst());
			}
			stringBuilder.append(deque.removeFirst() + ", ");
		}
		
		System.out.println(stringBuilder.toString().substring(0, stringBuilder.length() - 2) + ">");
	}	
	
}
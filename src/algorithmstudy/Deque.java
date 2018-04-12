package algorithmstudy;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Deque {
	
	public static void main(String[] args) {
		MyDeque myDeque = new MyDeque();
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int number = 0;
		
		for (int i = 0; i < N; i++) {
			String order = scanner.next();
			
			switch(order) {
			case "push_front":
				number = scanner.nextInt();
				myDeque.push_front(number);
				break;
			case "push_back":
				number = scanner.nextInt();
				myDeque.push_back(number);
				break;
			case "pop_front":
				myDeque.pop_front();
				break;
			case "pop_back":
				myDeque.pop_back();
				break;
			case "size":
				myDeque.size();
				break;
			case "empty":
				myDeque.empty();
				break;
			case "front":
				myDeque.front();
				break;
			case "back":
				myDeque.back();
				break;
				default:
					break;
			}
		}
	}	
}

class MyDeque {
	ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
	
	public MyDeque() {
		
	}
	
	public void push_front(int number) {
		deque.addFirst(number);
	}
	
	public void push_back(int number) {
		deque.addLast(number);
	}
	
	public void pop_front() {
		if (deque.isEmpty()) {
			System.out.println(-1);
		}
		else {
			System.out.println(deque.getFirst());
			deque.removeFirst();
		}
	}
	
	public void pop_back() {
		if (deque.isEmpty()) {
			System.out.println(-1);
		}
		else {
			System.out.println(deque.getLast());
			deque.removeLast();	
		}
	}
	
	public void size() {
		System.out.println(deque.size());
	}
	
	public void empty() {
		if (deque.isEmpty()) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
	
	public void front() {
		if (deque.isEmpty()) {
			System.out.println(-1);
		}
		else {
			System.out.println(deque.getFirst());
		}
	}
	
	public void back() {
		if (deque.isEmpty()) {
			System.out.println(-1);
		}
		else {
			System.out.println(deque.getLast());
		}
	}
}
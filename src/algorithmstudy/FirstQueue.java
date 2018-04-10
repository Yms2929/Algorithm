package algorithmstudy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FirstQueue {
	
	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		Scanner scanner = new Scanner(System.in);
		
		int N = 0;
		N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			String order = scanner.next();
			
			switch(order) {
			case "push":
				int number = scanner.nextInt();
				myQueue.push(number);
				break;
			case "pop":
				myQueue.pop();
				break;
			case "size":
				myQueue.size();
				break;
			case "empty":
				myQueue.empty();
				break;
			case "front":
				myQueue.front();
				break;
			case "back":
				myQueue.back();
				break;
				default:
					break;
			}
		}
	}
	
}

class MyQueue {
	private Queue<Integer> queue = new LinkedList<Integer>();
	
	public MyQueue() {
		
	}
	
	public void push(int number) {
		queue.add(number); // ť�� ����
	}
	
	public void pop() {
		if (queue.isEmpty()) { // ���������
			System.out.println(-1);
		}
		else { // ������ ���� �տ� �ִ� �� ���� ���
			System.out.println(queue.peek());
			queue.remove(queue.peek());
		}
	}
	
	public void size() { // ť�� ����ִ� ����
		System.out.println(queue.size());
	}
	
	public void empty() {
		if (queue.isEmpty()) { // ť�� ��� ������
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
	
	public void front() {
		if (queue.isEmpty()) {
			System.out.println(-1);
		}
		else {
			System.out.println(queue.peek());
		}
	}
	
	public void back() {
		if (queue.isEmpty()) {
			System.out.println(-1);
		}
		else {
			System.out.println((int)queue.toArray()[queue.size()-1]);
		}
	}
}
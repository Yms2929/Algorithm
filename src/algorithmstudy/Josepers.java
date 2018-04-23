package algorithmstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Josepers {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		List list = new ArrayList();
		StringBuilder stringBuilder = new StringBuilder();
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());
		stringBuilder.append("<");
		
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		int index = 0;
		
		while (!list.isEmpty()) {
			index = index + M - 1;
			
			if (index >= list.size()) {
				index = index % list.size();
			}
			
			stringBuilder.append(list.remove(index) + ", ");
		}

		System.out.println(stringBuilder.toString().substring(0, stringBuilder.length() - 2) + ">");
	}

}

//public class Josepers {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
//		StringBuilder stringBuilder = new StringBuilder();
//		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//		
//		int N = Integer.parseInt(stringTokenizer.nextToken());
//		int M = Integer.parseInt(stringTokenizer.nextToken());
//		stringBuilder.append("<");
//
//		for (int i = 1; i <= N; i++) {
//			deque.add(i);
//		}
//
//		while (!deque.isEmpty()) {
//			for (int i = 0; i < M - 1; i++) {
//				deque.addLast(deque.removeFirst());
//			}
//			stringBuilder.append(deque.removeFirst() + ", ");
//		}
//
//		System.out.println(stringBuilder.toString().substring(0, stringBuilder.length() - 2) + ">");
//	}
//
//}
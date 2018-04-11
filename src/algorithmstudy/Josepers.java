//package algorithmstudy;
//
//import java.awt.List;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Josepers {
//	static ArrayList<Integer> arrayList = new ArrayList<Integer>();
//	static StringBuilder stringBuilder = new StringBuilder();
//	
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int N = scanner.nextInt();
//		int M = scanner.nextInt();
//		stringBuilder.append("<");
//		
//		for (int i = 1; i <= N; i++) {
//			arrayList.add(i);
//		}
//		
//		remove(N, M);
//		
//		stringBuilder.toString().substring(0, stringBuilder.length() - 2);
//		System.out.println(stringBuilder.append(">"));
//	}	
//	
//	public static void remove(int N, int M) {
//		int count = 0;
//		
//		while (N > 0) {
//			for (int i = 0; i < M; i++) {
//				count++;
//				
//				if (count > N-1) {
//					count = 0;
//				}
//				
//				if (count == M) {
//					stringBuilder.append(arrayList.get(count - 1) + ", ");
//					arrayList.remove(count - 1);
//					
//					if (count == arrayList.size()) {
//						count = 0;
//					}
//				}				
//			}
//			N--;
//		}
//	}
//}
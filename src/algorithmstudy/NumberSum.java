//package algorithmstudy;
//
//import java.util.Scanner;
//
//public class NumberSum {
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int N = scanner.nextInt();
//		String numbers = "";
//		int number[] = new int[N];
//		int sum = 0;
//
//		if (1 <= N && N <= 100) {
//			numbers = scanner.next();
//
//			for (int i = 0; i < N; i++) {
//				number[i] = Integer.parseInt(numbers.substring(i, i + 1));
//			}
//		}
//
//		for (int i = 0; i < N; i++) {
//			sum += number[i];
//		}
//
//		System.out.println(sum);
//	}
//
//}
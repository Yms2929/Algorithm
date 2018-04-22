//package algorithmstudy;
//
//import java.util.Scanner;
//
//public class StarPrint {
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int N = scanner.nextInt();
//
//		if (1 <= N && N <= 100) {
//			for (int i = 0; i < N; i++) {
//				for (int j = i; j < N - 1; j++) {
//					System.out.print(' ');
//				}
//
//				for (int k = 0; k < i + 1; k++) {
//					System.out.print('*');
//				}
//
//				System.out.println();
//			}
//		}
//	}
//
//}
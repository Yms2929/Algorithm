//package algorithmstudy;
//
//import java.util.Scanner;
//
//public class Fibonacci {
//	static int[] dp = new int[100];
//	
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int number = scanner.nextInt();
//		int result = 0;
//		result = fibonacci(number);
//		System.out.println(result);
//	}
//	
//	// Top-down Àç±Í
//	public static int fibonacci(int n) {
//		if (n <= 1) {
//			return n;
//		}
//		else {
//			if (dp[n] > 0) {
//				return dp[n];
//			}
//			dp[n] = fibonacci(n-1) + fibonacci(n-2); 
//			return dp[n];
//		}
//	}
//	
//	// Bottom-up for¹®
////	public static int fibonacci(int n) {
////		dp[0] = 1;
////		dp[1] = 1;
////		
////		for (int i = 2; i <= n; i++) {
////			dp[i] = dp[i-2] + dp[i-2];
////		}
////		return dp[n];
////	}
//}
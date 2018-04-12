//package algorithmstudy;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class SuffixArray {
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String input = scanner.nextLine();
//		String[] result = new String[input.length()];
//		
//		result = result(input);
//		
//		for (int i = 0; i < result.length; i++) {
//			System.out.println(result[i]);
//		}
//	}
//	
//	public static String[] result(String input) {
//		String[] result = new String[input.length()];
//		
//		for (int i = 0; i < input.length(); i++) {
//			result[i] = input.substring(i, input.length());
//		}
//		
//		Arrays.sort(result);
//		
//		return result;
//	}
//
//}
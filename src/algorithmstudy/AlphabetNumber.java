//package algorithmstudy;
//
//import java.util.Scanner;
//
//public class AlphabetNumber {
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String word = scanner.nextLine();
//		char[] alphabet = new char[word.length()];
//		int[] result = new int[26];
//		
//		word = word.toLowerCase();
//		if (word.length() <= 100) {
//			for (int i = 0; i < word.length(); i++) {
//				alphabet[i] = word.charAt(i);
//			}
//			
//			int index = 0;
//			for (int j = 0; j < word.length(); j++) {
//				for (char c = 'a'; c <= 'z'; c++) {
//					if (alphabet[j] == c) {
//						result[index]++;
//					}
//					index++;
//				}
//				index = 0;
//			}
//		}
//		for (int k = 0; k < result.length; k++) {
//			System.out.print(result[k] + " ");
//		}
//	}
//
//}
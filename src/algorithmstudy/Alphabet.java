//package algorithmstudy;
//
//import java.util.Scanner;
//
//public class Alphabet {
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String S = scanner.nextLine();
//		char character[] = new char[S.length()];
//		int result[] = new int[26];
//		
//		for (int i=0; i < result.length; i++) {
//			result[i] = -1;
//		}
//		
//		for (int i=0; i < S.length(); i++) {
//			character[i] = S.charAt(i);
//			int index = 0;
//			
//			for (char c='a'; c <= 'z'; c++) {
//				if (character[i] == c) {
//					if (result[index] != -1) {
//						
//					}
//					else {
//						result[index] = i;
//					}
//					index = 0;
//				}
//				index++;
//			}
//		}
//		
//		String output = "";
//		for (int j=0; j < result.length; j++) {
//			if (j < result.length - 1) {
//				output = output + result[j] + " ";
//			}
//			else if (j == result.length - 1) {
//				output = output + result[j];
//			}
//		}
//		System.out.println(output);
//	}
//
//}
//package algorithmstudy;
//
//import java.util.Scanner;
//
//public class BabyGinGame {
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String input = scanner.nextLine();
//		char[] card = input.toCharArray();
//		int[] number = new int[input.length()];
//		int run = 0;
//		int triplete = 0;
//		
//		for (int i = 0; i < input.length(); i++) {
//			number[i] = (int) card[i] - 48;
//			
//			for (int j = 0; j < input.length(); j++) {
//				if (number[i] < number[j]) {
//					int temp = number[i];
//					number[i] = number[j];
//					number[j] = temp;
//				}
//			}
//		}
//		
//		for (int i = 0; i < input.length(); i++) {
//			System.out.println(number[i]);
//		}
//		
//		int count = 0;
//		int temp = number[0];
//		for (int i = 0; i < input.length(); i++) {
//			if (temp == number[i]) {
//				count++;
//				if (count == 3) {
//					triplete++;
//					count = 0;
//				}
//			}
//			else if (temp != number[i]) {
//				temp = number[i];
//				if (temp == number[i]) {
//					count++;
//					if (count == 3) {
//						triplete++;
//						count = 0;
//					}
//				}
//				
//			}
//		}
//			
//		if (triplete == 1 && run == 1) {
//			System.out.println("Baby-Gin");
//		}
//		else if (triplete == 2) {
//			System.out.println("Baby-Gin");
//		}
//		else {
//			System.out.println("NO Baby-Gin");
//		}
//	}
//
//}
//package algorithmstudy;
//
//import java.util.Scanner;
//
//public class StringRepeat {
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int T = scanner.nextInt();
//		String result[] = new String[T];
//		
//		for (int i = 0; i < T; i++) {
//			int R = 0;
//			String S = "";
//			R = scanner.nextInt();
//			
//			if (1 <= R && R <= 8) {
//				S = scanner.next();
//				
//				if (1 <= S.length() && S.length() <= 20) {
//					char character[] = new char[S.length()];
//					StringBuilder stringBuilder = new StringBuilder();
//			
//					for (int j = 0; j < S.length(); j++) {
//						character[j] = S.charAt(j);
//						for (int k = 0; k < R; k++) {
//							stringBuilder.append(character[j]);
//						}
//					}
//					
//					result[i] = String.valueOf(stringBuilder);
//				}
//			}
//		}
//		
//		for (int k = 0; k < T; k++) {
//			System.out.println(result[k]);
//		}
//	}
//
//}
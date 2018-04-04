//package algorithmstudy;
//
//import java.util.Scanner;
//
//public class WordStudy {
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String word = scanner.nextLine().toUpperCase(); // 대문자로 바꾸기
//		int count[] = new int[26]; // 알파벳 갯수
//		int max = 0; // 가장 많이 나온 알파벳 수
//		char result = '?'; // 결과 알파벳
//		
//		for (int i = 0; i < word.length(); i++) {
//			count[word.charAt(i)-65]++; // 현재 알파벳을 알파벳 배열에 +1
//			
//			if (max < count[word.charAt(i)-65]) { // 최대보다 크면 알파벳 저장
//				result = word.charAt(i);
//				max = count[word.charAt(i)-65];
//			}
//			else if (max == count[word.charAt(i)-65]) { // 최대랑 같으면
//				result = '?';
//			}
//		}
//		System.out.println(result);
//	}
//
//}
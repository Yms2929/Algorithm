//package algorithmstudy;
//
//import java.util.Scanner;
//
//public class WordStudy {
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String word = scanner.nextLine().toUpperCase(); // �빮�ڷ� �ٲٱ�
//		int count[] = new int[26]; // ���ĺ� ����
//		int max = 0; // ���� ���� ���� ���ĺ� ��
//		char result = '?'; // ��� ���ĺ�
//		
//		for (int i = 0; i < word.length(); i++) {
//			count[word.charAt(i)-65]++; // ���� ���ĺ��� ���ĺ� �迭�� +1
//			
//			if (max < count[word.charAt(i)-65]) { // �ִ뺸�� ũ�� ���ĺ� ����
//				result = word.charAt(i);
//				max = count[word.charAt(i)-65];
//			}
//			else if (max == count[word.charAt(i)-65]) { // �ִ�� ������
//				result = '?';
//			}
//		}
//		System.out.println(result);
//	}
//
//}
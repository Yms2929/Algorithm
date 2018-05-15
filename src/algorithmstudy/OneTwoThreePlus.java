//package algorithmstudy;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.Scanner;
//
//public class OneTwoThreePlus {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int result[] = new int[11];
//		int T = Integer.parseInt(br.readLine());
//		result[0] = 0;
//		result[1] = 1;
//		result[2] = 2;
//		result[3] = 4;
//		int number = 0;
//
//		if (0 < T && T < 11) {
//			for (int j = 4; j < result.length; j++) {
//				result[j] = result[j - 1] + result[j - 2] + result[j - 3];
//			}
//		}
//
//		for (int i = 0; i < T; i++) {
//			number = Integer.parseInt(br.readLine());
//			System.out.println(result[number]);
//		}
//
//	}
//
//}
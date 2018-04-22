package algorithmstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Card {

	public static void main(String[] args) throws IOException {
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		int max = 0;
		long maxNumber = 0;
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			long temp = scanner.nextLong();
			if (map.get(temp) == null) {
				count = 1;
			}
			else {
				count = map.get(temp) +1;
			}
			map.put(temp, count);
			if (count > max || (count == max && temp < maxNumber)) {
				max = count;
				maxNumber = temp;
			}
		}
		
		System.out.println(maxNumber);
		
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(bufferedReader.readLine());
//		long[] numbers = new long[N];
//
//		for (int i = 0; i < N; i++) {
//			numbers[i] = Integer.parseInt(bufferedReader.readLine());
//		}
//
//		bufferedReader.close();
//
//		Arrays.sort(numbers);
//
//		long temp = numbers[0];
//		int count = 0;
//		int max = 0;
//		long tempMax = 0;
//
//		for (int i = 0; i < N; i++) {
//			if (temp != numbers[i]) {
//				if (count > max) {
//					max = count;
//					tempMax = temp;
//				}
//
//				count = 1;
//				temp = numbers[i];
//			} else {
//				count++;
//			}
//		}
//
//		if (count > max) {
//			max = count;
//			tempMax = temp;
//		}
//
//		System.out.println(tempMax);
	}

}
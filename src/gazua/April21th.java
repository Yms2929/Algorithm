package gazua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class April21th {

	public static void main(String[] args) {
	
		//System.out.println(getSum(123));
	
		//System.out.println(sortDEC(118372));
	
		//getArray(12345);
	
		//System.out.println(getPOW(3));
		
		//removeNumber(new int[] {4,3,2,1});
		
		//System.out.println(getNumber(0));
	}
	
	// 짝수와 홀수
	public static String getNumber(int num) {

		return (num % 2 == 0) ? "Even" : "Odd";
	}
	
	// 제일 작은 수 제거하기
	public static int[] removeNumber(int[] arr) {
		int[] answer = {};
		
		if (arr.length == 1) {
			answer = new int[1];
			answer[0] = -1;
			return answer;
		}
		else {
			answer = new int[arr.length - 1];
			int[] temp = new int[arr.length];
			
			for (int i = 0; i < arr.length; i++) {
				temp[i] = arr[i];
			}
			
			Arrays.sort(temp);
			
			int min = temp[0];
			int index = 0;
			
			for (int i = 0; i < arr.length; i++) {
				if (min == arr[i]) {
					continue;
				}
				answer[index] = arr[i];
				index++;
			}
		}
		
		for (int j = 0; j < answer.length; j++) {
			System.out.print(answer[j]);
		}
		
		return answer;
	}
	
	// 정수 제곱근 판별
	public static long getPOW(long n) {
		long answer = 0;
		
		answer = (long) Math.sqrt(n);
		
		if (Math.pow(answer, 2) == n) {
			return answer = (long) Math.pow(answer+1, 2);
		}
		else {
			answer = -1;
		}
				
		return answer;
	}
	
	// 자연수 뒤집어 배열로 만들기
	public static int[] getArray(long n) {
		int[] answer = {};
		
		String s = Long.toString(n);
		answer = new int[s.length()];
		
		int index = 0;
		while (n > 0) {
			answer[index] = (int) (n % 10);
			n /= 10;
			index++;
		}
				
		return answer;
	}

	// 정수 내림차순으로 배치하기
	public static long sortDEC(long n) {
		long answer = 0;
		
		List<Long> list = new ArrayList<>();
		while (n > 0) {
			list.add(n % 10);
			n /= 10;
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			answer += list.get(i) * Math.pow(10, i);
		}
		
		return answer;
	}
	
	// 자릿수 더하기
	public static int getSum(int n) {
		int answer = 0;
		
		while (n > 0) {
			answer += n % 10;
			n /= 10;
		}
		
		return answer;
	}
}
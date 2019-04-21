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
	
	// ¦���� Ȧ��
	public static String getNumber(int num) {

		return (num % 2 == 0) ? "Even" : "Odd";
	}
	
	// ���� ���� �� �����ϱ�
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
	
	// ���� ������ �Ǻ�
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
	
	// �ڿ��� ������ �迭�� �����
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

	// ���� ������������ ��ġ�ϱ�
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
	
	// �ڸ��� ���ϱ�
	public static int getSum(int n) {
		int answer = 0;
		
		while (n > 0) {
			answer += n % 10;
			n /= 10;
		}
		
		return answer;
	}
}
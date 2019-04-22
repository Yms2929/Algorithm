package gazua;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class April21th {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//System.out.println(getSum(123));
	
		//System.out.println(sortDEC(118372));
	
		//getArray(12345);
	
		//System.out.println(getPOW(3));
		
		//removeNumber(new int[] {4,3,2,1});
		
		//System.out.println(getNumber(0));
	
		//getMaxMin(2, 5);
		
		//System.out.println(getAvg(new int[] {5,5}));
		
		//System.out.println(hideNumber("027778888"));
	
		//arraySum(new int[][] {{1}, {2}}, new int[][] {{3}, {4}});
	
		//System.out.println(hashade(12));
	
		//intervalNumber(-4, 2);
		
		//System.out.println(colazh(626331));
	
		//printStar(sc.nextInt(), sc.nextInt());
	
		
	}
	
	// 
	
	// 직사각형 별찍기
	public static void printStar(int a, int b) {
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < a; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
	
	// 콜라츠 추측
	public static int colazh(int num) {
		int answer = 0;
		
		while (num != 1) {
			if (answer == 500) {
				return -1;
			}
			if (num % 2 == 0) {
				num /= 2;	
			}
			else if (num % 2 == 1) {
				num = num * 3 + 1;
			}
			answer++;
		}
		
		return answer;
	}
	
	// x만큼 간격이 있는 n개의 숫자
	public static long[] intervalNumber(int x, int n) {
		long[] answer = {};
		
		answer = new long[n];
		long result = 0;
		
		for (int i = 0; i < n; i++) {
			result += x;
			answer[i] = result;
			System.out.print(answer[i] + " ");
		}
		
		return answer;
	}
	
	// 하샤드 수
	public static boolean hashade(int x) {
		boolean answer = true;
		
		String s = String.valueOf(x);
		int[] arr = new int[s.length()];
		int index = 0;
		int temp = x;
		
		while (temp > 0) {
			arr[index] = temp % 10; 
			temp /= 10;
			index++;
		}
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		if (x % sum == 0) {
			answer = true;
		}
		else {
			answer = false;
		}
		
		return answer;
	}
	
	// 행렬의 덧셈
	public static int[][] arraySum(int[][] arr1, int[][] arr2) {
		int[][] answer = {};
		answer = new int[arr1.length][arr1[0].length];
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
		
		return answer;
	}
	
	// 핸드폰 번호 가리기
	public static String hideNumber(String phone_number) {
		String answer = "";
		
		char[] ch = phone_number.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (i < ch.length - 4) {
				ch[i] = '*';
			}
			answer += ch[i];
		}
		
		return answer;
	}
	
	// 평균 구하기
	public static double getAvg(int[] arr) {
		double answer = 0;
		
		for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		
		answer /= arr.length;
		
		return answer;
	}
	
	// 최대공약수와 최소공배수
	public static int[] getMaxMin(int n , int m) {
		int[] answer = {};
		
		int gcd = BigInteger.valueOf(m).gcd(BigInteger.valueOf(n)).intValue();
		int lcm = n * m / gcd;
		
		answer = new int[] {
			gcd, lcm
		};
		
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		
		return answer;
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
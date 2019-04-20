package gazua;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class April16th {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * int N = sc.nextInt(); // 10진법 수 int B = sc.nextInt(); // B진법
		 * 
		 * StringBuilder sb = new StringBuilder();
		 * 
		 * // 진법 변환 while (N != 0) {
		 * 
		 * if ((N % B) < 10) { sb.insert(0, N % B); N /= B; } else { int temp =
		 * (char)((N % B) + 55); sb.append((char)temp); N /= B; } }
		 * 
		 * System.out.println(sb.toString());
		 */

		/*
		 * String answer = ""; String s = sc.next(); char[] ch = s.toCharArray();
		 * 
		 * int middle = s.length() / 2;
		 * 
		 * // 단어의 길이 짝수 if (s.length() % 2 == 0) { answer = String.valueOf(ch[middle -
		 * 1]) + String.valueOf(ch[middle]); } // 홀수 else if (s.length() % 2 == 1) {
		 * answer = String.valueOf(ch[middle]); } System.out.println(answer);
		 */

		/*
		 * int a = sc.nextInt(); // 월 int b = sc.nextInt(); // 일
		 * 
		 * String answer = ""; // 요일 String[] day = new String[] { "THU", "FRI", "SAT",
		 * "SUN", "MON", "TUE", "WED", };
		 * 
		 * int month = 1; if (a == 1) { b %= 7; } else { do { switch(month) { case 2: b
		 * += 29; break; case 1: case 3: case 5: case 7: case 8: case 10: case 12: b +=
		 * 31; break; case 4: case 6: case 9: case 11: b += 30; break; } month++; }
		 * while (month < a); b = b % 7; } System.out.println(day[b]);
		 */

		// String[] participant = {"mislav", "stanko", "mislav", "ana"};
		// String[] completion = {"stanko", "ana", "mislav"};
		/*
		 * String[] participant = {"leo", "kiki", "eden"}; String[] completion =
		 * {"eden", "kiki"}; System.out.println(solution(participant, completion));
		 */

		// System.out.println(getSum(5));

		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		int[] result = solution(array, commands);
		for (int i = 0; i < commands.length; i++) {
			System.out.println(result[i]);
		}
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = {};
		List<Integer> list = new ArrayList<>();
		for (int num : array) {
			list.add(num);
		}

		List<Integer> subList = new ArrayList<>();
		int index = 0;
		answer = new int[commands.length];
		for (int[] order : commands) {
			for (int i = order[0] - 1; i <= order[1] - 1; i++) {
				subList.add(list.get(i));
			}
			Collections.sort(subList);
			answer[index] = subList.get(order[2] - 1);
			subList.clear();
			index++;
		}

		return answer;
	}

	/*
	 * public static int getSum(int n) { int answer = 0;
	 * 
	 * for (int i = 1; i <= n; i++) { if (n % i == 0) { answer += i; } }
	 * 
	 * return answer; }
	 */

	/*
	 * public static String solution(String[] participant, String[] completion) {
	 * String answer = "";
	 * 
	 * Arrays.sort(participant); Arrays.sort(completion);
	 * 
	 * for (int i = 0; i < completion.length; i++) { if
	 * (!participant[i].equals(completion[i])) { return participant[i]; } }
	 * 
	 * return participant[participant.length - 1]; }
	 */
}
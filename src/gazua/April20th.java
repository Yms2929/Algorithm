package gazua;

import java.util.Arrays;
import java.util.Comparator;

public class April20th {

	public static void main(String[] args) {
		/*String[] strings = {"sun","bed","car"};
		strings = mySort(strings, 1);
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}*/
		
		String answer = "try hello world";
		System.out.println(makeWord(answer));
	}
	
	// 이상한 문자 만들기
	public static String makeWord(String s) {
		String answer = "";

		String[] str = s.split("\\s");
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < str.length; i++) {

			for (int j = 0; j < str[i].length(); j++) {
				//String temp = str[i].substring(j, j + 1);
				//String temp = String.valueOf(str[i].charAt(j));
				if (j % 2 == 0) {
					//temp = temp.toUpperCase();
					sb.append(String.valueOf(str[i].charAt(j)).toUpperCase());
				}
				else {
					//temp = temp.toLowerCase();
					sb.append(String.valueOf(str[i].charAt(j)).toLowerCase());
				}
				//answer += temp;
			}
			
			if (i < str.length - 1) {
				//answer += " ";
				sb.append(" ");
			}
		}
		
		return answer;
	}

	// 문자열 내마음대로 정렬하기
	public static String[] mySort(String[] strings, int n) {
		String[] answer = {};
		
		Arrays.sort(strings, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.charAt(n) > o2.charAt(n)) {
					return 1;
				}
				else if (o1.charAt(n) == o2.charAt(n)) {
					return o1.compareTo(o2);
				}
				else {
					return -1;
				}
			}
		});
		
		return strings;
	}
}
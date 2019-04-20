package gazua;

import java.util.Arrays;
import java.util.Comparator;

public class April20th {

	public static void main(String[] args) {
		String[] strings = {"sun","bed","car"};
		strings = mySort(strings, 1);
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		
		
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
package algorithmstudy;

import java.util.Scanner;

public class TwoThousandSevenYear {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		char date[] = new char[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String today = "";
		int count = 0;

		for (int i = 0; i < x - 1; i++) {
			count += date[i];
		}
		count += y;

		if (1 <= x && x <= 12) {
			if (1 <= y && y <= 31) {
				if (count % 7 == 0)
					today = "SUN";
				else if (count % 7 == 1)
					today = "MON";
				else if (count % 7 == 2)
					today = "TUE";
				else if (count % 7 == 3)
					today = "WED";
				else if (count % 7 == 4)
					today = "THU";
				else if (count % 7 == 5)
					today = "FRI";
				else if (count % 7 == 6)
					today = "SAT";
			}
		}

		System.out.println(today);
	}

}
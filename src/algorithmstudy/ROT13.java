package algorithmstudy;

import java.util.Scanner;

public class ROT13 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		StringBuilder stringBuilder = new StringBuilder();

		for (int j = 0; j < input.length(); j++) {
			char[] character = input.toCharArray();

			if ('a' <= character[j] && character[j] <= 'z') {
				int index = 0;

				for (char c = 'a'; c <= 'z'; c++) {
					if (character[j] == c) {
						if (character[j] < 'n') {
							character[j] = (char) (c + 13);
						} else if (character[j] >= 'n') {
							character[j] = 'a';
							character[j] = (char) (character[j] + index - 13);
						}
						stringBuilder.append(character[j]);
						index = 0;
						break;
					}
					index++;
				}
			}

			else if ('A' <= character[j] && character[j] <= 'Z') {
				int index = 0;

				for (char c = 'A'; c <= 'Z'; c++) {
					if (character[j] == c) {
						if (character[j] < 'N') {
							character[j] = (char) (c + 13);
						} else if (character[j] >= 'N') {
							character[j] = 'A';
							character[j] = (char) (character[j] + index - 13);
						}
						stringBuilder.append(character[j]);
						index = 0;
						break;
					}
					index++;
				}
			}

			else if ('0' <= character[j] && character[j] <= '9') {
				stringBuilder.append(character[j]);
			}

			else if (character[j] == ' ') {
				stringBuilder.append(character[j]);
			}
		}

		System.out.println(stringBuilder);
	}

}
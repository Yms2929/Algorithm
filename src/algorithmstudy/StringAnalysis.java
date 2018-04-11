package algorithmstudy;

import java.util.Scanner;

public class StringAnalysis {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lowcase = 0;
		int uppercase = 0;
		int number = 0;
		int empty = 0;
		
		while (scanner.hasNextLine()) {
			String input = scanner.nextLine();
		
			for (int j = 0; j < input.length(); j++) {
				char[] character = input.toCharArray();
			
				if ('a' <= character[j] && character[j] <= 'z') {
					lowcase++;
				}
				
				else if ('A' <= character[j] && character[j] <= 'Z') {
					uppercase++;
				}
			
				else if ('0' <= character[j] && character[j] <= '9') {
					number++;
				}
				
				else if (character[j] == ' ') {
					empty++;
				}
			}
			
			System.out.println(lowcase + " " + uppercase + " " + number + " " + empty);
			lowcase = 0;
			uppercase = 0;
			number = 0;
			empty = 0;
		}
	}

}
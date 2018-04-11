package algorithmstudy;

import java.util.Scanner;

public class WordLength {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String alphabet = scanner.nextLine();
		
		if (alphabet.length() <= 100) {
			System.out.println(alphabet.length());
		}
	}

}
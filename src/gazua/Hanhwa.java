package gazua;

import java.util.Scanner;

public class Hanhwa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hello HanHwa");
		System.out.println(3 + 7);
		
		System.out.print("10진수 입력: ");
		int number = sc.nextInt();
		String binary = Integer.toBinaryString(number);
		System.out.println(binary);
		
		int count = 0;
		char[] ch = binary.toCharArray();
		for (int i = 0; i < binary.length(); i++) {
			if (ch[i] == '1') {
				count++;
			}
		}
		System.out.println("count = " + count);
		
		
	}

}
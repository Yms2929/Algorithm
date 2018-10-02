package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZeroCount {
	
	// 조합 0의 개수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int resultTwo = 0;
		int resultFive = 0;
		
		resultTwo = getTwo(n) - getTwo(n-m) - getTwo(m);
		resultFive = getFive(n) - getFive(n-m) - getFive(m);
		
		if (resultTwo < resultFive) {
			System.out.println(resultTwo);
		}
		else {
			System.out.println(resultFive);
		}
	}

	public static int getTwo(int n) {
		int temp = 0;
		
		while (n > 0) {
			temp += n / 2;
			n /= 2;
		}
		
		return temp;
	}
	
	public static int getFive(int n) {
		int temp = 0;
		
		while (n > 0) {
			temp += n / 5;
			n /= 5;
		}
		
		return temp;
	}

}
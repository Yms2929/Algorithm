package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SystemChange {

	// 2진수 8진수로 변환
	/*public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String N = st.nextToken();
		
		if (N.length() % 3 == 1) {
			N = "00" + N;
		}
		else if (N.length() % 3 == 2) {
			N = "0" + N;
		}
		
		for (int i = 0; i < N.length(); i+=3) {
			int sum = 0;
			
			sum += (int) (N.charAt(i) - 48) * 4;
			sum += (int) (N.charAt(i + 1) - 48) * 2;
			sum += (int) (N.charAt(i + 2) - 48) * 1;
			
			sb.append(sum);
		}
		
		System.out.println(sb);
	}*/
	
	// 다른 진수를 10진수로 변환
	/*public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
	
		long result = 0;
		char[] ch = N.toCharArray();
		int temp = 0;
		
		for (int i = 0; i < ch.length; i++) {
			if ('A' <= ch[i] && ch[i] <= 'Z') {
				temp = ch[i] - 55;
			}
			else {
				temp = ch[i] - '0';
			}
			
			result = (long) (result + temp * Math.pow(B, ch.length - i - 1));
		}
		
		System.out.println(result);
	}*/
	
	// 10진수를 다른진수로 변환
	/*public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		String result = "";
		
		while(N > 0) {
			if (N % B < 10) {
				result = (N % B) + result; // 오른쪽부터 저장
				N = N / B;
			}
			else {
				int temp = (N % B) + 55;
				result = (char) temp + result;
				N = N / B;
			}
		}
		
		System.out.println(result);
	}*/

}
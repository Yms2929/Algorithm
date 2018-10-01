package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SystemChange {

	// 8진수 2진수 변환
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String N = st.nextToken();
		char[] ch = N.toCharArray();
		
		if (ch[0] == '0') sb.append("0");
		else if (ch[0] == '1') sb.append("1");
		else if (ch[0] == '2') sb.append("10");
		else if (ch[0] == '3') sb.append("11");
		else if (ch[0] == '4') sb.append("100");
		else if (ch[0] == '5') sb.append("101");
		else if (ch[0] == '6') sb.append("110");
		else if (ch[0] == '7') sb.append("111");
		
		for (int i = 1; i < ch.length; i++) {
			if (ch[i] == '0') sb.append("000");
			else if (ch[i] == '1') sb.append("001");
			else if (ch[i] == '2') sb.append("010");
			else if (ch[i] == '3') sb.append("011");
			else if (ch[i] == '4') sb.append("100");
			else if (ch[i] == '5') sb.append("101");
			else if (ch[i] == '6') sb.append("110");
			else if (ch[i] == '7') sb.append("111");
		}	
		
		System.out.println(sb.toString());
	}
	
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
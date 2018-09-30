package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SystemChange {

	public static void main(String[] args) throws IOException {
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
	}

}
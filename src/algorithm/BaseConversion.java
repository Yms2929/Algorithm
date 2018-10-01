package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaseConversion {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] a = new int[Integer.parseInt(br.readLine())];
		st = new StringTokenizer(br.readLine());
		
		for (int i = a.length - 1; i >= 0; i--) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			temp += (int) Math.pow(A, i) * a[i];
		}
		
		if (temp == 0) {
			System.out.println(0);
			return;
		}
		
		while (temp > 0) {
			sb.insert(0, String.valueOf(temp % B) + " ");
			temp /= B;
		}
		
		System.out.println(sb.toString());
	}

}
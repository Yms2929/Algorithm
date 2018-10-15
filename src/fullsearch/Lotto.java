package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lotto {
	static int k;
	static int[] S;
	static int count;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken()); // k개의 수
			
			if (k == 0) { // 0이면 종료
				break;
			}
			
			S = new int[k]; // 숫자 집합

			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < k; i++) {
				count++;
				DFS(i, S[i] + " ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static void DFS(int start, String str) {
		if (count == 6) { // 한번 순회하면 출력하고 종료
			sb.append(str + "\n");
		}
		else {
			for (int i = start + 1; i < k; i++) {
				count++;
				DFS(i, str + S[i] + " ");
			}
		}
		count--;
	}
}
package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CreatePassword {
	static int L, C;
	static String[] alpha;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken()); // 서로 다른 L개 알파벳 소문자
		C = Integer.parseInt(st.nextToken()); // 문자 종류
		
		alpha = new String[C];
		visited = new int[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken();
		}
		
		Arrays.sort(alpha); // 알파벳 정렬
		
		DFS(0, 0, 0, 0);
	}
	
	public static void DFS(int start, int count, int ja, int mo) {
		for (int i = start; i < C; i++) { // acistw
			visited[i] = 1;
			
			DFS(i + 1, count + 1, ja + (!check(alpha[i]) ? 1 : 0), mo + (check(alpha[i]) ? 1 : 0));
			
			visited[i] = 0;
		}
		
		if (count == L && ja >= 2 && mo >= 1) { // 4자리 자음 2개이상 모음 1개이상
			for (int i = 0; i < C; i++) {
				if (visited[i] == 1) {
					System.out.print(alpha[i]);
				}
			}
			System.out.println();
		}
	}
	
	public static boolean check(String alpha) { // 자음 모음 체크
		char temp = alpha.charAt(0);
		
		if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
			return true;
		}
		else {
			return false;
		}
	}

}
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
		
		L = Integer.parseInt(st.nextToken()); // ���� �ٸ� L�� ���ĺ� �ҹ���
		C = Integer.parseInt(st.nextToken()); // ���� ����
		
		alpha = new String[C];
		visited = new int[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken();
		}
		
		Arrays.sort(alpha); // ���ĺ� ����
		
		DFS(0, 0, 0, 0);
	}
	
	public static void DFS(int start, int count, int ja, int mo) {
		for (int i = start; i < C; i++) { // acistw
			visited[i] = 1;
			
			DFS(i + 1, count + 1, ja + (!check(alpha[i]) ? 1 : 0), mo + (check(alpha[i]) ? 1 : 0));
			
			visited[i] = 0;
		}
		
		if (count == L && ja >= 2 && mo >= 1) { // 4�ڸ� ���� 2���̻� ���� 1���̻�
			for (int i = 0; i < C; i++) {
				if (visited[i] == 1) {
					System.out.print(alpha[i]);
				}
			}
			System.out.println();
		}
	}
	
	public static boolean check(String alpha) { // ���� ���� üũ
		char temp = alpha.charAt(0);
		
		if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
			return true;
		}
		else {
			return false;
		}
	}

}
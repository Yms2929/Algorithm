package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TermProject {
	static int[] number;
	static int[] check;
	static int[] started;
	
	public static int DFS(int v, int cnt, int start) {		
		if (check[v] != 0) { // 이미 방문했던 정점이고
			if (start != started[v]) { // 시작정점이 start와 다르면 사이클 외의 정점이므로 0리턴
				return 0;
			}
			return cnt - check[v]; // 몇번째로 방문한 정점인지 리턴
		}
		
		check[v] = cnt;
		started[v] = start;
		return DFS(number[v], cnt+1, start);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine()); // 학생의 수
			number = new int[n+1]; // 선택된 학생의 번호
			check = new int[n+1]; // 방문 체크 (시작에서 몇번째로 방문되는지)
			started = new int[n+1]; // 시작정점
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= n; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			
			int count = 0;
			for (int i = 1; i <= n; i++) {
				if(check[i] == 0) {
					count += DFS(i, 1, i);
				}
			}
			
			System.out.println(n - count);
		}
	}

}
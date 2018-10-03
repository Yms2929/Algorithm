package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PermutationCycle {
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine()); // 순열의 크기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] numbers = new int[N];
			
			for (int i = 0; i < N; i++) {	
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			graph = new int[N+1][N+1];
			visited = new boolean[N+1];
			int temp = 0;
			
			for (int i = 1; i <= N; i++) {
				temp = numbers[i-1];
				graph[i][temp] = graph[temp][i] = 1;
			}
			
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					DFS(i, N);
					count++;
				}
			}
			
			System.out.println(count);
		}
		
	}
	
	public static void DFS(int v, int N) {
		visited[v] = true;

		for (int i = 1; i <= N; i++) {
			if (graph[v][i] == 1 && !visited[i]) {
				DFS(i, N);
			}
		}
	}

}
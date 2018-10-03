package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConnectedComponent {
	static int N, M;
	static int u, v;
	static int[][] graph;
	static boolean visited[];
	
	// ���� ���� �׷��� ���� ��� ����
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // ���� ����
		M = Integer.parseInt(st.nextToken()); // ���� ����

		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			graph[u][v] = graph[v][u] = 1;
		}
		
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				DFS(i);
				count++;
			}
		}
		
		System.out.println(count);
	}

	public static void DFS(int v) {
		visited[v] = true;
		//System.out.print(v + " ");

		for (int i = 1; i <= N; i++) {
			if (graph[v][i] == 1 && !visited[i]) {
				DFS(i);
			}
		}
	}
}
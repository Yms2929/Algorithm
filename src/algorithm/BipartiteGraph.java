package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BipartiteGraph {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M;
		int u, v = 0;
		int K = Integer.parseInt(st.nextToken());
		
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 정점 개수
			M = Integer.parseInt(st.nextToken()); // 간선 개수
			
			ArrayList<Integer>[] a = new ArrayList[N+1];
			for (int i = 1; i <= N; i++) {
				a[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				
				a[u].add(v);
				a[v].add(u);
			}
			
			int[] color = new int[N+1];
			for (int i = 1; i <= N; i++) {
				if (color[i] == 0) {
					DFS(i, 1, color, a);
				}
			}
			
			boolean check = true;
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < a[i].size(); j++) {
					int temp = a[i].get(j);
					if (color[i] == color[temp]) {
						check = false;
					}
				}
			}
			
			System.out.println(check ? "YES" : "NO");
		}

	}

	public static void DFS(int v, int c, int[] color, ArrayList<Integer>[] a) {
		color[v] = c;

		for (int y : a[v]) {
			if (color[y] == 0) {
				DFS(y, 3-c, color, a);
			}
		}
	}

}
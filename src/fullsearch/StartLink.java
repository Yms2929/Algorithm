package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class StartLink {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int F = Integer.parseInt(st.nextToken()); // 건물 높이
		int S = Integer.parseInt(st.nextToken()); // 현재 위치
		int G = Integer.parseInt(st.nextToken()); // 이동할 위치
		int U = Integer.parseInt(st.nextToken()); // 위로 이동
		int D = Integer.parseInt(st.nextToken()); // 아래로 이동

		BFS(F, S, G, U, D);
	}

	public static void BFS(int f, int s, int g, int u, int d) {
		int[] visited = new int[f + 1];
		Queue<Integer> queue = new LinkedList<>();
		
		Arrays.fill(visited, -1);

		visited[s] = 0;
		queue.add(s);

		while (!queue.isEmpty()) {
			int now = queue.poll();
			int nextUp = now + u;
			int nextDown = now - d;

			if (1 <= nextUp && nextUp <= f) {
				if (visited[nextUp] == -1) {
					queue.add(nextUp);
					visited[nextUp] = visited[now] + 1;
				}
			}
			if (1 <= nextDown && nextDown <= f) {
				if (visited[nextDown] == -1) {
					queue.add(nextDown);
					visited[nextDown] = visited[now] + 1;
				}
			}
		}
		
		if (visited[g] == -1) {
			System.out.println("use the stairs");
		}
		else {
			System.out.println(visited[g]);
		}
	}
}
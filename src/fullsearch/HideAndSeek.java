package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] visited = new int[100001];
		
		Arrays.fill(visited, -1);
		
		int result = BFS(N, K, visited);
		System.out.println(result);
	}

	public static int BFS(int N, int K, int[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] next = new int[3];
		int temp = N;
		
		queue.add(temp);
		visited[temp] = 0;
		
		while (!queue.isEmpty() && temp != K) {
			temp = queue.poll();
			next[0] = temp - 1; // 3가지 경우의 수 
			next[1] = temp + 1;
			next[2] = temp * 2;
			
			for (int i = 0; i < 3; i++) {
				if (0 <= next[i] && next[i] <= 100000) {
					if (visited[next[i]] == -1) { // 방문한적이 없으면
						queue.add(next[i]); // 나오는 값들을 큐에 넣어준다
						visited[next[i]] = visited[temp] + 1; // 그 전 횟수 + 1
					}
				}
			}
		}
		
		return visited[K];
	}
}
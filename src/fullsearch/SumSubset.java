package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumSubset {
	static int N, S;
	static int[] numbers;
	static boolean[] visited;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정수의 개수
		S = Integer.parseInt(st.nextToken()); // 부분집합 원소 다 더한 값
		numbers = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			subset(i, numbers[i]);
			visited[i] = false;
		}
		
		System.out.println(count);
	}
	
	public static void subset(int index, int sum) {
		if (sum == S) { // DFS 호출 될 때 마다 다른 집합이므로 매번 총합을 비교
			count++;
		}
		
		for (int i = index + 1; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				subset(i, sum + numbers[i]);
				visited[i] = false; // 백트래킹
			}
		}
	}
}
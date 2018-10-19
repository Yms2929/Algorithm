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
		
		N = Integer.parseInt(st.nextToken()); // ������ ����
		S = Integer.parseInt(st.nextToken()); // �κ����� ���� �� ���� ��
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
		if (sum == S) { // DFS ȣ�� �� �� ���� �ٸ� �����̹Ƿ� �Ź� ������ ��
			count++;
		}
		
		for (int i = index + 1; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				subset(i, sum + numbers[i]);
				visited[i] = false; // ��Ʈ��ŷ
			}
		}
	}
}
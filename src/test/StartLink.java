package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartLink {
	static int N;
	static int[][] S;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		S = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0, 0);
		
		System.out.println(min);
	}
	
	public static void DFS(int v, int cnt) {
		if (cnt == N / 2) {
			divideTeam();
		}
		else {
			for (int i = v + 1; i <= N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					DFS(i, cnt + 1);
				}
			}
		}
		
		visited[v] = false;
	}

	public static void divideTeam() {
		int[] startTeam = new int[N / 2 + 1];
		int[] linkTeam = new int[N / 2 + 1];
		int start = 1;
		int link = 1;		
		
		for (int i = 1; i <= N; i++) {
			if (visited[i]) {
				startTeam[start] = i;
				start++;
			}
			else {
				linkTeam[link] = i;
				link++;
			}
		}
		
		int startSum = getSum(startTeam);
		int linkSum = getSum(linkTeam);
		
		min = Math.min(min, Math.abs(startSum - linkSum));
	}
	
	public static int getSum(int[] team) {
		int sum = 0;
		
		for (int i = 1; i <= N / 2; i++) {
			for (int j = i + 1; j <= N / 2; j++) {
				sum += S[team[i]][team[j]];
				sum += S[team[j]][team[i]];
			}
		}
		
		return sum;
	}
}
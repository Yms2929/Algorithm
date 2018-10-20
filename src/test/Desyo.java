package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Desyo {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int max = 0;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				DFS(i, j, 0, 0);
				polygon(i, j);
			}
		}
		
		System.out.println(max);
	}

	public static void DFS(int row, int col, int depth, int sum) {
		if (depth == 4) {
			if (max < sum) {
				max = sum;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			
			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					DFS(nx, ny, depth + 1, sum + map[nx][ny]);
					visited[nx][ny] = false;
				}
			}
		}
	}
	
	public static void polygon(int row, int col) {
		int wing = 4;
		int sum = map[row][col];
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < 4; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			
			if (wing < 3) {
				return;
			}
			if (0 > nx || nx >= N || 0 > ny || ny >= M) {
				wing--;
				continue;
			}
			
			sum += map[nx][ny];			
			min = Math.min(min, map[nx][ny]);
		}
	
		if (wing == 4) {
			sum -= min;
		}
		if (max < sum) {
			max = sum;
		}
	}
}
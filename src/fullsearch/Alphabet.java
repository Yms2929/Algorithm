package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alphabet {
	static int[] x = { -1, 0, 1, 0 }; // 상하좌우 움직임
	static int[] y = { 0, 1, 0, -1 };
	static int[][] board;
	static boolean[][] visited;
	static boolean[] check = new boolean[26];
	static int R, C;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // 세로
		C = Integer.parseInt(st.nextToken()); // 가로

		board = new int[R][C]; // 보드
		visited = new boolean[R][C]; // 방문여부

		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = temp.charAt(j) - 'A'; // 문자를 숫자로 바꿔줌
			}
		}

		visited[0][0] = true; // 0,0에서 시작
		check[board[0][0]] = true;
		
		DFS(0, 0, 1);

		System.out.println(max);
	}

	public static void DFS(int row, int col, int count) {
		if (max < count) { // 최대값 보다 크면
			max = count;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = row + x[i]; // 상하좌우 탐색
			int ny = col + y[i];

			if (0 <= nx && nx < R && 0 <= ny && ny < C) { // 범위 충족
				if (!visited[nx][ny] && !check[board[nx][ny]]) { // 방문하지 않았으면
					visited[nx][ny] = true;
					check[board[nx][ny]] = true;
					DFS(nx, ny, count + 1);
					check[board[nx][ny]] = false; // 백트래킹
					visited[nx][ny] = false;
				}
			}
		}
	}
}
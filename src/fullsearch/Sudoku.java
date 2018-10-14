package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sudoku {
	static boolean[][] rowCheck = new boolean[9][10];
	static boolean[][] colCheck = new boolean[9][10];
	static boolean[][] rectCheck = new boolean[9][10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] board = new int[9][9]; // 스도쿠 판
		int count = 0; // 빈칸의 개수
		List<Point> list = new ArrayList<>(); // 빈칸의 위치를 저장할 리스트

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());

				if (board[i][j] == 0) { // 0의 개수 증가 및 리스트에 0의 위치 저장
					count++;
					list.add(new Point(i, j));
				} else {
					colCheck[i][board[i][j]] = true;
					rowCheck[j][board[i][j]] = true;
					rectCheck[(i / 3) * 3 + (j / 3)][board[i][j]] = true;
				}
			}
		}

		DFS(board, count, list, 0);
	}

	public static boolean DFS(int[][] board, int count, List<Point> list, int index) {
		if (index >= count) { // 0을 다 찾고 나면
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			return true;
		}

		Point point = list.get(index); // 0,0 부터 시작
		int x = point.getX();
		int y = point.getY();

		for (int i = 1; i <= 9; i++) {
			if (colCheck[x][i]) {
				continue;
			}
			if (rowCheck[y][i]) {
				continue;
			}
			if (rectCheck[(x / 3) * 3 + (y / 3)][i]) {
				continue;
			}

			colCheck[x][i] = true;
			rowCheck[y][i] = true;
			rectCheck[(x / 3) * 3 + (y / 3)][i] = true;

			board[x][y] = i;

			if (DFS(board, count, list, index + 1)) {
				return true;
			}

			board[x][y] = 0;
			colCheck[x][i] = false;
			rowCheck[y][i] = false;
			rectCheck[(x / 3) * 3 + (y / 3)][i] = false;
		}

		return false;
	}
	
	static class Point {
		private int x;
		private int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}
	}
}
package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeSearch {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // За
		int M = Integer.parseInt(st.nextToken()); // ї­

		int[][] maze = new int[N][M];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = temp.charAt(j) - '0';
			}
		}

		BFS(N, M, maze);
	}

	public static void BFS(int N, int M, int[][] maze) {
		boolean[][] visited = new boolean[N][M];
		Queue<Point> queue = new LinkedList<Point>();
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
		
		visited[0][0] = true;
		queue.add(new Point(0, 0));
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int pointX = point.getX();
			int pointY = point.getY();
			
			for (int i = 0; i < 4; i++) {
				int nextX = pointX + dx[i];
				int nextY = pointY + dy[i];
				
				if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
					if (maze[nextX][nextY] == 1 && !visited[nextX][nextY]) {
						queue.add(new Point(nextX, nextY));
						visited[nextX][nextY] = true;
						maze[nextX][nextY] = maze[pointX][pointY] + 1;
					}
				}
			}
		}
		
		/*for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}*/
		
		System.out.println(maze[N-1][M-1]);
	}

	public static class Point {
		private int x;
		private int y;

		Point(int x, int y) {
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
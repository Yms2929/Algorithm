package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Start {
	static int N;
	static int M;
	static char[][] board;
	static boolean[][][][] visited;
	static int max = 10;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		visited = new boolean[max][max][max][max];

		Point red = null;
		Point blue = null;

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j);

				if (board[i][j] == 'R') {
					board[i][j] = '.';
					red = new Point(i, j);
				}
				else if (board[i][j] == 'B') {
					board[i][j] = '.';
					blue = new Point(i, j);
				}
			}
		}

		bfs(red, blue);
	}

	public static void bfs(Point red, Point blue) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int result = -1;
		
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				for (int k = 0; k < max; k++) {
					Arrays.fill(visited[i][j][k], false);
				}
			}
		}
		
		visited[red.x][red.x][blue.x][blue.y] = true;
		
		Queue<Data> queue = new LinkedList<>();
		queue.add(new Data(red,blue,0));
		
		while(!queue.isEmpty()) {
			Data now = queue.poll();
			Point rPoint = new Point(now.red.x, now.red.y);
			Point bPoint = new Point(now.blue.x, now.blue.y);
			int count = now.count + 1;
			
			if (count > 10) {
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				Point nextR = new Point(rPoint.x, rPoint.y);
				Point nextB = new Point(bPoint.x, bPoint.y);
				
				while (board[nextR.x + dx[i]][nextR.y + dy[i]] != '#') {
					nextR.x += dx[i];
					nextR.y += dy[i];
					if (board[nextR.x][nextR.y] == 'O') {
						break;
					}
				}
				
				while (board[nextB.x + dx[i]][nextB.y + dy[i]] != '#') {
					nextB.x += dx[i];
					nextB.y += dy[i];
					if (board[nextB.x][nextR.y] == 'O') {
						break;
					}
				}
				
				if (board[nextB.x][nextB.y] == 'O') {
					continue;
				}
				
				if (board[nextR.x][nextR.y] == 'O') {
					System.out.println(count);
					return;
				}
				
				if (nextR.x == nextB.x && nextR.y == nextB.y) {
					if (dx[i] != 0) {
						if (rPoint.x * dx[i] > bPoint.x * dx[i]) {
							nextB.x -= dx[i];
						}
						else {
							nextR.x -= dx[i];
						}
					}
					else {
						if (rPoint.y * dy[i] > bPoint.y * dy[i]) {
							nextB.y -= dy[i];
						}
						else {
							nextR.y -= dy[i];
						}
					}
				}
				
				if (visited[nextR.x][nextR.y][nextB.x][nextB.y]) {
					continue;
				}
				
				queue.add(new Data(nextR, nextB, count));
				visited[nextR.x][nextR.y][nextB.x][nextB.y] = true;
			}
		}
		
		System.out.println(result);
	}

}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Data {
	Point red;
	Point blue;
	int count;
	
	Data(Point red, Point blue, int count) {
		this.red = red;
		this.blue = blue;
		this.count = count;
	}
}
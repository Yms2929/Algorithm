package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MakeBridge {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[][] bridge;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N]; // 지도
		visited = new boolean[N][N]; // 방문 여부
		bridge = new int[N][N]; // 다리
		
		for (int i = 0; i < N; i++) { // 지도 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int number = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					number++;
					DFS(i, j, number);
				}
			}
		}
		
		/*System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}*/
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
		
		BFS();
		
		/*System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}*/
		
		/*System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(bridge[i][j] + " ");
			}
			System.out.println();
		}*/
	}
	
	public static void DFS(int row, int col, int number) {
		visited[row][col] = true;
		map[row][col] = number;
		
		for (int i = 0; i < 4; i++) {
			int nextRow = row + dx[i];
			int nextCol = col + dy[i];
			
			if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < N) {
				if (map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
					DFS(nextRow, nextCol, number);
				}
			}
		}
	}
	
	public static void BFS() {
		Queue<Point> queue = new LinkedList<Point>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					queue.add(new Point(i, j));
				}
			}
		}
		
		int min = 0;
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int pointX = point.getX();
			int pointY = point.getY();
			
			for (int i = 0; i < 4; i++) {
				int nextX = pointX + dx[i];
				int nextY = pointY + dy[i];
				
				if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
					if (map[nextX][nextY] == 0 && !visited[nextX][nextY] && bridge[nextX][nextY] == 0) {
						bridge[nextX][nextY] = bridge[pointX][pointY] + 1;
						queue.add(new Point(nextX, nextY));
						map[nextX][nextY] = map[pointX][pointY];
						visited[nextX][nextY] = true;
					}
					else if (map[nextX][nextY] != map[pointX][pointY]) {
						int temp = bridge[pointX][pointY] + bridge[nextX][nextY];
						
						if (min == 0 || (min != 0 && min > temp)) {
							min = temp;
						}
					}
				}
			}
		}
		
		System.out.println(min);
	}
	
	public static class Point {
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
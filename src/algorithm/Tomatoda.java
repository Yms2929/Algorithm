package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomatoda {
	static int M, N;
	static int[][] box;
	static boolean[][] visited;
	static int[] x = {-1, 0, 1, 0};
	static int[] y = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 가로 칸
		N = Integer.parseInt(st.nextToken()); // 세로 칸
		
		box = new int[N][M]; // 상자
		visited = new boolean[N][M]; // 방문 여부
		
		// 박스안 토마토 상태 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BFS();
	}
	
	// 좌표 저장할 클래스
	static class Point {
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

	public static void BFS() {
		int day = 0; // 최소 날짜
		
		// BFS 구현을 위한 큐 생성
		Queue<Point> queue = new LinkedList<Point>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1) {
					queue.add(new Point(i, j));
					visited[i][j] = true;
				}
			}
		}
		
		// 큐가 빌 때까지 반복
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int pointX = point.getX();
			int pointY = point.getY();

			for (int i = 0; i < 4; i++) {
				int nextX = pointX + x[i];
				int nextY = pointY + y[i];
				
				if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
					if (box[nextX][nextY] == 0 && !visited[nextX][nextY]) {
						queue.add(new Point(nextX, nextY));
						visited[nextX][nextY] = true;
						box[nextX][nextY] = box[pointX][pointY] + 1;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) { // 토마토가 모두 익지 않은 상태
					System.out.println(-1);
					return;
				}
				
				day = Math.max(day, box[i][j]);
			}
		}
		
		System.out.println(day - 1);
	}
}
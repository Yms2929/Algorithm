package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Puzzle {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] graph = new int[3][3];
		boolean[][] visited = new boolean[3][3];

		/*
		 * for (int i = 0; i < 3; i++) { StringTokenizer st = new
		 * StringTokenizer(br.readLine()); for (int j = 0; j < 3; j++) { graph[i][j] =
		 * Integer.parseInt(st.nextToken()); } }
		 * 
		 * int x = 0, y = 0; for (int i = 0; i < 3; i++) { for (int j = 0; j < 3; j++) {
		 * if (graph[i][j] == 0) { x = i; y = j; } } }
		 * 
		 * BFS(x, y, visited, graph);
		 */

		Scanner scanner = new Scanner(System.in);
		int start = 0;
		for (int i = 0; i < 3; i++) { // 2차원 배열을 1차원으로 생각하기
			for (int j = 0; j < 3; j++) {
				int temp = scanner.nextInt();

				if (temp == 0) {
					temp = 9;
				}

				start = start * 10 + temp;
			}
		}

		BFS(start);
	}

	public static void BFS(int start) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		Map<Integer, Integer> map = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		map.put(start, 0);

		while (!queue.isEmpty()) {
			int temp = queue.poll();
			String now = Integer.toString(temp); // 스트링으로 변환
			int index = now.indexOf('9'); // 9의 인덱스를 찾기
			int x = index % 3; // x, y의 위치 찾기
			int y = index / 3;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 <= nx && nx < 3 && 0 <= ny && ny < 3) {
					StringBuilder sb = new StringBuilder(now);
					char c = now.charAt(index);
					sb.setCharAt(index, sb.charAt(3 * ny + nx)); // 스왑
					sb.setCharAt(3 * ny + nx, c);

					int num = Integer.parseInt(sb.toString());
					if (!map.containsKey(num)) {
						map.put(num, map.get(temp) + 1); // 값에 횟수 저장
						queue.add(num);
					}
				}
			}
		}
		
		if (map.containsKey(123456789)) {
			System.out.println(map.get(123456789));
		}
		else {
			System.out.println(-1);
		}
	}

	public static void BFS(int x, int y, boolean[][] visited, int[][] graph) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		Queue<Point> queue = new LinkedList<>();
		int[][] check = new int[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				check[i][j] = -1;
			}
		}

		check[x][y] = 0;
		visited[x][y] = true;
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point point = queue.poll();

			if (graph[2][2] == 0) {
				System.out.println(check[2][2]);
				/*
				 * for (int i = 0; i < 3; i++) { for (int j = 0; j < 3; j++) {
				 * System.out.print(check[i][j] + " "); } System.out.println(); }
				 */
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = point.getX() + dx[i];
				int nextY = point.getY() + dy[i];

				if (0 <= nextX && nextX < 3 && 0 <= nextY && nextY < 3) {
					if (!visited[nextX][nextY]) {
						visited[nextX][nextY] = true;
						queue.add(new Point(nextX, nextY));
						check[nextX][nextY] = check[point.getX()][point.getY()] + 1;
						int temp = graph[point.getX()][point.getY()];
						graph[point.getX()][point.getY()] = graph[nextX][nextY];
						graph[nextX][nextY] = temp;
					}
				}
			}
		}
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
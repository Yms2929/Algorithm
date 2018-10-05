package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IslandCount {
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static int[] x = { 0, -1, 0, 1, -1, -1, 1, 1};
	static int[] y = { -1, 0, 1, 0, -1, 1, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); // 지도의 너비
			h = Integer.parseInt(st.nextToken()); // 지도의 높이

			if (w == 0 && h == 0) { // 종료
				break;
			}

			map = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); // 땅이랑 바다 입력
				}
			}

			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						count = DFS(i, j, count);
					}
				}
			}

			System.out.println(count);
		}
	}

	public static int DFS(int row, int col, int count) {
		visited[row][col] = true;
		count++;
		
		for (int i = 0; i < 8; i++) {
			int nextRow = row + x[i];
			int nextCol = col + y[i];
			if (0 <= nextRow && nextRow < h && 0 <= nextCol && nextCol < w) {
				if (map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
					DFS(nextRow, nextCol, count);
				}
			}
		}

		return count;
	}

}
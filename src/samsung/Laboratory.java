package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Laboratory {
	static int N, M;
	static int[][] map;
	static int[][] mapTest;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // ����
		M = Integer.parseInt(st.nextToken()); // ����
		map = new int[N][M]; // ����
		mapTest = new int[N][M]; // �׽�Ʈ ����
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N * M; i++) {
			int row = i / M;
			int col = i % M;

			if (map[row][col] == 0) {
				map[row][col] = 1;
				dfs(i, 1);
				map[row][col] = 0;
			}
		}
		
		System.out.println(max);
	}
	
	public static void dfs(int v, int cnt) {
		int row = v / M;
		int col = v % M;
		
		if (cnt == 3) { // �� 3�� �����
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					mapTest[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (mapTest[i][j] == 2) {
						spreadVirus(i, j); // ���̷��� ������
					}
				}
			}
			
			int count = safeCheck(); // ���� ���� üũ
			if (max < count) { // �ִ밪 ���ϱ�
				max = count;
			}
		}
		else { // �� �����
			for (int i = v + 1; i < N * M; i++) {
				int rr = i / M;
				int cc = i % M;
				
				if (map[rr][cc] == 0) {
					map[rr][cc] = 1;
					dfs(i, cnt + 1);
				}
			}
		}
		
		map[row][col] = 0; // ��Ʈ��ŷ
	}

	public static void spreadVirus(int row, int col) { // ���̷��� ����
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
			
		for (int i = 0; i < 4; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];

			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (mapTest[nx][ny] == 0) {
					mapTest[nx][ny] = 2;
					spreadVirus(nx, ny);
				}
			}
		}
	}
	
	public static int safeCheck() { // ���� ���� üũ
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mapTest[i][j] == 0) {
					count++;
				}
			}
		}
		
		return count;
	}
}
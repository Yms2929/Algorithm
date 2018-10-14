package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alphabet {
	static int[] x = { -1, 0, 1, 0 }; // �����¿� ������
	static int[] y = { 0, 1, 0, -1 };
	static int[][] board;
	static boolean[][] visited;
	static boolean[] check = new boolean[26];
	static int R, C;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // ����
		C = Integer.parseInt(st.nextToken()); // ����

		board = new int[R][C]; // ����
		visited = new boolean[R][C]; // �湮����

		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = temp.charAt(j) - 'A'; // ���ڸ� ���ڷ� �ٲ���
			}
		}

		visited[0][0] = true; // 0,0���� ����
		check[board[0][0]] = true;
		
		DFS(0, 0, 1);

		System.out.println(max);
	}

	public static void DFS(int row, int col, int count) {
		if (max < count) { // �ִ밪 ���� ũ��
			max = count;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = row + x[i]; // �����¿� Ž��
			int ny = col + y[i];

			if (0 <= nx && nx < R && 0 <= ny && ny < C) { // ���� ����
				if (!visited[nx][ny] && !check[board[nx][ny]]) { // �湮���� �ʾ�����
					visited[nx][ny] = true;
					check[board[nx][ny]] = true;
					DFS(nx, ny, count + 1);
					check[board[nx][ny]] = false; // ��Ʈ��ŷ
					visited[nx][ny] = false;
				}
			}
		}
	}
}
package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Teteuromino {
	static int N, M;
	static int[][] paper;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // ����
		M = Integer.parseInt(st.nextToken()); // ����
		paper = new int[N][M]; // ����
		visited = new boolean[N][M]; // �湮����

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken()); // ���� �Է�
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) { // ��� ������ DFS
				DFS(i, j, 0, 0);
				exception(i, j); // �� �� �� �� ���
			}
		}

		System.out.println(max);
	}

	public static void DFS(int x, int y, int depth, int sum) {
		if (depth == 4) { // ���� 4�̸� �ִ밪 ��
			if (max < sum) {
				max = sum;
			}
			return;
		}
		else {
			for (int i = 0; i < 4; i++) { // 4���� Ž��
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M) { // ���� ����
					if (!visited[nx][ny]) {
						visited[nx][ny] = true; // �湮 üũ
						DFS(nx, ny, depth + 1, sum + paper[nx][ny]); // ���� �����ϰ� �湮 ��ġ�� �� ������
						visited[nx][ny] = false; // ��Ʈ��ŷ
					}
				}
			}
		}
	}

	public static void exception(int x, int y) {
		int wing = 4;
		int sum = paper[x][y]; // ��� ��
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < 4; i++) { // ��������
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (wing < 3) { // ���� 3�� �̸��̸� ��Ʈ�ι̳� �ƴϴ�
				return;
			}
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				wing--; // ���� ���̸� ���� �ϳ� ���� ��
				continue;
			}
			
			sum += paper[nx][ny]; // ���� �� �� ����
			min = Math.min(min, paper[nx][ny]); // ������ �ּҰ� ���ϱ�
		}

		if (wing == 4) { // ������ 4���� �ּҰ� ���� ���ش�
			sum -= min;
		}
		
		max = Math.max(max, sum);
	}
}
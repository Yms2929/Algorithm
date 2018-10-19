package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FakeLadder {
	static int N, M, H;
	static int[][] map;
	static int min = 4;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // ���μ� ����
		M = Integer.parseInt(st.nextToken()); // ���μ� ����
		H = Integer.parseInt(st.nextToken()); // ���μ� ���� ���μ� ���� �� �ִ� ����

		map = new int[31][11];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1; // ��ٸ� ����
		}

		for (int i = 0; i < 4; i++) { // ��ٸ� �߰��ϱ�
			draw(1, 0, i);
			if (min != 4) break;
		}

		if (min == 4) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
	}

	public static void draw(int row, int cnt, int mCnt) {
		if (min != 4) { // ���� row, ���� ��ٸ���, ��ǥ�ִ� ��ٸ���
			return;
		}

		if (cnt >= mCnt) { // ���� ��ٸ����� ��ǥ ��ٸ����� ���ٸ�
			if (check()) {
				min = cnt;
			}
			return;
		}

		for (int i = row; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j] == 1 || map[i][j - 1] == 1 || map[i][j + 1] == 1) {
					continue; // ���� ��ġ�� ���� �����ʿ� ��ٸ��� �ִٸ� ���
				}

				map[i][j] = 1; // �ƴϸ� ��ٸ� ���´�
				draw(i, cnt + 1, mCnt);
				map[i][j] = 0; // ��Ʈ��ŷ
			}
		}
	}

	public static boolean check() {
		for (int i = 1; i <= N; i++) { // 1�� ��ٸ����� �˻� ����
			int currentX = i;
			
			for (int j = 1; j <= H; j++) {
				if (map[j][currentX] == 1) { // ��ٸ��� ������ �������� �̵�
					currentX++;
				}
				else if (map[j][currentX - 1] == 1) { // �޹��� �̵�
					currentX--;
				}
			}
			if (currentX == i) {
				continue;
			}
			else {
				return false;
			}
		}

		return true;
	}
}
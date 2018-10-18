package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Snake {
	static int N, K, L;
	static int[][] board;
	static final int RIGHT = 0;
	static final int BOTTOM = 1;
	static final int LEFT = 2;
	static final int TOP = 3;
	static int[] dx = { 0, 1, 0, -1 }; // �� �� �� ��
	static int[] dy = { 1, 0, -1, 0 }; // 0 1 2 3

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // ���� ũ��
		board = new int[N][N]; // ����

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = 0; // ���� ��ĭ 0
			}
		}
		board[0][0] = 1; // �� ó�� ��ġ

		K = Integer.parseInt(br.readLine()); // ��� ����

		for (int i = 0; i < K; i++) { // ��� ��ġ ǥ��
			StringTokenizer st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 2;
		}

		List<Direct> direct = new ArrayList<>();
		L = Integer.parseInt(br.readLine()); // ���� ���� ��ȯ Ƚ��

		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int second = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			direct.add(new Direct(second, dir)); // ���� ��ȯ ���� ����
		}
		direct.add(new Direct(100, "D")); // ������ �ѹ��� �ݺ��� ���ƾ���

		move(direct);
	}

	public static void move(List<Direct> direct) { // ���� L ������ D ���� 90�� ȸ��
		int second = 0; // �ɸ� �ð�
		List<Point> snakeLoc = new ArrayList<>(); // ���� �ִ� ��� ��ǥ
		Point currentLoc = new Point(0, 0); // ó�� �� ��ġ
		snakeLoc.add(new Point(0, 0));
		int currentDir = RIGHT; // ���� �̵� ����
		int nx = 0; // ���� ��ġ
		int ny = 0;
		boolean go = true; // �ݺ��� Ż�� ����

		for (int i = 0; i < L + 1; i++) { // ���� ���� ���� �� �ٲ۴��� ���� �ε��� �� ���� �� ������
			if (!go) {
				break;
			}

			int changeSec = direct.get(i).sec; // ���� ��� �ð�
			String changeDir = direct.get(i).dir; // ���� ���� ����
			int diff = changeSec;

			if (i > 0) {
				diff = changeSec - direct.get(i - 1).sec;
			}
			while (diff-- > 0) { // �ð� ���̸�ŭ �̵�
				second++;
				currentLoc = getNext(currentLoc, currentDir);
				nx = currentLoc.x;
				ny = currentLoc.y;

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) { // �� �Ѿ�� ����
					go = false;
					System.out.println(second);
					break;
				} else { // ���� ���̸�
					if (board[nx][ny] == 1) { // �ڱ� ���� �ε����� ����
						go = false;
						System.out.println(second);
						break;
					} else if (board[nx][ny] == 2) { // ��� ������ ������ + 1
						board[nx][ny] = 1; // ��� ���ְ� ���� ����
						snakeLoc.add(new Point(nx, ny));
					} else if (board[nx][ny] == 0) { // ��ĭ�̸� �̵�
						board[nx][ny] = 1;
						board[snakeLoc.get(0).x][snakeLoc.get(0).y] = 0; // ������ ��ĭ����
						snakeLoc.remove(0); // ���� ����
						snakeLoc.add(new Point(nx, ny));
					}
				}

				currentLoc.x = nx; // ���� ��ġ�� ����
				currentLoc.y = ny;
			}

			currentDir = changeDirect(currentDir, changeDir); // ���� �ٲٱ�
		}
	}

	public static Point getNext(Point currentLoc, int currentDir) {
		if (currentDir == 0) {
			currentLoc.x += dx[0];
			currentLoc.y += dy[0];
		} else if (currentDir == 1) {
			currentLoc.x += dx[1];
			currentLoc.y += dy[1];
		} else if (currentDir == 2) {
			currentLoc.x += dx[2];
			currentLoc.y += dy[2];
		} else if (currentDir == 3) {
			currentLoc.x += dx[3];
			currentLoc.y += dy[3];
		}

		return currentLoc;
	}

	public static int changeDirect(int currentDir, String direct) {
		if (direct.equals("D")) { // ������ ȸ��
			switch (currentDir) {
			case 0:
				currentDir = BOTTOM;
				break;
			case 1:
				currentDir = LEFT;
				break;
			case 2:
				currentDir = TOP;
				break;
			case 3:
				currentDir = RIGHT;
				break;
			}
		} else if (direct.equals("L")) { // ���� ȸ��
			switch (currentDir) {
			case 0:
				currentDir = TOP;
				break;
			case 1:
				currentDir = RIGHT;
				break;
			case 2:
				currentDir = BOTTOM;
				break;
			case 3:
				currentDir = LEFT;
				break;
			}
		}

		return currentDir;
	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Direct {
		int sec;
		String dir;

		Direct(int sec, String dir) {
			this.sec = sec;
			this.dir = dir;
		}
	}
}
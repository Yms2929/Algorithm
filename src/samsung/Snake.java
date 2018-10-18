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
	static int[] dx = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int[] dy = { 1, 0, -1, 0 }; // 0 1 2 3

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 보드 크기
		board = new int[N][N]; // 보드

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = 0; // 보드 빈칸 0
			}
		}
		board[0][0] = 1; // 뱀 처음 위치

		K = Integer.parseInt(br.readLine()); // 사과 개수

		for (int i = 0; i < K; i++) { // 사과 위치 표시
			StringTokenizer st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 2;
		}

		List<Direct> direct = new ArrayList<>();
		L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수

		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int second = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			direct.add(new Direct(second, dir)); // 방향 변환 정보 저장
		}
		direct.add(new Direct(100, "D")); // 마지막 한번더 반복문 돌아야함

		move(direct);
	}

	public static void move(List<Direct> direct) { // 왼쪽 L 오른쪽 D 방향 90도 회전
		int second = 0; // 걸린 시간
		List<Point> snakeLoc = new ArrayList<>(); // 뱀이 있는 모든 좌표
		Point currentLoc = new Point(0, 0); // 처음 뱀 위치
		snakeLoc.add(new Point(0, 0));
		int currentDir = RIGHT; // 현재 이동 방향
		int nx = 0; // 다음 위치
		int ny = 0;
		boolean go = true; // 반복문 탈출 변수

		for (int i = 0; i < L + 1; i++) { // 여기 함정 방향 다 바꾼다음 벽에 부딪힐 때 까지 쭉 가야함
			if (!go) {
				break;
			}

			int changeSec = direct.get(i).sec; // 다음 명령 시간
			String changeDir = direct.get(i).dir; // 다음 변경 방향
			int diff = changeSec;

			if (i > 0) {
				diff = changeSec - direct.get(i - 1).sec;
			}
			while (diff-- > 0) { // 시간 차이만큼 이동
				second++;
				currentLoc = getNext(currentLoc, currentDir);
				nx = currentLoc.x;
				ny = currentLoc.y;

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) { // 벽 넘어가면 종료
					go = false;
					System.out.println(second);
					break;
				} else { // 범위 안이면
					if (board[nx][ny] == 1) { // 자기 몸통 부딪히면 종료
						go = false;
						System.out.println(second);
						break;
					} else if (board[nx][ny] == 2) { // 사과 먹으면 몸길이 + 1
						board[nx][ny] = 1; // 사과 없애고 뱀이 차지
						snakeLoc.add(new Point(nx, ny));
					} else if (board[nx][ny] == 0) { // 빈칸이면 이동
						board[nx][ny] = 1;
						board[snakeLoc.get(0).x][snakeLoc.get(0).y] = 0; // 꼬리는 빈칸으로
						snakeLoc.remove(0); // 꼬리 삭제
						snakeLoc.add(new Point(nx, ny));
					}
				}

				currentLoc.x = nx; // 현재 위치로 변경
				currentLoc.y = ny;
			}

			currentDir = changeDirect(currentDir, changeDir); // 방향 바꾸기
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
		if (direct.equals("D")) { // 오른쪽 회전
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
		} else if (direct.equals("L")) { // 왼쪽 회전
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
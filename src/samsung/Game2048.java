package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Game2048 {
	static final int LEFT = 0;
	static final int UP = 1;
	static final int RIGHT = 2;
	static final int DOWN = 3;

	static int N;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();

		DFS(board, 0);

		System.out.println(max);
	}

	public static void DFS(int[][] board, int step) {
		if (step == 5) {
			getMax(board);
			return;
		}

		for (int i = 0; i < 4; i++) { // 4방향 탐색
			int[][] boardCopy = new int[N][N]; // 새로 만들어줘야 함
			for (int j = 0; j < N; j++) {
				boardCopy[j] = Arrays.copyOf(board[j], N); // 배열 복사
			}

			DFS(move(boardCopy, i), step + 1); // 깊이 1 증가
		}
	}

	public static int[][] move(int[][] boardCopy, int num) {
		switch (num) {
		case LEFT:
			for (int row = 0; row < N; row++) {
				int nBlank = 0;

				for (int col = 1; col < N; col++) { // 왼쪽에서 오른쪽으로 이동
					if (boardCopy[row][col] == 0) { // 이동하는 방향에 빈칸이 있으면
						nBlank++; // 빈칸 증가
						continue;
					}
					else {
						// 시작 칸과 끝 칸의 숫자가 같으면
						if (boardCopy[row][col] == boardCopy[row][col - 1 - nBlank]) {
							boardCopy[row][col - 1 - nBlank] *= 2; // 끝 칸에 2배를 해주고
							boardCopy[row][col] = 0; // 시작 칸을 0으로 바꾼다
						}
						// 끝 칸에 숫자가 없으면
						else if (boardCopy[row][col - 1 - nBlank] == 0) {
							boardCopy[row][col - 1 - nBlank] = boardCopy[row][col];
							boardCopy[row][col] = 0;
							nBlank++;
						}
						// 시작 칸과 끝 칸의 숫자가 다르면
						else {
							boardCopy[row][col - nBlank] = boardCopy[row][col];
							if (nBlank != 0) {
								boardCopy[row][col] = 0;
							}
						}
					}
				}
			}
			break;

		case UP:
			for (int col = 0; col < N; col++) {
				int nBlank = 0;

				for (int row = 1; row < N; row++) { // 위에서 아래로 이동
					if (boardCopy[row][col] == 0) {
						nBlank++;
						continue;
					}
					else {
						// 시작 칸과 끝 칸의 숫자가 같으면
						if (boardCopy[row - 1 - nBlank][col] == boardCopy[row][col]) {
							boardCopy[row - 1 - nBlank][col] *= 2; // 끝 칸에 2배를 해주고
							boardCopy[row][col] = 0; // 시작 칸을 0으로 바꾼다
						}
						// 끝 칸에 숫자가 없으면
						else if (boardCopy[row - 1 - nBlank][col] == 0) {
							boardCopy[row - 1 - nBlank][col] = boardCopy[row][col];
							boardCopy[row][col] = 0;
							nBlank++;
						}
						// 시작 칸과 끝 칸의 숫자가 다르면
						else {
							boardCopy[row - nBlank][col] = boardCopy[row][col];
							if (nBlank != 0) {
								boardCopy[row][col] = 0;
							}
						}
					}
				}
			}
			break;

		case RIGHT:
			for (int row = 0; row < N; row++) {
				int nBlank = 0;

				for (int col = N - 2; col >= 0; col--) { // 오른쪽에서 왼쪽으로 이동
					if (boardCopy[row][col] == 0) {
						nBlank++;
						continue;
					}
					else {
						// 시작 칸과 끝 칸의 숫자가 같으면
						if (boardCopy[row][col] == boardCopy[row][col + 1 + nBlank]) {
							boardCopy[row][col + 1 + nBlank] *= 2; // 끝 칸에 2배를 해주고
							boardCopy[row][col] = 0; // 시작 칸을 0으로 바꾼다
						}
						// 끝 칸에 숫자가 없으면
						else if (boardCopy[row][col + 1 + nBlank] == 0) {
							boardCopy[row][col + 1 + nBlank] = boardCopy[row][col];
							boardCopy[row][col] = 0;
							nBlank++;
						}
						// 시작 칸과 끝 칸의 숫자가 다르면
						else {
							boardCopy[row][col + nBlank] = boardCopy[row][col];
							if (nBlank != 0) {
								boardCopy[row][col] = 0;
							}
						}
					}
				}
			}
			break;

		case DOWN:
			for (int col = 0; col < N; col++) {
				int nBlank = 0;

				for (int row = N - 2; row >= 0; row--) { // 아래에서 위로 이동
					if (boardCopy[row][col] == 0) {
						nBlank++;
						continue;
					}
					else {
						// 시작 칸과 끝 칸의 숫자가 같으면
						if (boardCopy[row + 1 + nBlank][col] == boardCopy[row][col]) {
							boardCopy[row + 1 + nBlank][col] *= 2; // 끝 칸에 2배를 해주고
							boardCopy[row][col] = 0; // 시작 칸을 0으로 바꾼다
						}
						// 끝 칸에 숫자가 없으면
						else if (boardCopy[row + 1 + nBlank][col] == 0) {
							boardCopy[row + 1 + nBlank][col] = boardCopy[row][col];
							boardCopy[row][col] = 0;
							nBlank++;
						}
						// 시작 칸과 끝 칸의 숫자가 다르면
						else {
							boardCopy[row + nBlank][col] = boardCopy[row][col];
							if (nBlank != 0) {
								boardCopy[row][col] = 0;
							}
						}
					}
				}
			}
			break;
		}

		return boardCopy;
	}

	public static void getMax(int[][] board) { // 최대값 구하기
		int temp = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (temp < board[i][j]) {
					temp = board[i][j];
				}
			}
		}

		max = max < temp ? temp : max;
	}
}
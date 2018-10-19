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

		N = Integer.parseInt(st.nextToken()); // 세로선 개수
		M = Integer.parseInt(st.nextToken()); // 가로선 개수
		H = Integer.parseInt(st.nextToken()); // 세로선 마다 가로선 놓을 수 있는 개수

		map = new int[31][11];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1; // 사다리 놓기
		}

		for (int i = 0; i < 4; i++) { // 사다리 추가하기
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
		if (min != 4) { // 현재 row, 현재 사다리수, 목표최대 사다리수
			return;
		}

		if (cnt >= mCnt) { // 현재 사다리수와 목표 사다리수가 같다면
			if (check()) {
				min = cnt;
			}
			return;
		}

		for (int i = row; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j] == 1 || map[i][j - 1] == 1 || map[i][j + 1] == 1) {
					continue; // 현재 위치와 왼쪽 오른쪽에 사다리가 있다면 통과
				}

				map[i][j] = 1; // 아니면 사다리 놓는다
				draw(i, cnt + 1, mCnt);
				map[i][j] = 0; // 백트래킹
			}
		}
	}

	public static boolean check() {
		for (int i = 1; i <= N; i++) { // 1번 사다리부터 검사 시작
			int currentX = i;
			
			for (int j = 1; j <= H; j++) {
				if (map[j][currentX] == 1) { // 사다리가 있으면 오른방향 이동
					currentX++;
				}
				else if (map[j][currentX - 1] == 1) { // 왼방향 이동
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
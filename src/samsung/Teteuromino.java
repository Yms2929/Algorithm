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

		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		paper = new int[N][M]; // 종이
		visited = new boolean[N][M]; // 방문여부

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken()); // 숫자 입력
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) { // 모든 점에서 DFS
				DFS(i, j, 0, 0);
				exception(i, j); // ㅗ ㅜ ㅏ ㅓ 모양
			}
		}

		System.out.println(max);
	}

	public static void DFS(int x, int y, int depth, int sum) {
		if (depth == 4) { // 깊이 4이면 최대값 비교
			if (max < sum) {
				max = sum;
			}
			return;
		}
		else {
			for (int i = 0; i < 4; i++) { // 4방향 탐색
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M) { // 범위 충족
					if (!visited[nx][ny]) {
						visited[nx][ny] = true; // 방문 체크
						DFS(nx, ny, depth + 1, sum + paper[nx][ny]); // 깊이 증가하고 방문 위치의 수 더해줌
						visited[nx][ny] = false; // 백트래킹
					}
				}
			}
		}
	}

	public static void exception(int x, int y) {
		int wing = 4;
		int sum = paper[x][y]; // 가운데 값
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < 4; i++) { // 동서남북
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (wing < 3) { // 날개 3개 미만이면 테트로미노 아니다
				return;
			}
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				wing--; // 범위 밖이면 날개 하나 없는 것
				continue;
			}
			
			sum += paper[nx][ny]; // 날개 값 다 더함
			min = Math.min(min, paper[nx][ny]); // 날개중 최소값 구하기
		}

		if (wing == 4) { // 날개가 4개면 최소값 날개 빼준다
			sum -= min;
		}
		
		max = Math.max(max, sum);
	}
}
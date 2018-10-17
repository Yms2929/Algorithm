package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Monitoring {
	static int N, M;
	static int[][] office;
	static int[][] copyoffice;
	static List<Point> list;
	static int min = Integer.MAX_VALUE;
	static int count = 0;
	static int[] cases;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		office = new int[N][M];
		copyoffice = new int[N][M];
		list = new ArrayList<Point>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				copyoffice[i][j] = office[i][j];

				if (office[i][j] != 0 && office[i][j] != 6) {
					list.add(new Point(i, j));
				}
			}
		}

		cases = new int[list.size()]; // 모든 조합을 저장할 배열

		if (list.size() == 0) {
			count();
			min = count;
		}
		else {
			for (int i = 0; i < 4; i++) {
				cases[0] = i + 1;
				DFS(i, 0);
			}
		}

		System.out.println(min);
	}

	public static void DFS(int start, int depth) { // cctv가 감시하는 모든 경우의 수 DFS
		if (depth == list.size() - 1) {
			for (int i = 0; i < list.size(); i++) { // 모든 cctv를 돌린다
				Point point = list.get(i);

				monitoring(point, office[point.x][point.y], cases[i]);
			}
			
			count(); // 사각지대 카운트
			min = Math.min(min, count); // 사각지대 최소값 저장
			reset(); // 장소 초기화
			return;
		}
		else {
			for (int i = 0; i < 4; i++) {
				cases[depth + 1] = i + 1;
				DFS(i, depth + 1);
			}
		}
	}

	public static void monitoring(Point p, int num, int dir) { // cctv 종류와 방향에 따라 감시 위치 정한다
		if (num == 1) { // 1번 cctv
			if (dir == 1) {
				move(p, 1);
			} else if (dir == 2) {
				move(p, 2);
			} else if (dir == 3) {
				move(p, 3);
			} else if (dir == 4) {
				move(p, 4);
			}
		} else if (num == 2) { // 2번 cctv
			if (dir == 1) {
				move(p, 1);
				move(p, 3);
			} else if (dir == 2) {
				move(p, 2);
				move(p, 4);
			} else if (dir == 3) {
				move(p, 1);
				move(p, 3);
			} else if (dir == 4) {
				move(p, 2);
				move(p, 4);
			}
		} else if (num == 3) { // 3번 cctv
			if (dir == 1) {
				move(p, 1);
				move(p, 2);
			} else if (dir == 2) {
				move(p, 2);
				move(p, 3);
			} else if (dir == 3) {
				move(p, 3);
				move(p, 4);
			} else if (dir == 4) {
				move(p, 4);
				move(p, 1);
			}
		} else if (num == 4) { // 4번 cctv
			if (dir == 1) {
				move(p, 1);
				move(p, 2);
				move(p, 3);
			} else if (dir == 2) {
				move(p, 2);
				move(p, 3);
				move(p, 4);
			} else if (dir == 3) {
				move(p, 3);
				move(p, 4);
				move(p, 1);
			} else if (dir == 4) {
				move(p, 4);
				move(p, 1);
				move(p, 2);
			}
		} else if (num == 5) {
			move(p, 1);
			move(p, 2);
			move(p, 3);
			move(p, 4);
		}
	}

	public static void move(Point p, int dir) { // 감시 시작
		int currentX = p.x;
		int currentY = p.y;
		int nextX = currentX;
		int nextY = currentY;
		
		if (dir == 1) { // 방향에 따라 위
			nextX = currentX - 1;
			nextY = currentY;
		} else if (dir == 2) { // 오른쪽
			nextX = currentX;
			nextY = currentY + 1;
		} else if (dir == 3) { // 아래
			nextX = currentX + 1;
			nextY = currentY;
		} else if (dir == 4) { // 왼쪽
			nextX = currentX;
			nextY = currentY - 1;
		}
		
		if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) { // 다음 위치가 범위 밖이면 종료
			return;
		}
		if (office[nextX][nextY] == 6) { // 다음 위치가 벽이면 종료
			return;
		}
		if (office[nextX][nextY] == 0) {
			office[nextX][nextY] = 1;
		}
		
		move(new Point(nextX, nextY), dir);
	}

	public static void count() { // 사각지대 개수 세기
		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (office[i][j] == 0) {
					count++;
				}
			}
		}
	}

	public static void reset() { // 배열 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				office[i][j] = copyoffice[i][j];
			}
		}
	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
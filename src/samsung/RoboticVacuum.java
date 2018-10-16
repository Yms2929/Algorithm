package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RoboticVacuum {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		map = new int[N][M]; // 지도
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()); // 북쪽으로부터 떨어진 칸의 수
		int c = Integer.parseInt(st.nextToken()); // 서쪽으로부터 떨어진 칸의 수
		int d = Integer.parseInt(st.nextToken()); // 바라보는 방향
		
		Point point = new Point(r, c, d); // 로봇 청소기 좌표
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BFS(point);
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 9) { // 청소한 곳의 개수
					result++;
				}
			}
		}
		
		System.out.println(result);
		
		/*for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}*/
 	}
	
	public static void BFS(Point start) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(start.x, start.y, start.dir));
		map[start.x][start.y] = 9;
		
		while (!queue.isEmpty()) {
			Point current = queue.poll(); // 현재 좌표와 방향
			int nx = 0; // 다음 x좌표
			int ny = 0; // 다음 y좌표
			int nd = 0; // 다음 방향 0 북 1 동 2 남 3 서 
			boolean clear = false; 
			
			for (int i = 0; i < 4; i++) {
				current.dir = (current.dir + 3) % 4; // 다음 방향
				nx = current.x + dx[current.dir]; // dx {-1, 0, 1, 0};
				ny = current.y + dy[current.dir]; // dy {0, 1, 0, -1};
				
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (map[nx][ny] == 0) { // 다음 이동할 곳이 청소되지 않은 곳이면
						map[nx][ny] = 9;
						queue.add(new Point(nx, ny, current.dir));
						clear = true;
						break;
					}
				}
			}
			
			if (!clear) { // 4방향 다 청소했거나 벽일 경우 후진
				nd = (current.dir + 2) % 4;
				nx = current.x + dx[nd];
				ny = current.y + dy[nd];
				
				if (map[nx][ny] != 1) { // 후진할 곳이 벽이 아니라면 이동
					map[nx][ny] = 9;
					queue.add(new Point(nx, ny, current.dir)); // 방향 그대로
				}
			}
		}
	}

	static class Point {
		int x;
		int y;
		int dir;
		
		Point(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
}
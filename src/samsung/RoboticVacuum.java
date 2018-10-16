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
		
		N = Integer.parseInt(st.nextToken()); // ����
		M = Integer.parseInt(st.nextToken()); // ����
		map = new int[N][M]; // ����
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()); // �������κ��� ������ ĭ�� ��
		int c = Integer.parseInt(st.nextToken()); // �������κ��� ������ ĭ�� ��
		int d = Integer.parseInt(st.nextToken()); // �ٶ󺸴� ����
		
		Point point = new Point(r, c, d); // �κ� û�ұ� ��ǥ
		
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
				if (map[i][j] == 9) { // û���� ���� ����
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
			Point current = queue.poll(); // ���� ��ǥ�� ����
			int nx = 0; // ���� x��ǥ
			int ny = 0; // ���� y��ǥ
			int nd = 0; // ���� ���� 0 �� 1 �� 2 �� 3 �� 
			boolean clear = false; 
			
			for (int i = 0; i < 4; i++) {
				current.dir = (current.dir + 3) % 4; // ���� ����
				nx = current.x + dx[current.dir]; // dx {-1, 0, 1, 0};
				ny = current.y + dy[current.dir]; // dy {0, 1, 0, -1};
				
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (map[nx][ny] == 0) { // ���� �̵��� ���� û�ҵ��� ���� ���̸�
						map[nx][ny] = 9;
						queue.add(new Point(nx, ny, current.dir));
						clear = true;
						break;
					}
				}
			}
			
			if (!clear) { // 4���� �� û���߰ų� ���� ��� ����
				nd = (current.dir + 2) % 4;
				nx = current.x + dx[nd];
				ny = current.y + dy[nd];
				
				if (map[nx][ny] != 1) { // ������ ���� ���� �ƴ϶�� �̵�
					map[nx][ny] = 9;
					queue.add(new Point(nx, ny, current.dir)); // ���� �״��
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
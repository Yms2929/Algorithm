package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class YeonGuSo {
	static int N, M;
	static int[][] map;
	static int[][] copymap;
	static int max = 0;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static List<Point> birus;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copymap = new int[N][M];
		birus = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 2) {
					birus.add(new Point(i, j));
				}
			}
		}
		
		for (int i = 0; i < N * M; i++) {
			int row = i / M;
			int col = i % M;
			
			if (map[row][col] == 0) {
				map[row][col] = 1;
				byuk(i, 1);
				map[row][col] = 0;
			}
		}
		
		System.out.println(max);
	}
	
	public static void byuk(int v, int cnt) {
		int row = v / M;
		int col = v % M;
		
		if (cnt == 3) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copymap[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < birus.size(); i++) {
				Point point = birus.get(i);
				
				spread(point);
			}
			
			int count = count();
			if (max < count) {
				max = count;
			}
		}
		else {
			for (int i = v + 1; i < N * M; i++) {				
				int rr = i / M;
				int cc = i % M;
				
				if (map[rr][cc] == 0) {
					map[rr][cc] = 1;
					byuk(i, cnt + 1);
				}
			}
		}
		
		map[row][col] = 0;
	}
	
	public static void spread(Point point) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(point);
		
		while (!queue.isEmpty()) {
			Point current = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (copymap[nx][ny] == 0) {
						copymap[nx][ny] = 2;
						queue.add(new Point(nx, ny));
					}
				}
			}
		}
	}
	
	public static int count() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copymap[i][j] == 0) {
					count++;
				}
			}
		}
		
		return count;
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
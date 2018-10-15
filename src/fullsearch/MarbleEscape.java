package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MarbleEscape {
	static int N;
	static int M;
	static int MAX = 10;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		char[][] board = new char[N][M]; // 보드
		boolean[][][][] check = new boolean[MAX][MAX][MAX][MAX]; // 탐색 여부
		
		Point red = null; // 빨간 구슬 처음 위치
		Point blue = null; // 파란 구슬 처음 위치
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j); // 보드 입력
				
				if (board[i][j] == 'R') {
					board[i][j] = '.';
					red = new Point(i,j);
				}
				else if (board[i][j] == 'B') {
					board[i][j] = '.';
					blue = new Point(i,j);
				}
			}
		}
		
		BFS(board, check, red, blue);
	}

	public static void BFS(char[][] board, boolean[][][][] check, Point red, Point blue) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int result = -1;
		
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				for (int k = 0; k < MAX; k++) {
					Arrays.fill(check[i][j][k], false);
				}
			}
		}
		
		check[red.x][red.y][blue.x][blue.y] = true;
		
		Queue<Data> queue = new LinkedList<>();
		queue.add(new Data(red, blue, 0));
		
		while (!queue.isEmpty()) {
			Data now = queue.poll();
			Point rPoint = new Point(now.red.x, now.red.y);
			Point bPoint = new Point(now.blue.x, now.blue.y);
			int count = now.count + 1;
			
			if (count > 10) {
				continue; // 10번 넘으면 종료
			}
			
			for (int i = 0; i < 4; i++) { // 4방향 탐색
				Point nextR = new Point(rPoint.x, rPoint.y);
				Point nextB = new Point(bPoint.x, bPoint.y);
				
				while (board[nextR.x + dx[i]][nextR.y + dy[i]] != '#') { // 빨간 구슬 이동
					nextR.x += dx[i];
					nextR.y += dy[i];
					if (board[nextR.x][nextR.y] == 'O') {
						break;
					}
				}
				
				while (board[nextB.x + dx[i]][nextB.y + dy[i]] != '#') { // 파란 구슬 이동
					nextB.x += dx[i];
					nextB.y += dy[i];
					if (board[nextB.x][nextB.y] == 'O') {
						break;
					}
				}
				
				if (board[nextB.x][nextB.y] == 'O') { // 파란 구슬 빠지면
					continue;
				}
				
				if (board[nextR.x][nextR.y] == 'O') { // 빨간 구슬 빠지면
					System.out.println(count);
					return;
				}
				
				if (nextR.x == nextB.x && nextR.y == nextB.y) { // 둘이 겹치면
					if (dx[i] != 0) {
						if (rPoint.x * dx[i] > bPoint.x * dx[i]) {
							nextB.x -= dx[i];
						}
						else {
							nextR.x -= dx[i];
						}
					}
					else {
						if (rPoint.y * dy[i] > bPoint.y * dy[i]) {
							nextB.y -= dy[i];
						}
						else {
							nextR.y -= dy[i];
						}
					}
				}
				
				if (check[nextR.x][nextR.y][nextB.x][nextB.y]) {
					continue;
				}
				
				queue.add(new Data(nextR, nextB, count));
				check[nextR.x][nextR.y][nextB.x][nextB.y] = true;
			}
		}
		
		System.out.println(result);
	}
	
	static class Point { // 좌표값 저장 클래스
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Data { // 빨간 구슬 파란 구슬 저장 클래스
		Point red;
		Point blue;
		int count;
		
		Data(Point red, Point blue, int count) {
			this.red = red;
			this.blue = blue;
			this.count = count;
		}
	}
}
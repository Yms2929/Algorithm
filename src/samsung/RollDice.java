package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RollDice {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 지도의 세로
		int M = Integer.parseInt(st.nextToken()); // 지도의 가로
		int x = Integer.parseInt(st.nextToken()); // 주사위 좌표 x
		int y = Integer.parseInt(st.nextToken()); // 주사위 좌표 y
		int K = Integer.parseInt(st.nextToken()); // 명령의 개수
		int[][] map = new int[N][M]; // 지도
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 지도 입력
			}
		}
		
		int[] order = new int[K]; // 명령어
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken()); // 명령어 입력
		}
		
		int[] dice = new int[7]; // 주사위 면
		int orderCount = K;
		int index = 0;
		int[] dy = {0, 0, -1, 1}; // 동서북남
		int[] dx = {1, -1, 0, 0};
		int cy = x;
		int cx = y;
		
		while (orderCount-- > 0) { // 명령어 개수만큼 반복
			int direct = order[index]; // 현재 명령어
			int temp = 0;
			int ny = 0;
			int nx = 0;
			
			switch (direct) {
			case 1: // 동쪽				
				ny = cy + dy[direct - 1]; // 다음 위치
				nx = cx + dx[direct - 1];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) { // 범위 넘어가면
					break;
				}
				
				temp = dice[3];
				dice[3] = dice[1];
				dice[1] = dice[4];
				dice[4] = dice[6];
				dice[6] = temp;
				dice[2] = dice[2];
				dice[5] = dice[5];
				
				if (map[ny][nx] == 0) {
					map[ny][nx] = dice[6];
				}
				else {
					dice[6] = map[ny][nx];
					map[ny][nx] = 0;
				}
				
				cy = ny;
				cx = nx;
				System.out.println(dice[1] + " ");
				break;
			case 2: // 서쪽				
				ny = cy + dy[direct - 1];
				nx = cx + dx[direct - 1];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
					break;
				}
				
				temp = dice[4];
				dice[4] = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[6];
				dice[6] = temp;
				dice[2] = dice[2];
				dice[5] = dice[5];
				
				if (map[ny][nx] == 0) {
					map[ny][nx] = dice[6];
				}
				else {
					dice[6] = map[ny][nx];
					map[ny][nx] = 0;
				}
				
				cy = ny;
				cx = nx;
				System.out.println(dice[1] + " ");
				break;
			case 3: // 북쪽				
				ny = cy + dy[direct - 1]; 
				nx = cx + dx[direct - 1];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
					break;
				}
				
				temp = dice[2];
				dice[2] = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[6];
				dice[6] = temp;
				dice[3] = dice[3];
				dice[4] = dice[4];
				
				if (map[ny][nx] == 0) {
					map[ny][nx] = dice[6];
				}
				else {
					dice[6] = map[ny][nx];
					map[ny][nx] = 0;
				}
				
				cy = ny;
				cx = nx;
				System.out.println(dice[1] + " ");
				break;
			case 4: // 남쪽				
				ny = cy + dy[direct - 1];
				nx = cx + dx[direct - 1];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
					break;
				}
				
				temp = dice[5];
				dice[5] = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[6];
				dice[6] = temp;
				dice[3] = dice[3];
				dice[4] = dice[4];
				
				if (map[ny][nx] == 0) { // 다음 이동할 위치가 0이면
					map[ny][nx] = dice[6];
				}
				else { // 다음 이동할 위치가 0이 아니면
					dice[6] = map[ny][nx];
					map[ny][nx] = 0;
				}
				
				cy = ny; // 현재 위치 저장
				cx = nx;
				System.out.println(dice[1] + " ");
				break;
			}
			
			index++;
		}		
	}
	
}
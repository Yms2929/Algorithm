package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RollDice {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // ������ ����
		int M = Integer.parseInt(st.nextToken()); // ������ ����
		int x = Integer.parseInt(st.nextToken()); // �ֻ��� ��ǥ x
		int y = Integer.parseInt(st.nextToken()); // �ֻ��� ��ǥ y
		int K = Integer.parseInt(st.nextToken()); // ����� ����
		int[][] map = new int[N][M]; // ����
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // ���� �Է�
			}
		}
		
		int[] order = new int[K]; // ��ɾ�
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken()); // ��ɾ� �Է�
		}
		
		int[] dice = new int[7]; // �ֻ��� ��
		int orderCount = K;
		int index = 0;
		int[] dy = {0, 0, -1, 1}; // �����ϳ�
		int[] dx = {1, -1, 0, 0};
		int cy = x;
		int cx = y;
		
		while (orderCount-- > 0) { // ��ɾ� ������ŭ �ݺ�
			int direct = order[index]; // ���� ��ɾ�
			int temp = 0;
			int ny = 0;
			int nx = 0;
			
			switch (direct) {
			case 1: // ����				
				ny = cy + dy[direct - 1]; // ���� ��ġ
				nx = cx + dx[direct - 1];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) { // ���� �Ѿ��
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
			case 2: // ����				
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
			case 3: // ����				
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
			case 4: // ����				
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
				
				if (map[ny][nx] == 0) { // ���� �̵��� ��ġ�� 0�̸�
					map[ny][nx] = dice[6];
				}
				else { // ���� �̵��� ��ġ�� 0�� �ƴϸ�
					dice[6] = map[ny][nx];
					map[ny][nx] = 0;
				}
				
				cy = ny; // ���� ��ġ ����
				cx = nx;
				System.out.println(dice[1] + " ");
				break;
			}
			
			index++;
		}		
	}
	
}
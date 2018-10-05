package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlockNumber {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] x = {0, -1, 0, 1};
	static int[] y = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // ������ ũ��
		
		map = new int[N][N]; // ������ ��Ÿ�� 2���� �迭
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		
		List<Integer> list = new ArrayList<Integer>();
		int total = 0; // ������ ��
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					total++;
					int count = DFS(i, j, 0); // ���� ������ ���� ����
					list.add(count);
				}
			}
		}
		
		Collections.sort(list); // �������� ����
		
		System.out.println(total);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static int DFS(int row, int col, int count) {
		count++; // ���� �� ����
		visited[row][col] = true; // �湮 ǥ��
		
		for (int i = 0; i < 4; i++) {
			int nextRow = row + x[i];
			int nextCol = col + y[i];
			
			if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < N) {
				if (map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
					count = DFS(nextRow, nextCol, count);
				}
			}		
		}
		
		return count;
	}

}
package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ChickenDelivery {
	static int N, M;
	static int[][] city;
	static boolean[] visited;
	static int[] output;
	static List<Point> houseList;
	static List<Point> chickenList;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		city = new int[N][N];
		houseList = new ArrayList<>();
		chickenList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				
				if (city[i][j] == 1) {
					houseList.add(new Point(i, j)); // �� ��ǥ ����
				}
				else if (city[i][j] == 2) {
					chickenList.add(new Point(i, j)); // ġŲ �� ��ǥ ����
				}
			}
		}
		
		visited = new boolean[chickenList.size()];
		output = new int[chickenList.size()];
		
		for (int i = 0; i < chickenList.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				DFS(i, 0);
				visited[i] = false;
			}
		}
		
		System.out.println(result);
	}
	
	public static void DFS(int start, int depth) {
		output[depth] = start + 1; // 0 1  1
		
		for (int i = start; i < chickenList.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				DFS(i, depth + 1);
				visited[i] = false; // ��Ʈ��ŷ
			}
		}
			
		if (depth == M - 1) {
			int sum = 0;
			int distance = 0;
			
			/*for (int i = 0; i < M; i++) {
				System.out.print(chickenList.get(output[i] - 1).x + "," + chickenList.get(output[i]-1).y + " ");
			}*/
			
			for (int i = 0; i < houseList.size(); i++) {
				int min = Integer.MAX_VALUE;
				
				for (int j = 0; j < M; j++) { // ġŲ�� �� ��ŭ
					// ���� ġŲ���� �Ÿ� ���ϱ�
					distance = distance(houseList.get(i), chickenList.get(output[j] - 1));	
					min = Math.min(min, distance); // ġŲ �Ÿ� �ּҰ�
				}
				
				sum += min; // ġŲ �Ÿ� ��
			}
			
			result = Math.min(result, sum); // ������ ġŲ �Ÿ� �ּҰ�
		}
	}
	
	public static int distance(Point p1, Point p2) { // ġŲ �Ÿ�
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
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
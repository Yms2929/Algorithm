package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class WaterBottle {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		boolean[][] check = new boolean[A + 1][B + 1];
		BFS(A, B, C, check);
	}
	
	public static void BFS(int A, int B, int C, boolean[][] check) {
		Queue<Water> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		
		check[0][0] = true;
		queue.add(new Water(0, 0, C));
		
		while (!queue.isEmpty()) {
			Water water = queue.poll();
			int a = water.getA(); // 현재 각 물통에 들어 있는 양
			int b = water.getB();
			int c = C - a - b;
			
			if (a == 0) { // 첫번째 물통이 비었을 때 세번째 물통에 들어 있는 양 저장
				list.add(c);
			}
			
			if (a > 0) { // a에서 b로 옮길 때
				int input = a + b <= B ? a : B - b;
				if (!check[a - input][b + input]) {
					queue.add(new Water(a - input, b + input, c));
					check[a - input][b + input] = true;
				}
				
				if (!check[0][C - a - c]) { // a에서 c로 옮길 때
					queue.add(new Water(0, C - a - c, c));
					check[0][C - a - c] = true;
				}
			}
			
			if (b > 0) { // b에서 a로 옮길 때
				int input = a + b <= A ? b : A - a;
				if (!check[a + input][b - input]) {
					queue.add(new Water(a + input, b - input, c));
					check[a + input][b - input] = true;
				}
				
				if (!check[a][0]) { // b에서 c로 옮길 때
					queue.add(new Water(a, 0, c));
					check[a][0] = true;
				}
			}
			
			if (c > 0) { // c에서 a로 옮길 때
				int input = c + a <= A ? c : A - a;
				if (!check[a + input][C - a - c]) {
					queue.add(new Water(a + input, C - a - c, c));
					check[a + input][C - a - c] = true;
				}
				
				input = c + b <= B ? c : B - b; // c에서 b로 옮길 때
				if (!check[a][b + input]) {
					queue.add(new Water(a, b + input, c));
					check[a][b + input] = true;
				}
			}
		}
		
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	
	static class Water {
		private int a;
		private int b;
		private int c;
		
		public Water(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		public int getA() {
			return this.a;
		}
		
		public int getB() {
			return this.b;
		}
		
		public int getC() {
			return this.c;
		}
	}

}
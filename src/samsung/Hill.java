package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hill {
	static int N, L;
	static int[][] map, map2;
	static int[] hill;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		map2 = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				map2[j][i] = map[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			findHill(i, map);
			findHill(i, map2);
		}

		System.out.println(count);
	}

	public static void findHill(int index, int[][] map) {
		hill = new int[N];
		
		for (int i = 0; i < N - 1; i++) {
			if (map[index][i] != map[index][i+1]) {
				int sub = map[index][i] - map[index][i+1]; 
				
				if (sub != -1 && sub != 1) {
					return;
				}
				if (sub == -1) {
					for (int j = 0; j < L; j++) {
						if (i - j < 0 || hill[i - j] == 1) {
							return;
						}
						if (map[index][i] == map[index][i - j]) {
							hill[i - j] = 1;
						}
						else {
							return;
						}
					}
				}
				else {
					for (int j = 1; j <= L; j++) {
						if (i + j >= N || hill[i + j] == 1) {
							return;
						}
						if (map[index][i] - 1 == map[index][i + j]) {
							hill[i + j] = 1;
						}
						else {
							return;
						}
					}
				}
			}
		}
		
		count++;
	}
}
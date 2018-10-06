package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeCut {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 나무의 수
		int M = Integer.parseInt(st.nextToken()); // 가져가려는 나무의 길이
		int[] trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees); // 10 15 17 20
		
		int max = trees[N-1]; // 20
		int min = 0;
		int middle = 0;
		
		while (min <= max) {
			middle = (min + max) / 2;
			
			long sum = 0;
			
			for (int i = 0; i < N; i++) {
				if (trees[i] - middle > 0) {
					sum += trees[i] - middle;
				}
			}
			
			if (sum >= M) {
				min = middle + 1;
			}
			else if (sum < M) {
				max = middle - 1;
			}
		}
		
		System.out.println(max);
	}

}
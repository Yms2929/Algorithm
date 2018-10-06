package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ModemInstall {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] house = new int[N];
		
		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house); // 오름차순 정렬
		
		int max = house[N-1] - house[0]; // 가능한 최대 거리
		int min = 1; // 가능한 최소 거리
		int result = 0;
		
		while (min <= max) {
			int middle = (min + max) / 2;
			int start = house[0];
			int count = 1;
			
			for (int i = 1; i < N; i++) {
				if (house[i] - start >= middle) {
					count++;
					start = house[i];
				}
			}
			
			if (count >= C) { // 실제 설치해야할 공유기 수 보다 더 많이 설치하면 간격 늘려야함
				result = middle;
				min = middle + 1; // 오른쪽에서 찾기
			}
			else if (count < C) {
				max = middle - 1; // 왼쪽에서 찾기
			}
		}
		
		System.out.println(result);
	}

}
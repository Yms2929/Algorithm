package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CableCut {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
		int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
		int[] cables = new int[K]; // 이미 가지고 있는 각 랜선의 길이

		for (int i = 0; i < K; i++) {
			cables[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(cables); // 정렬

		long max = cables[K - 1];
		long min = 1;
		long middle = 0;

		while (max >= min) {
			middle = (max + min) / 2;

			long sum = 0;

			for (int i = 0; i < K; i++) {
				sum += cables[i] / middle;
			}

			if (sum >= N) {
				min = middle + 1;
			}

			else if (sum < N) {
				max = middle - 1;
			}
		}
		
		System.out.println(max);
	}

}
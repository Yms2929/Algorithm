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

		int K = Integer.parseInt(st.nextToken()); // �̹� ������ �ִ� ������ ����
		int N = Integer.parseInt(st.nextToken()); // �ʿ��� ������ ����
		int[] cables = new int[K]; // �̹� ������ �ִ� �� ������ ����

		for (int i = 0; i < K; i++) {
			cables[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(cables); // ����

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
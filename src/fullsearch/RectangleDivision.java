package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RectangleDivision {
	static int[][] rectangle;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		rectangle = new int[N][M]; // 처음 직사각형

		for (int i = 0; i < N; i++) { // 직사각형에 숫자 입력
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				rectangle[i][j] = temp.charAt(j) - '0';
			}
		}

		long max = 0;
		// 1번 case N = 1 M = 8
		for (int i = 0; i < M - 2; i++) {
			for (int j = i + 1; j < M - 1; j++) {
				long a = sum(0, 0, i, N - 1);
				long b = sum(i + 1, 0, j, N - 1);
				long c = sum(j + 1, 0, M - 1, N - 1);

				if (max < a * b * c) {
					max = a * b * c;
				}
			}
		}

		// 2번 case
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				long a = sum(0, 0, M - 1, i);
				long b = sum(0, i + 1, M - 1, j);
				long c = sum(0, j + 1, M - 1, N - 1);

				if (max < a * b * c) {
					max = a * b * c;
				}
			}
		}

		// 3번 case
		for (int i = 0; i < M - 1; i++) {
			for (int j = 0; j < N - 1; j++) {
				long a = sum(0, 0, i, N - 1);
				long b = sum(i + 1, 0, M - 1, j);
				long c = sum(i + 1, j + 1, M - 1, N - 1);

				if (max < a * b * c) {
					max = a * b * c;
				}
			}
		}

		// 4번 case
		for (int i = M - 1; i > 0; i--) {
			for (int j = 0; j < N - 1; j++) {
				long a = sum(i, 0, M - 1, N - 1);
				long b = sum(0, 0, i - 1, j);
				long c = sum(0, j + 1, i - 1, N - 1);

				if (max < a * b * c) {
					max = a * b * c;
				}
			}
		}

		// 5번 case
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				long a = sum(0, 0, M - 1, i);
				long b = sum(0, i + 1, j, N - 1);
				long c = sum(j + 1, i + 1, M - 1, N - 1);

				if (max < a * b * c) {
					max = a * b * c;
				}
			}
		}

		// 6번 case
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < M - 1; j++) {
				long a = sum(0, i, M - 1, N - 1);
				long b = sum(0, 0, j, i - 1);
				long c = sum(j + 1, 0, M - 1, i - 1);

				if (max < a * b * c) {
					max = a * b * c;
				}
			}
		}

		System.out.println(max);
	}

	public static long sum(int sx, int sy, int ex, int ey) {
		long sum = 0; // 1 0 2 0

		for (int i = sy; i <= ey; i++) {
			for (int j = sx; j <= ex; j++) {
				sum += rectangle[i][j];
			}
		}

		return sum;
	}

}
package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumNumbers {
	static int N, M;
	static int[] A;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		getSum();
		
		System.out.println(count);
	}

	public static void getSum() {
		int start = 0;
		int end = 0;
		int sum = 0;
		
		while (true) {
			if (sum >= M) {
				sum -= A[start];
				start++;
			}
			else if (end == N) {
				break;
			}
			else if (sum < M) {
				sum += A[end];
				end++;
			}
			if (sum == M) {
				count++;
			}
		}
	}
}
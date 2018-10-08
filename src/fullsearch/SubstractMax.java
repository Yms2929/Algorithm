package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubstractMax {
	static int N;
	static int[] A;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 정수의 개수
		A = new int[N]; // 정수를 담을 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); // 정수 입력
		}
		
		getMax(0);
		System.out.println(max);
	}
	
	// 재귀로 자리를 계속 바꿔가며 최대값을 찾는다
	public static void getMax(int depth) {
		if (depth == N) { // 뎊스가 N이면 완료
			return;
		}
		
		for (int i = depth; i < N; i++) {
			swap(depth, i); // 배열의 자리를 바꿔준다
			getMax(depth + 1); // 뎊스를 늘려가며 재귀 호출
			
			int sum = sum(); // 식에 대입하여 합 구하기
			if (max < sum) { // 최대값 구하기
				max = sum;
			}
			
			swap(depth, i); // 재귀 호출 전에 자리를 원상복귀
		}
	}
	
	public static void swap(int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static int sum() {
		int sum = 0;
		
		for (int i = 0; i < N - 1; i++) {
			sum += Math.abs(A[i] - A[i+1]);
		}
		
		return sum;
	}

}
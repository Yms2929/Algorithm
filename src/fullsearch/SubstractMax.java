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
		
		N = Integer.parseInt(br.readLine()); // ������ ����
		A = new int[N]; // ������ ���� �迭
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); // ���� �Է�
		}
		
		getMax(0);
		System.out.println(max);
	}
	
	// ��ͷ� �ڸ��� ��� �ٲ㰡�� �ִ밪�� ã�´�
	public static void getMax(int depth) {
		if (depth == N) { // �X���� N�̸� �Ϸ�
			return;
		}
		
		for (int i = depth; i < N; i++) {
			swap(depth, i); // �迭�� �ڸ��� �ٲ��ش�
			getMax(depth + 1); // �X���� �÷����� ��� ȣ��
			
			int sum = sum(); // �Ŀ� �����Ͽ� �� ���ϱ�
			if (max < sum) { // �ִ밪 ���ϱ�
				max = sum;
			}
			
			swap(depth, i); // ��� ȣ�� ���� �ڸ��� ���󺹱�
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
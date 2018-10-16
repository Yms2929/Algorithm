package fullsearch;

import java.util.Scanner;

public class ExamSupervisor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = Integer.parseInt(scanner.nextLine()); // ������ ����
		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = scanner.nextInt(); // �� ������ �������� ��
		}

		int B = scanner.nextInt(); // �� �������� ������ �� �ִ� �������� ��
		int C = scanner.nextInt(); // �� �������� ������ �� �ִ� �������� ��

		long count = 0; // �������� ������ �����ڰ� ���� B,C�� ������ long���� �ؾ���

		for (int i = 0; i < N; i++) {
			if (A[i] > 0) { // �� ������
				count++;
				A[i] -= B;
			}
			
			if (A[i] > 0) { // �� ������
				if (A[i] % C == 0) { // ��������
					count += A[i] / C; // ���� �����ش�
				}
				else {
					count += A[i] / C + 1; // �ƴϸ� �� +1 �����ش�
				}
			}
		}

		System.out.println(count);
	}

}
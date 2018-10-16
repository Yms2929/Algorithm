package fullsearch;

import java.util.Scanner;

public class ExamSupervisor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = Integer.parseInt(scanner.nextLine()); // 시험장 개수
		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = scanner.nextInt(); // 각 시험장 응시자의 수
		}

		int B = scanner.nextInt(); // 총 감독관이 감시할 수 있는 응시자의 수
		int C = scanner.nextInt(); // 부 감독관이 감시할 수 있는 응시자의 수

		long count = 0; // 시험장의 개수와 응시자가 많고 B,C가 적으면 long으로 해야함

		for (int i = 0; i < N; i++) {
			if (A[i] > 0) { // 총 감독관
				count++;
				A[i] -= B;
			}
			
			if (A[i] > 0) { // 부 감독관
				if (A[i] % C == 0) { // 나눠지면
					count += A[i] / C; // 몫을 더해준다
				}
				else {
					count += A[i] / C + 1; // 아니면 몫에 +1 더해준다
				}
			}
		}

		System.out.println(count);
	}

}
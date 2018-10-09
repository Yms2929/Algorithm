package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrimeNumberRoute {
	static int[] visited = new int[10000];
	static boolean[] prime = new boolean[10000];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		getPrime();
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
		
			if (A == B) {
				System.out.println(0);
				continue;
			}
			
			Arrays.fill(visited, -1);
			
			int count = BFS(A, B);
			
			if (count == -1) {
				System.out.println("Impossible");
			}
			else {
				System.out.println(count);
			}
		}
		
		br.close();
		
	}
	
	// 4�ڸ� ���ڵ� �� �Ҽ��� ���ϴ� �����佺�׳׽��� ü
	public static void getPrime() {
		for (int i = 2; i < 10000; i++) {
			if (prime[i] == false) {
				for (int j = i*2; j < 10000; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		for (int i = 0; i < 10000; i++) {
			prime[i] = !prime[i];
		}
	}
	
	public static int BFS(int A, int B) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(A);
		visited[A] = 0;
		
		while (!queue.isEmpty()) {
			int number = queue.poll();
			
			if (number == B) {
				return visited[number];
			}
			
			int[] temp = new int[4];
			
			for (int i = 0; i < 4; i++) { // 4�ڸ� ���ڸ� �ϳ��� �ڸ���
				temp[0] = number / 1000;
				temp[1] = (number / 100) % 10;
				temp[2] = (number / 10) % 10;
				temp[3] = number % 10;
				
				for (int j = 0; j < 10; j++) {
					if (i != 0 || j != 0) { // õ�� �ڸ��� 0�̰ų� ���� ���ڿ� �ٲٴ� ���ڶ� ���� �� ����
						if (temp[i] != j) {
							temp[i] = temp[i] + 1 > 9 ? 0 : temp[i] + 1;
							
							int nextNumber = 0;
							
							nextNumber += temp[0] * 1000; // �ٲ� ���ڸ� �ٽ� 4�ڸ� ���ڷ� �����
							nextNumber += temp[1] * 100;
							nextNumber += temp[2] * 10;
							nextNumber += temp[3];
							
							if (1000 <= nextNumber && prime[nextNumber] && visited[nextNumber] == -1) {
								queue.add(nextNumber);
								visited[nextNumber] = visited[number] + 1; // BFS ��� ���Ҵ��� Ƚ�� ����
							}
						}
					}
				}
			}
		}
		
		return -1;
	}

}
package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class StartAndLink {
	static int N;
	static int[][] S;
	static boolean[] visited;
	static List<Integer> subList = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // ��� ��
		S = new int[N + 1][N + 1]; // �ɷ�ġ
		visited = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) { // �ɷ�ġ �Է�
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0, 0);
		
		Collections.sort(subList); // ����
		
		System.out.println(subList.get(0)); // �ּҰ� ���
	}

	public static void DFS(int v, int len) {
		if (N / 2 == len) { // N/2 �� �� ������
			divideTeam();
		}
		else {
			for (int i = v + 1; i <= N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					DFS(i, len + 1);
				}
			}
		}
		
		visited[v] = false; // ��Ʈ��ŷ
	}
	
	public static void divideTeam() {
		int[] startTeam = new int[N / 2 + 1]; // ���� ������
		int[] linkTeam = new int[N / 2 + 1];
		
		int start = 1;
		int link = 1;
		
		for (int i = 1; i <= N; i++) {
			if (visited[i]) {
				startTeam[start] = i; // ����� ��ȣ�� ������
				start++;
			}
			else {
				linkTeam[link] = i;
				link++;
			}
		}
		
		int startSum = getSum(startTeam); // �������� �ɷ�ġ �� ���ϱ�
		int linkSum = getSum(linkTeam);
		
		subList.add(Math.abs(startSum - linkSum)); // �� �� �ɷ�ġ ����
	}
	
	public static int getSum(int[] team) {
		int sum = 0;
		
		for (int i = 1; i <= N / 2; i++) {
			for (int j = i + 1; j <= N / 2; j++) {
				sum += S[team[i]][team[j]]; // �ɷ�ġ �� ���ϱ�
				sum += S[team[j]][team[i]];
			}
		}
		
		return sum;
	}
}
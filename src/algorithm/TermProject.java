package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TermProject {
	static int[] number;
	static int[] check;
	static int[] started;
	
	public static int DFS(int v, int cnt, int start) {		
		if (check[v] != 0) { // �̹� �湮�ߴ� �����̰�
			if (start != started[v]) { // ���������� start�� �ٸ��� ����Ŭ ���� �����̹Ƿ� 0����
				return 0;
			}
			return cnt - check[v]; // ���°�� �湮�� �������� ����
		}
		
		check[v] = cnt;
		started[v] = start;
		return DFS(number[v], cnt+1, start);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽� ����
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine()); // �л��� ��
			number = new int[n+1]; // ���õ� �л��� ��ȣ
			check = new int[n+1]; // �湮 üũ (���ۿ��� ���°�� �湮�Ǵ���)
			started = new int[n+1]; // ��������
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= n; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			
			int count = 0;
			for (int i = 1; i <= n; i++) {
				if(check[i] == 0) {
					count += DFS(i, 1, i);
				}
			}
			
			System.out.println(n - count);
		}
	}

}
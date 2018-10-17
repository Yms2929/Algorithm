package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Cogwheel {
	static LinkedList<Integer>[] list = (LinkedList<Integer>[]) new LinkedList[5];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i <= 4; i++) {
			list[i] = new LinkedList<>(); // 1�� ��Ϲ������� 4�� ��Ϲ������� ����Ʈ
			String str = br.readLine();
			
			for (int j = 0; j < 8; j++) {
				list[i].add(str.charAt(j) - '0'); // �� ����Ʈ�� ���� ����
			}
		}
		
		int K = Integer.parseInt(br.readLine()); // ȸ�� Ƚ��
		while (K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // ��Ϲ��� ��ȣ
			int d = Integer.parseInt(st.nextToken()); // ȸ�� ����
			
			left(n - 1, -d); // ���� �˻�
			right(n + 1, -d); // ������ �˻�
			rotate(n, d); // �ڱ� �ڽ� ȸ��
		}
		
		int score = 0;
		for (int i = 1; i < list.length; i++) {
			if (list[i].get(0) == 0) {
				score += 0;
			}
			else {
				if (i == 1) score += 1;
				else if (i == 2) score += 2;
				else if (i == 3) score += 4;
				else if (i == 4) score += 8;
			}
		}
		
		System.out.println(score);
	}
	
	public static void left(int n, int direction) {
		if (!(1 <= n && n <= 4)) {
			return;
		}
		
		if (check(n, n + 1)) { // ���� ��Ϲ��� �˻�
			left(n - 1, -direction);
			rotate(n, direction);
		}
	}
	
	public static void right(int n, int direction) {
		if (!(1 <= n && n <= 4)) { // ���� �����
			return;
		}
		
		if (check(n, n - 1)) { // ������ ��Ϲ��� �˻�
			right(n + 1, -direction);
			rotate(n, direction);
		}
	}
	
	public static void rotate(int n, int direction) {
		if (direction == 1) { // �ð� ����
			list[n].addFirst(list[n].pollLast()); // �� �ڿ� ���� ���� �� �տ� �߰���
		}
		else { // �ݽð� ����
			list[n].addLast(list[n].pollFirst()); // �� ���� ���� ���� �� �ڿ� �߰���
		}
	}
	
	public static boolean check(int a, int b) { // ȸ�� ���� üũ
		if (a > b) {
			if (list[a].get(6) == list[b].get(2)) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			if (list[a].get(2) == list[b].get(6)) {
				return false;
			}
			else {
				return true;
			}
		}
	}
}
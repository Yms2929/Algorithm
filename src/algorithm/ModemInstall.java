package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ModemInstall {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] house = new int[N];
		
		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house); // �������� ����
		
		int max = house[N-1] - house[0]; // ������ �ִ� �Ÿ�
		int min = 1; // ������ �ּ� �Ÿ�
		int result = 0;
		
		while (min <= max) {
			int middle = (min + max) / 2;
			int start = house[0];
			int count = 1;
			
			for (int i = 1; i < N; i++) {
				if (house[i] - start >= middle) {
					count++;
					start = house[i];
				}
			}
			
			if (count >= C) { // ���� ��ġ�ؾ��� ������ �� ���� �� ���� ��ġ�ϸ� ���� �÷�����
				result = middle;
				min = middle + 1; // �����ʿ��� ã��
			}
			else if (count < C) {
				max = middle - 1; // ���ʿ��� ã��
			}
		}
		
		System.out.println(result);
	}

}
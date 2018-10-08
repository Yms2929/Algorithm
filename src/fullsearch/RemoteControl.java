package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RemoteControl {
	static boolean[] broken = new boolean[10];
	
	public static int getCount(int channel) {
		int length = 0;
		
		if (channel == 0) {
			return broken[0] ? 0 : 1;
		}
		
		while (channel > 0) {
			if (broken[channel % 10]) {
				return 0;
			}
			length += 1;
			channel /= 10;
		}
		
		return length;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int channel = 100; // ó�� ���� �ִ� ä��
		int N = Integer.parseInt(br.readLine()); // �̵��Ϸ��� ä��
		
		int M = Integer.parseInt(br.readLine()); // ���峭 ��ư�� ����
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			broken[Integer.parseInt(st.nextToken())] = true; // ��ư�� ������ ������ true �ƴϸ� false
		}
		
		int count = N - channel; // 100���� N���� ���� ��ư ���� +-�� ������ �̵�
		if (count < 0) {
			count = -count;
		}
		
		for (int i = 0; i <= 1000000; i++) { // ���� ��ư���� �̵�
			int c = i;
			int length = getCount(i); // ���̸� ���
			
			if (length > 0) {
				int press = c - N; // +- ������ �ϴ� Ƚ��
				if (press < 0) {
					press = -press;
				}
				if (count > length + press) {
					count = length + press;
				}
			}
		}
		
		System.out.println(count);
	}
}
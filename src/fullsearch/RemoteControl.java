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
		int channel = 100; // 처음 보고 있는 채널
		int N = Integer.parseInt(br.readLine()); // 이동하려는 채널
		
		int M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			broken[Integer.parseInt(st.nextToken())] = true; // 버튼이 망가져 있으면 true 아니면 false
		}
		
		int count = N - channel; // 100에서 N까지 숫자 버튼 말고 +-만 눌러서 이동
		if (count < 0) {
			count = -count;
		}
		
		for (int i = 0; i <= 1000000; i++) { // 숫자 버튼으로 이동
			int c = i;
			int length = getCount(i); // 길이를 잰다
			
			if (length > 0) {
				int press = c - N; // +- 눌러야 하는 횟수
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
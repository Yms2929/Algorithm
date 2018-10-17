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
			list[i] = new LinkedList<>(); // 1번 톱니바퀴부터 4번 톱니바퀴까지 리스트
			String str = br.readLine();
			
			for (int j = 0; j < 8; j++) {
				list[i].add(str.charAt(j) - '0'); // 각 리스트에 숫자 저장
			}
		}
		
		int K = Integer.parseInt(br.readLine()); // 회전 횟수
		while (K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 톱니바퀴 번호
			int d = Integer.parseInt(st.nextToken()); // 회전 방향
			
			left(n - 1, -d); // 왼쪽 검사
			right(n + 1, -d); // 오른쪽 검사
			rotate(n, d); // 자기 자신 회전
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
		
		if (check(n, n + 1)) { // 왼쪽 톱니바퀴 검사
			left(n - 1, -direction);
			rotate(n, direction);
		}
	}
	
	public static void right(int n, int direction) {
		if (!(1 <= n && n <= 4)) { // 범위 벗어나면
			return;
		}
		
		if (check(n, n - 1)) { // 오른쪽 톱니바퀴 검사
			right(n + 1, -direction);
			rotate(n, direction);
		}
	}
	
	public static void rotate(int n, int direction) {
		if (direction == 1) { // 시계 방향
			list[n].addFirst(list[n].pollLast()); // 맨 뒤에 것을 빼서 맨 앞에 추가함
		}
		else { // 반시계 방향
			list[n].addLast(list[n].pollFirst()); // 맨 앞의 것을 빼서 맨 뒤에 추가함
		}
	}
	
	public static boolean check(int a, int b) { // 회전 여부 체크
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
package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DragonCurve {
	static int[][] map = new int[101][101];
	static int[] dy = {0, -1, 0, 1, 1}; // 0(��) 1(��) 2(��) 3(��) 4(�밢���Ʒ�)
	static int[] dx = {1, 0, -1, 0, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // �巡��Ŀ���� ����
		int[][] curveInfo = new int[N][4]; // ���� ��
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				curveInfo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		curve(curveInfo);
	}
	
	public static void curve(int[][] curveInfo) {
		for (int i = 0; i < curveInfo.length; i++) { // Ŀ�� �� ��ŭ
			List<Integer> direction = new ArrayList<>();
			direction.add(curveInfo[i][2]); // ���� ��������
			
			for (int j = 0; j < curveInfo[i][3]; j++) { // ���븸ŭ
				int size = direction.size();
				
				for (int k = size - 1; k >= 0; k--) { // �Ųٷ� ���
					int n = direction.get(k); // ���������� �������������
					
					if (n == 3) { // 3������ 0
						direction.add(0);
					}
					else { // �������� +1
						direction.add(n + 1);
					}
				}
			}
			
			draw(curveInfo[i][0], curveInfo[i][1], direction);
		}
		
		count();
	}
	
	public static void draw(int x, int y, List<Integer> direction) {
		map[y][x] = 1;
		
		for (int i = 0; i < direction.size(); i++) { // ���� ���� ��ŭ �̵��ϸ� üũ
			y = y + dy[direction.get(i)];
			x = x + dx[direction.get(i)];
			map[y][x] = 1;
		}
	}
	
	public static void count() {
		int result = 0;
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1 && map[i + dy[0]][j + dx[0]] == 1 && map[i + dy[3]][j + dx[3]] == 1 && map[i + dy[4]][j + dx[4]] == 1) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}

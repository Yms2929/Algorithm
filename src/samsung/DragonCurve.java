package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DragonCurve {
	static int[][] map = new int[101][101];
	static int[] dy = {0, -1, 0, 1, 1}; // 0(우) 1(상) 2(좌) 3(하) 4(대각선아래)
	static int[] dx = {1, 0, -1, 0, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 드래곤커브의 개수
		int[][] curveInfo = new int[N][4]; // 시작 점
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				curveInfo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		curve(curveInfo);
	}
	
	public static void curve(int[][] curveInfo) {
		for (int i = 0; i < curveInfo.length; i++) { // 커브 수 만큼
			List<Integer> direction = new ArrayList<>();
			direction.add(curveInfo[i][2]); // 방향 가져오기
			
			for (int j = 0; j < curveInfo[i][3]; j++) { // 세대만큼
				int size = direction.size();
				
				for (int k = size - 1; k >= 0; k--) { // 거꾸로 계산
					int n = direction.get(k); // 이전세대의 마지막방향부터
					
					if (n == 3) { // 3다음은 0
						direction.add(0);
					}
					else { // 나머지는 +1
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
		
		for (int i = 0; i < direction.size(); i++) { // 방향 갯수 만큼 이동하며 체크
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

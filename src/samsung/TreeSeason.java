package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeSeason {
	static int N; // 땅의 크기
	static int M; // 나무의 개수
	static int K; // 지나간 년도
	static int[][] forest; // 땅
	static int[][] food; // 양분
	static int[] dx = { 1, 1, 1, 0, 0, -1, -1, -1 };
	static int[] dy = { 1, 0, -1, 1, -1, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		forest = new int[N][N];
		food = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				food[i][j] = Integer.parseInt(st.nextToken()); // 추가되는 양분
				forest[i][j] = 5; // 최초 양분 5로 초기화
			}
		}

		LinkedList<Tree> treeList = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			treeList.add(new Tree(x - 1, y - 1, age, 1)); // 1부터 시작하므로 -1해준다
		}

		for (int k = 0; k < K; k++) { // K년동안 반복
			LinkedList<Tree> newTreeList = new LinkedList<>();

			// 봄
			for (Tree t : treeList) {
				if (forest[t.x][t.y] >= t.age) {
					forest[t.x][t.y] -= t.age; // 자신의 나이만큼 양분을 먹는다
					t.age++; // 나이 1 증가
				} else {
					t.life = 0; // 양분이 나이보다 부족해서 먹을 수 없으면 죽는다
				}
			}

			// 여름
			for (Iterator<Tree> iterator = treeList.iterator(); iterator.hasNext();) {
				Tree t = iterator.next();
				if (t.life == 0) { // 봄에 죽은 나무
					forest[t.x][t.y] += t.age / 2; // 나이/2 만큼 땅에 추가
					iterator.remove(); // 나무 제거
				}
			}

			// 가을
			for (Tree t : treeList) {
				if (t.age % 5 == 0) { // 나이가 5의 배수인 경우
					for (int j = 0; j < 8; j++) { // 인접한 8칸에
						int nx = t.x + dx[j];
						int ny = t.y + dy[j];
						if (-1 < nx && nx < N && -1 < ny && ny < N) { // 땅을 벗어나지 않으면
							newTreeList.add(new Tree(nx, ny, 1, 1)); // 나이가 1인 나무 추가
						}
					}
				}
			}
			treeList.addAll(0, newTreeList);

			// 겨울
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					forest[i][j] += food[i][j]; // 땅에 양분을 추가한다
				}
			}

			if (k == K - 1) {
				System.out.println(treeList.size());
				return;
			}
		}

	}
	
	static class Tree {
		int x;
		int y;
		int age;
		int life;

		public Tree(int x, int y, int age, int life) {
			this.x = x;
			this.y = y;
			this.age = age;
			this.life = life;
		}
	}
}
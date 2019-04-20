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
	static int N; // ���� ũ��
	static int M; // ������ ����
	static int K; // ������ �⵵
	static int[][] forest; // ��
	static int[][] food; // ���
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
				food[i][j] = Integer.parseInt(st.nextToken()); // �߰��Ǵ� ���
				forest[i][j] = 5; // ���� ��� 5�� �ʱ�ȭ
			}
		}

		LinkedList<Tree> treeList = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			treeList.add(new Tree(x - 1, y - 1, age, 1)); // 1���� �����ϹǷ� -1���ش�
		}

		for (int k = 0; k < K; k++) { // K�⵿�� �ݺ�
			LinkedList<Tree> newTreeList = new LinkedList<>();

			// ��
			for (Tree t : treeList) {
				if (forest[t.x][t.y] >= t.age) {
					forest[t.x][t.y] -= t.age; // �ڽ��� ���̸�ŭ ����� �Դ´�
					t.age++; // ���� 1 ����
				} else {
					t.life = 0; // ����� ���̺��� �����ؼ� ���� �� ������ �״´�
				}
			}

			// ����
			for (Iterator<Tree> iterator = treeList.iterator(); iterator.hasNext();) {
				Tree t = iterator.next();
				if (t.life == 0) { // ���� ���� ����
					forest[t.x][t.y] += t.age / 2; // ����/2 ��ŭ ���� �߰�
					iterator.remove(); // ���� ����
				}
			}

			// ����
			for (Tree t : treeList) {
				if (t.age % 5 == 0) { // ���̰� 5�� ����� ���
					for (int j = 0; j < 8; j++) { // ������ 8ĭ��
						int nx = t.x + dx[j];
						int ny = t.y + dy[j];
						if (-1 < nx && nx < N && -1 < ny && ny < N) { // ���� ����� ������
							newTreeList.add(new Tree(nx, ny, 1, 1)); // ���̰� 1�� ���� �߰�
						}
					}
				}
			}
			treeList.addAll(0, newTreeList);

			// �ܿ�
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					forest[i][j] += food[i][j]; // ���� ����� �߰��Ѵ�
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
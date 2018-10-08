package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TravelingSalesmanProblem {
	static int N;
	static int[][] cost;
	//static boolean[][] visited;
	static int city[];
	static List<Integer> costList = new ArrayList<>();
	static int count;
	static int min;
	static int[] visited;
	static int first;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 도시의 수
		cost = new int[N + 1][N + 1]; // 비용 행렬
		//visited = new boolean[N + 1][N + 1]; // 도시 방문 여부
		visited = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken()); // 도시 i에서 j로 가기 위한 비용
			}
		}
		
		// DFS
		for (int i = 0; i < N; i++) {
			first = i;
			DFS(i, 0, 0);
			setVisited();
		}
		
		System.out.println(min);
		
		// 순열 방식
		/*for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (cost[i][j] == 0) {
					visited[i][j] = true;
				}
			}
		}

		city = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			city[i] = i;
		}

		perm(2);

		Collections.sort(costList);

		System.out.println(costList.get(0));

		System.out.println(count);
		for (int i = 0; i < costList.size(); i++) {
			System.out.print(costList.get(i) + " ");
		}*/
	}
	
	public static void setVisited() {
		for (int i = 0; i < visited.length; i++) {
			visited[i] = 0;
		}
	}
	
	public static void DFS(int node, int sum, int cnt) {
		if (visited[node] == 0) {
			visited[node] = 1;
			cnt++;
			
			for (int i = 1; i <= N; i++) {
				if (cost[node][i] != 0) {
					DFS(i, sum + cost[node][i], cnt);
				}
			}
			
			visited[node] = 0;
		}
		
		if (cnt == N && first == node) {
			min = (min == 0) ? sum : Math.min(sum, min);
		}
	}

	/*public static void perm(int depth) {
		if (depth == N) {
			int temp = 0;
			for (int i = 1; i <= N; i++) {
				System.out.print(city[i] + " ");

				if (i < N) {
					temp += cost[city[i]][city[i + 1]];
				} else if (i == N) {
					temp += cost[city[i]][1];
				}
			}
			System.out.println();

			costList.add(temp);
			count++;
			setVisited();

			return;
		}

		for (int i = depth; i <= N; i++) {
			swap(i, depth);
			perm(depth + 1);
			swap(i, depth);
		}
	}

	public static void swap(int i, int j) {
		int temp = city[i];
		city[i] = city[j];
		city[j] = temp;
	}

	public static void setVisited() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				visited[i][j] = false;
			}
		}
	}*/
}
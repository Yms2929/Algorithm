package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DFSBFS {
	
	// 순환 호출을 이용한 DFS 구현
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		Graph g = new Graph(N*M);
		int edge = 0;
		int value = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			edge = Integer.parseInt(st.nextToken());
			value = Integer.parseInt(st.nextToken());
		
			g.addEdge(edge, value);
		}
		
		g.DFS(V);
		System.out.println();
		g.BFS(V);
	}

}

/*
 * 인접 리스트를 이용한 방향성 있는 그래프 클래스
 */
class Graph {
	private int V; // 노드의 개수
	private LinkedList<Integer> adj[]; // 인접 리스트
	
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		
		for (int i = 0; i < v; i++) { // 인접 리스트 초기화
			adj[i] = new LinkedList<>();
		}
	}
	
	/*
	 * 노드를 연결 v->w
	 */
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	/*
	 * DFS에 의해 사용되는 함수
	 */
	void DFSUtil(int v, boolean visited[]) {
		// 현재 노드를 방문한 것으로 표시하고 값을 출력
		visited[v] = true;
		System.out.print(v + " ");
	
		for (int i = 0; i < adj[v].size(); i++) {
			int n = adj[v].get(i);
			
			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}
		
		// 방문한 노드와 인접한 모든 노드를 가져온다.
		/*Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			// 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
			if (!visited[n]) {
				DFSUtil(n, visited); // 순환 호출
			}
		}*/
	}
	
	/*
	 * 주어진 노드를 시작 노드로 DFS 탐색
	 */
	void DFS(int v) {
		// 노드의 방문 여부 판단 (초기값 false)
		boolean visited[] = new boolean[V];
		
		// v를 시작 노드로 DFSUtil 순환 호출
		DFSUtil(v, visited);
	}
	
	/*
	 * DFS 탐색
	 */
	void DFS() {
		// 노드의 방문 여부 판단 (초기값 false)
		boolean visited[] = new boolean[V];
		
		// 비연결형 그래프의 경우, 모든 정점을 하나씩 방문
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				DFSUtil(i, visited);
			}
		}
	}
	
	/*
	 * s를 시작 노드로 한 BFS로 탐색하면서 탐색한 노드들을 출력
	 */
	void BFS(int s) {
		// 노드의 방문 여부 판단 (초기값 false)
		boolean visited[] = new boolean[V];
		// BFS 구현을 위한 큐 생성
		LinkedList<Integer> queue = new LinkedList<Integer>();
	
		// 현재 노드를 방문한 것으로 표시하고 큐에 삽입
		visited[s] = true;
		queue.add(s);
		
		// 큐가 빌 때까지 반복
		while (!queue.isEmpty()) {
			// 방문한 노드를 큐에서 추출하고 값을 출력
			s = queue.poll();
			System.out.print(s + " ");
			
			for (int i = 0; i < adj[s].size(); i++) {
				int n = adj[s].get(i);
				
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
			
			// 방문한 노드와 인접한 모든 노드를 가져온다.
			/*Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				// 방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}*/
		}
	}
}
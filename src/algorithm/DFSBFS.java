package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DFSBFS {
	
	// ��ȯ ȣ���� �̿��� DFS ����
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
 * ���� ����Ʈ�� �̿��� ���⼺ �ִ� �׷��� Ŭ����
 */
class Graph {
	private int V; // ����� ����
	private LinkedList<Integer> adj[]; // ���� ����Ʈ
	
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		
		for (int i = 0; i < v; i++) { // ���� ����Ʈ �ʱ�ȭ
			adj[i] = new LinkedList<>();
		}
	}
	
	/*
	 * ��带 ���� v->w
	 */
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	/*
	 * DFS�� ���� ���Ǵ� �Լ�
	 */
	void DFSUtil(int v, boolean visited[]) {
		// ���� ��带 �湮�� ������ ǥ���ϰ� ���� ���
		visited[v] = true;
		System.out.print(v + " ");
	
		for (int i = 0; i < adj[v].size(); i++) {
			int n = adj[v].get(i);
			
			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}
		
		// �湮�� ���� ������ ��� ��带 �����´�.
		/*Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			// �湮���� ���� ���� �ش� ��带 ���� ���� �ٽ� DFSUtil ȣ��
			if (!visited[n]) {
				DFSUtil(n, visited); // ��ȯ ȣ��
			}
		}*/
	}
	
	/*
	 * �־��� ��带 ���� ���� DFS Ž��
	 */
	void DFS(int v) {
		// ����� �湮 ���� �Ǵ� (�ʱⰪ false)
		boolean visited[] = new boolean[V];
		
		// v�� ���� ���� DFSUtil ��ȯ ȣ��
		DFSUtil(v, visited);
	}
	
	/*
	 * DFS Ž��
	 */
	void DFS() {
		// ����� �湮 ���� �Ǵ� (�ʱⰪ false)
		boolean visited[] = new boolean[V];
		
		// �񿬰��� �׷����� ���, ��� ������ �ϳ��� �湮
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				DFSUtil(i, visited);
			}
		}
	}
	
	/*
	 * s�� ���� ���� �� BFS�� Ž���ϸ鼭 Ž���� ������ ���
	 */
	void BFS(int s) {
		// ����� �湮 ���� �Ǵ� (�ʱⰪ false)
		boolean visited[] = new boolean[V];
		// BFS ������ ���� ť ����
		LinkedList<Integer> queue = new LinkedList<Integer>();
	
		// ���� ��带 �湮�� ������ ǥ���ϰ� ť�� ����
		visited[s] = true;
		queue.add(s);
		
		// ť�� �� ������ �ݺ�
		while (!queue.isEmpty()) {
			// �湮�� ��带 ť���� �����ϰ� ���� ���
			s = queue.poll();
			System.out.print(s + " ");
			
			for (int i = 0; i < adj[s].size(); i++) {
				int n = adj[s].get(i);
				
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
			
			// �湮�� ���� ������ ��� ��带 �����´�.
			/*Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				// �湮���� ���� ���� �湮�� ������ ǥ���ϰ� ť�� ����
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}*/
		}
	}
}
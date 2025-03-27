import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_1647 {
	
	static int[] parent;
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		pq = new PriorityQueue<>();
		
		for (int i = 1; i <= n; i++) parent[i] = i;
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pq.add(new Edge(a, b, c));
		}
		
		int answer = 0;
		int count = 0;
		while(!pq.isEmpty()) {
			if (count == n - 2) break;
			
			Edge edge = pq.poll();
			
			if (find(edge.u) != find(edge.v)) {
				union(edge.u, edge.v);
				answer+= edge.cost;
				count++;
			}
		}
		System.out.println(answer);
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA != rootB) parent[rootB] = rootA;
	}
	
	static int find(int a) {
		if (parent[a] == a) return a;
		
		return parent[a] = find(parent[a]);
	}
	
	static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int cost;
		
		Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_1922 {
	
	static int n, m;
	static int[] parent;
	static PriorityQueue<Edge> edges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		parent = new int[n + 1];
		edges = new PriorityQueue<>();
		
		for (int i = 1; i <= n; i++) parent[i] = i;
			
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(a, b, cost));
		}
		
		int answer = 0;
		
		while (!edges.isEmpty()) {
			Edge edge = edges.poll();
			
			if (find(edge.u) != find(edge.v)) {
				union(edge.u, edge.v);
				answer += edge.weight;
			}
		}
		
		System.out.println(answer);
	}
	
	static int find(int a) {
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA != rootB) parent[rootB] = rootA;
	}
	
	static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int weight;
		
		public Edge(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}

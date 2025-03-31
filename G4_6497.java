import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_6497 {
		
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if (n == 0 && m == 0) break;
			
			parent = new int[n + 1];
			
			for (int i = 0; i < n; i++) parent[i] = i;
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				pq.add(new Edge(a, b, c));
			}

			int cost = 0;
			int count = 0;
			while (!pq.isEmpty()) {
				Edge edge = pq.poll();
				
				if (find(edge.u) != find(edge.v)) {
					union(edge.u, edge.v);
					count++;
				} else {
					cost += edge.weight;
				}
				
				if (count == n - 1) break;
			}
			
			while (!pq.isEmpty()) {
				cost += pq.poll().weight;
			}
			
			sb.append(cost).append("\n");
		}
		System.out.println(sb);
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

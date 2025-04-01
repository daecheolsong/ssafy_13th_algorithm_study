import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P5_2887 {
		
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[][] arr = new int[n][4];
		parent = new int[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = i;
			for (int j = 1; j < 4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < 4; i++) {
			int index = i;
			Arrays.sort(arr, (o1, o2) -> o1[index] - o2[index]);	
			for (int j = 0; j < n - 1; j++) {
				pq.add(new Edge(arr[j][0], arr[j + 1][0], Math.abs(arr[j][i] - arr[j + 1][i])));
			}
		}
		
		for (int i = 0; i < n; i++) parent[i] = i;
		
		long answer = 0;
		int count = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if (find(edge.u) != find(edge.v)) {
				union(edge.u, edge.v);
				answer += edge.weight;
				count++;
			}
			
			if (count == n - 1) break;
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
		long weight;

        public Edge(int u, int v, long weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return (int) (this.weight - o.weight);
        }
	}
}

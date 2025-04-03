import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class G3_1865 {
	
	static List<Node> nodes = new ArrayList<>();
	static int n, m, w;
	static final int INF = 1_000_000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nodes = new ArrayList<>();
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				nodes.add(new Node(a, b, c));
				nodes.add(new Node(b, a, c));
			}
			
			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				nodes.add(new Node(a, b, -c));
			}
			
			sb.append(bellmanFord() ? "YES" : "NO").append("\n");
		}
		System.out.println(sb);
	}

	static boolean bellmanFord() {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		
		for (int i = 0; i < n; i++) {
			for (Node node : nodes) {
				if (dist[node.v] > dist[node.u] + node.cost) {
					if (i == n - 1) return true;
					dist[node.v] = dist[node.u] + node.cost;
				}
			}
		}
		
		return false;
	}
	
	static class Node {
		int u;
		int v;
		int cost;
		
		public Node(int u, int v, int cost) {
			super();
			this.u = u;
			this.v = v;
			this.cost = cost;
		}
	}
}


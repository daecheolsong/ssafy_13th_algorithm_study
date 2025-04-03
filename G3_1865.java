import java.util.*;
import java.io.*;


public class G3_1865 {
	static int T, N, M, W;
	static List<Edge> edges;
	static final int INF = 987654321;
	
	static class Edge {
		int start, end, weight;
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			edges = new ArrayList<>();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				edges.add(new Edge(x, y, w));
				edges.add(new Edge(y, x, w));
			}
			
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				edges.add(new Edge(x, y, -w));
			}

			System.out.println(bellmanFord() ? "YES" : "NO");
		}
	}
	
	static boolean bellmanFord() {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		boolean update = false;
		
		for (int i = 1; i < N; i++) {
			update = false;
			for (Edge e: edges) {
				if (dist[e.end] > dist[e.start] + e.weight) {
					dist[e.end] = dist[e.start] + e.weight;
					update = true;
				}
			}
			
			if(!update) {
				break;
			}
		}
		
		if(update) {

			
			for (Edge e : edges) {
				if (dist[e.end] > dist[e.start] + e.weight) {
					return true;
				}
			}
		}
		
		return false;
	}

}

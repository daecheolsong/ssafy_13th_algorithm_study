import java.io.*;
import java.util.*;

public class G4_10282 {
	static int t;
	static int n;
	static int d;
	static int c;
	
	// 1 - (5) -> 2 -(5)-> 3
	// 1 - (2) -> 2 -(4)-> 3
	//   ----------- (8) --|
	
	static List<List<Edge>> g;
	static int [] v;
	static int [] dist;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			g = new ArrayList<>();
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			v = new int[n + 1];
			dist = new int[n + 1];
			
			Arrays.fill(dist, 100_000_000);
			for(int i = 0; i <= n; i ++) {
				g.add(new ArrayList<>());
			}
			
			for(int i = 0; i < d; i ++) {				
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				g.get(from).add(new Edge(to, cost));
			}
			
			int cnt = 1;
			
			dist[c] = 0;
			PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
	        pq.offer(new Edge(c, 0));
			
			while(!pq.isEmpty()) {
				Edge cur = pq.poll();
				
				if(cur.cost > dist[cur.to]) {
					continue;
				}
				
				for(Edge out : g.get(cur.to)) {
					if(dist[out.to] > cur.cost + out.cost) {
						dist[out.to] = cur.cost + out.cost;
						pq.offer(new Edge(out.to, dist[out.to]));
					}
				}
			}
			
			cnt = 0;
			int time = 0;
	
			
			for(int i = 1; i <= n; i ++) {
				if(dist[i] != 100_000_000) {
					cnt++;
					time = Math.max(time, dist[i]);
				}
			}
			System.out.println(cnt + " " + time);
		}
	}
	static class Edge {
		int to;
		int cost;
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
}

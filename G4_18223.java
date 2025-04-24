import java.util.*;
import java.io.*;

public class G4_18223 {
	static int V, E, P;
	static List<Node>[] list;
	static int[] dist, dist1;
	
	static class Node implements Comparable<Node> {
		int to, weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[V+1];
		dist = new int[V+1];
		dist1 = new int[V+1];
		
		for (int i = 1; i <= V; i++) {
			dist[i] = Integer.MAX_VALUE;
			dist1[i] = Integer.MAX_VALUE;
		}
		
		dist[1] = 0;
		dist1[P] = 0;
		
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, weight));
			list[to].add(new Node(from, weight));
		}
		
		dijsktra(1, dist);
		dijsktra(P, dist1);

		System.out.println(dist[V] >= dist[P] + dist1[V] ? "SAVE HIM" : "GOOD BYE");
	}
	
	static void dijsktra(int n, int[] dist) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(n, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(dist[curr.to] < curr.weight) continue;
			
			for (Node next: list[curr.to]) {
				if(dist[next.to] > dist[curr.to] + next.weight) {
					dist[next.to] = dist[curr.to] + next.weight;
					pq.add(new Node(next.to, dist[next.to]));
				}
			}
		}
	}

}

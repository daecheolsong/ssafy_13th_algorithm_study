mport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, dist[], start, end ;
	static boolean visited[];
	static ArrayList<Node>[] graph;
	
	static class Node implements Comparable<Node>{
		int v;
		int cost;
		
		public Node(int v, int cost) {
			super();
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Main.Node o) {
			return Integer.compare(this.cost, o.cost);
		}
		
		
	}
	public static void main(String[] args) throws IOException{
		init();
		dijkstra();
		System.out.println(dist[end]);
	}
	
	private static void dijkstra() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int v = cur.v;
			int cost = cur.cost;
			if(!visited[v]) {
				visited[v] = true;
			}
			if(v == end) return;
			for(Node next : graph[v]) {
				if(!visited[next.v] && dist[next.v] > cost + next.cost ) {
					dist[next.v] = cost + next.cost;
					
					q.add(new Node(next.v, dist[next.v]));
				}
			}
		}
		
	}

	private static void init() throws IOException{
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
		    dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++ ){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Node(to, cost));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
	}
	
}

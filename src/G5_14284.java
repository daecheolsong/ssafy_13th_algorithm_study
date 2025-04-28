import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_14284 {
	static class Node implements Comparable<Node>{
		int node;
		int cost;
		public Node(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new ArrayList[N];
		for(int i = 0 ; i < N ; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			
			map[start].add(new Node(end,cost));
			map[end].add(new Node(start,cost));
			
		}
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		dist = new int[N];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[start] = 0;
		dik(start);
		System.out.println(dist[end]);
		
	}
	static int[] dist;
	static ArrayList<Node>[] map;
	
	public static void dik(int node) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(node,0));
		while(!pq.isEmpty()) {
			Node nowNode = pq.poll();
			int now = nowNode.node;
			int cost = nowNode.cost;
			
			if(dist[now]!=cost) {
				continue;
			}
			
			for(Node nextNode : map[now]) {
				int next = nextNode.node;
				int nextCost = nextNode.cost;
				
				if(dist[next]> dist[now]+nextCost) {
					dist[next] = dist[now]+nextCost;
					pq.add(new Node(next, dist[next]));
				}
			}
			
		}
		
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G3_1719 {
	
	static class Node implements Comparable<Node>{
		int node;
		int time;
		public Node(int node, int time) {
			super();
			this.node = node;
			this.time = time;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.time, o.time);
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		int dist[][] = new int[N][N];
		int parent[][] = new int[N][N];
		
		for(int i = 0 ; i< N ; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			Arrays.fill(parent[i], Integer.MAX_VALUE);
		}
		
		map = new ArrayList[N];
		
		for(int i = 0 ; i< N ; i++) {
			map[i] = new ArrayList<>();
		}
		
		
		for(int i = 0 ;  i< M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int time = Integer.parseInt(st.nextToken());
			
			map[start].add(new Node(end,time));
			map[end].add(new Node(start,time));
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int start = 0 ; start < N ; start++) {
			dist[start][start]=0;
			parent[start][start] = -1;
			dik(start,dist[start],parent[start]);
			
			for(int end = 0 ;end<N ; end++) {
				if(start == end) {
					sb.append("-");
				}else {
					sb.append(searchGo(parent[start],start, end)+1);
				}
				sb.append(" ");
			}
			sb.append('\n');
		}
		
		
		
//		for(int i = 0 ; i< N ; i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
//		for(int i = 0 ; i< N ; i++) {
//			System.out.println(Arrays.toString(parent[i]));
//		}
//		
		System.out.println(sb);
		
	}
	public static ArrayList<Node>[] map;
	
	
	public static int searchGo(int parent[],int startNode , int endNode) {
		if(parent[endNode] == startNode) {
			return endNode;
		}
	 	return searchGo(parent ,startNode,  parent[endNode]);
		
	}
	
	public static void dik(int start, int dist[] , int parent[]) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node nowNode = pq.poll();
			int now = nowNode.node;
			int time = nowNode.time;
			
			if(dist[now]!=time) {
				continue;
			}
			
			for(Node nextNode : map[now]) {
				int next = nextNode.node;
				int nextTime = nextNode.time;
				
				if(dist[next] > dist[now] + nextTime) {
					dist[next] = dist[now] + nextTime;
					parent[next] = now;
					pq.add(new Node(next , dist[next]));
				}
			}
			
			
		}
	}

}

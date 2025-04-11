import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_17396 {
	static class Node implements Comparable<Node>{
		int node;
		long time;
		int hidden;
		
		public Node(int node, long time, int hidden) {
			super();
			this.node = node;
			this.time = time;
			this.hidden = hidden;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Long.compare(this.time, o.time);
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M  =Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] hiddenList = new int[N];
		for(int i = 0; i <N; i++) {
			hiddenList[i] = Integer.parseInt(st.nextToken());
		}
		
		map = new ArrayList[N];
		
		for(int i = 0; i < N ; i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M ; i++) {
			st= new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			map[start].add(new Node(end,time,hiddenList[end]));
			map[end].add(new Node(start,time,hiddenList[start]));

		}
		
		dist = new long[N];
		
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[0] = 0;
		
		dik();
		
		//System.out.println(Arrays.toString(dist));
		System.out.println(dist[N-1]==Long.MAX_VALUE?-1:dist[N-1]);
	}
	public static int N;
	public static ArrayList<Node> map[];
	public static long[] dist;
	public static void dik() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0,0,0));
		
		while(!pq.isEmpty()) {
			
			Node nowNode = pq.poll();
			int toNode = nowNode.node;
			long time = nowNode.time;
			if(dist[toNode]!=time) {
				continue;
			}
			for(Node nextNode : map[toNode]) {
				
				int next = nextNode.node;
				long nextTime = nextNode.time;
				int hidden = nextNode.hidden;
				if(next!=N-1 && hidden==1) {
					continue;
				}
				
				if(dist[next] > dist[toNode] + nextTime) {
					dist[next] = dist[toNode] + nextTime;
					pq.add(new Node(next , dist[next], 0));
				}
				
			}
			
		}
		
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_18223 {
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
		int E = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken())-1;
		
		int[]dist = new int[N];
		int[]dist1 = new int[N];
		for(int i = 0;i<N;i++) {
			dist[i] = Integer.MAX_VALUE;
			dist1[i] = Integer.MAX_VALUE;
		}
		dist[0] = 0;
		dist1[P] = 0;
		map = new ArrayList[N];
		for(int i = 0 ; i< N ; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i = 0 ; i<E ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int time = Integer.parseInt(st.nextToken());
			
			map[start].add(new Node(end, time));
			map[end].add(new Node(start,time));
		}
		
		dik(0,dist);
		dik(P,dist1);
		
		//System.out.println(Arrays.toString(dist));
		//System.out.println(Arrays.toString(dist1));
		if(dist[N-1]>=dist[P]+dist1[N-1]) {
			System.out.println("SAVE HIM");
		}else {
			System.out.println("GOOD BYE");
		}

	}
	static ArrayList<Node>[] map;
	
	static int[] p;
	static void dik(int start, int[] dist) {
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
				
				if(dist[next]> dist[now] + nextTime) {
					dist[next] = dist[now] + nextTime;
					pq.add(new Node(next, dist[next]));
				}
			}
			
			
			
			
		}
		
	}

}

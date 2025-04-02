import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G3_11779 {
	
	static class Node implements Comparable<Node>{
		int to;
		int weight;
		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int M = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st;
		
		map = new ArrayList[N];
		
		for(int i = 0; i< N ; i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i =0; i< M ; i++) {
			st = new StringTokenizer(br.readLine());
			int from  = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			
			map[from].add(new Node(to,weight));
			
			
			
			
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;

		p = new int[N];
		dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		dik(start);
		
		StringBuilder sb = new StringBuilder();
		list = new ArrayList<>();
		find(start,end);
		
		//System.out.println(list);
		//list.reversed();
		Collections.reverse(list);
		//System.out.println(list);
		
		
		sb.append(dist[end]).append('\n');
		sb.append(list.size()).append('\n');
		
		for(int i = 0; i< list.size() ; i++) {
			sb.append(list.get(i)).append(" ");
		}
		
		System.out.println(sb);
		
		
//		System.out.println(Arrays.toString(dist));
//		System.out.println(Arrays.toString(p));
		
	}
	static ArrayList<Node>[] map;
	static int[] p;
	static int[] dist;
	static ArrayList<Integer> list;
	
	public static void find(int start ,int a) {
		list.add(a+1);
		if(start == a) {
			return;
		}
		
		find(start,p[a]);
		
	}
	
	public static void dik(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		
		pq.add(new Node(start, 0));
		
		
		while(!pq.isEmpty()) {
			
			Node nowNode = pq.poll();
			
			int now = nowNode.to;
			int weight = nowNode.weight;
			
			
			if(dist[now]!=weight) {
				continue;
			}
			
			for(Node node : map[now]) {
				
				int next = node.to;
				int nextWeight = node.weight;
				
				if(dist[next] > dist[now]+nextWeight) {
					dist[next] = dist[now] + nextWeight;
					p[next] = now;
					pq.add(new Node(next,dist[next]));
				}
				
				
			}
			
			
			
		}
		
		
		
	}
	
	

}

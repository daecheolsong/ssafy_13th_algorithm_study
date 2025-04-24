import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_13424 {
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
	static ArrayList<Node>[] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TESTCASE = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int testCase = 0 ; testCase< TESTCASE ;testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			map = new ArrayList[N];
			for(int i = 0 ; i<N; i++) {
				map[i] = new ArrayList<>();
			}
			for(int i =0 ; i< M ; i++) {				
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
				map[a].add(new Node(b,c));
				map[b].add(new Node(a,c));
			}
			
			int friendSize = Integer.parseInt(br.readLine());
			
			int[] friends = new int[friendSize];
			
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i< friendSize ; i++) {
				friends[i] = Integer.parseInt(st.nextToken())-1;
			}
			
			int[][] dist = new int[friendSize][N];
			
			
			for(int i = 0; i<friendSize ; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			
			
			for(int i = 0; i<friendSize ;i++) {
				dist[i][friends[i]]=0;
				dik(friends[i],dist[i]);
			}
			
			
			int minSum= Integer.MAX_VALUE;
			int index=0;
			for(int i =N-1 ; i>=0;i--) {
				int sum =0;
				for(int j =0 ; j< friendSize ; j++) {
					sum += dist[j][i];
				}
				if(minSum>=sum) {
					minSum = sum;
					index=i;
				}
			}
			
			
			sb.append(index+1).append('\n');
		}
		System.out.println(sb);
		
		
	}
	
	public static void dik(int start, int[] dist) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node nowNode = pq.poll();
			int now = nowNode.node;
			int nowTime = nowNode.time;
			if(dist[now]!=nowTime) {
				continue;
			}
			for(Node nextNode : map[now]) {
				int next = nextNode.node;
				int nextTime = nextNode.time;
				if(dist[next]>dist[now]+nextTime) {
					dist[next]=dist[now]+nextTime;
					pq.add(new Node(next,dist[next]));
				}
			}
		}
		
		
		
	}

}

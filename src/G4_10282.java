import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_10282 {
	
	static class Node{
		int node;
		int value;
		public Node(int node, int value) {
			super();
			this.node = node;
			this.value = value;
		}
		
		
	}
	
	static ArrayList<Node>[] map; 
	static int[] dist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TESTCASE = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int testCase =0 ; testCase< TESTCASE ; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int d  = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken())-1;
			dist = new int[N];
			for(int i=0; i<N ; i++) {
				dist[i] = Integer.MAX_VALUE;
			}
			dist[c] = 0;
			
			map = new ArrayList[N];
			for(int i =0 ;i<N ; i++) {
				map[i] = new ArrayList<>();
			}
			for(int i=0; i< d ;i++) {
				st = new StringTokenizer(br.readLine());
				
				int end = Integer.parseInt(st.nextToken())-1;
				int start = Integer.parseInt(st.nextToken())-1;
				int value = Integer.parseInt(st.nextToken());
				
				
				map[start].add(new Node(end,value));
			}
			
			
			di(new Node(c,0));
			System.out.println(Arrays.toString(dist));
			int count =0;
			int maxTime = 0;
			for(int i =0 ; i<N ; i++) {
				if(dist[i]!=Integer.MAX_VALUE) {
					count++;
					maxTime = Math.max(maxTime,dist[i]);
				}
			}
			
			sb.append(count).append(" ").append(maxTime).append('\n');
			
			
		}
		
		System.out.println(sb);
	}
	
	public static void di(Node node) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.value-o2.value);
		pq.add(node);
		
		while(!pq.isEmpty()) {
			Node nowNode = pq.poll();
			int nowNodeNum = nowNode.node;
			int nowNodeValue = nowNode.value;
			if(dist[nowNodeNum]!=nowNodeValue) {
				continue;
			}
			for(Node nextNode : map[nowNodeNum]) {
				int nextNodeNum = nextNode.node;
				int nextNodeValue = nextNode.value;
				int time = dist[nowNodeNum] + nextNodeValue;
				
				if(dist[nextNodeNum]>time) {
					dist[nextNodeNum] = time;
					pq.add(new Node(nextNodeNum, dist[nextNodeNum]));
				}
				
			}
			
			
			
		}
		
		
		
		
	}

}

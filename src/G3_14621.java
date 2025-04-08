import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G3_14621 {
	
	static class Node implements Comparable<Node>{
		int to;
		int weight;
		char gender;
		
		public Node(int to, int weight, char gender) {
			super();
			this.to = to;
			this.weight = weight;
			this.gender = gender;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[] gender = new char[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0;i<N ; i++) {
			gender[i] = st.nextToken().charAt(0);
		}
		
		List<Node>[] map= new ArrayList[N];
		
		for(int i = 0; i< N ; i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			
			map[from].add(new Node(to,weight,gender[to]));
			map[to].add(new Node(from,weight,gender[from]));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(0,0,gender[0]));
		boolean[] isTree = new boolean[N];
		
		
		long sol =0;
		
		while(!pq.isEmpty()) {
			
			Node nowNode= pq.poll();
			int to = nowNode.to;
			if(isTree[to]) {
				continue;
			}
			isTree[to] = true;
			int weight = nowNode.weight;
			char nowGender = nowNode.gender;
			//System.out.println(weight);
			sol += weight;
			
			
			for(Node nextNode:map[to]) {
				if(isTree[nextNode.to]) {
					continue;
				}
				if(nextNode.gender!=nowGender) {
					pq.add(nextNode);
				}
				
			}
			
		}
		
		boolean check = false;
		
		for(int i  =0 ; i< N ; i++) {
			if(!isTree[i]) {
				check = true;
			}
		}
		if(!check) {
			System.out.println(sol);
		}else {
			System.out.println(-1);
		}
		
	}

}

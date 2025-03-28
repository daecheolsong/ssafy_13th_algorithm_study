import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class G4_1647 {
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}
	
	static int[] p;
	static int N;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M  = Integer.parseInt(st.nextToken());
		
		List<Edge> edgeList = new ArrayList<>();
		for(int i = 0 ; i< M ; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());

			edgeList.add(new Edge(from, to, weight));
			
			
		}
		
		Collections.sort(edgeList);
		
		make();
		
		int count =0;
		long result =0;
		
		for(Edge edge : edgeList) {
			int from = edge.from;
			int to = edge.to;
			int weight = edge.weight;
			
			if(union(from,to)) {
				result += weight;
				if(++count == N-2) {
					
					break;
				}
				
				
			}
			
		}
		
		if(N==2) {
			result =0;
		}
		System.out.println(result);
		
	}
	
	
	
	public static void make() {
		p = new int[N];
		for(int i= 0; i<N; i++) {
			p[i] = i;
		}
		
	}
	
	public static int find(int a) {
		if(p[a]==a) {
			return a;
		}
		
		return p[a] = find(p[a]);
	}
	
	public static boolean union(int a, int b) {
		
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) {
			return false;
		}
		
		if(rootA > rootB) {
			p[rootB] = rootA;
		}else {
			p[rootA] = rootB;
		}
		
		return true;
		
	}

}

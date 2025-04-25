import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_14950 {
	static class Node implements Comparable<Node>{
		int start;
		int end;
		int time;
		public Node(int start, int end, int time) {
			super();
			this.start = start;
			this.end = end;
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
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		Node[] list = new Node[M];
		for(int i = 0 ; i< M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			
			list[i] = new Node(a,b,c);
			
		}
		
		Arrays.sort(list);
		make();
		
		int index =0;
		int sum =0;
		for(Node node : list) {
			int start = node.start;
			int end = node.end;
			int time = node.time;
			
			if(union(start, end)) {
				sum+=(time+index*T);
			if(++index == N-1) {
				
				break;
			}
			}
			
		}
		
		
		System.out.println(sum);
		
		
	}
	
	static int[] p;
	static int N;
	
	public static void make() {
		p= new int[N];
		
		for(int i = 0; i< N ; i++) {
			p[i] = i;
		}
		
	}
	
	public static int find(int a) {
		if(a==p[a]) {
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
		
		if(rootA>rootB) {
			p[rootB] = rootA;
		}else {
			p[rootA] = rootB;
		}
		return true;
	}

}

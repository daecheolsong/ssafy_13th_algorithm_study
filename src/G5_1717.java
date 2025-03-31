import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_1717 {

	public static int p[];
	static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		make();
		for(int i = 0 ; i< M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			if(type == 0) {
				union(a,b);
			}else {
				if(isUnion(a,b)) {
					sb.append("YES").append('\n');
				}else {
					sb.append("NO").append('\n');
				}
			}
		}
		System.out.println(sb);
			
		
	}
	
	public static void make() {
		p = new int[N+1];
		
		for(int i =0 ; i<= N ; i++) {
			p[i] = i;
		}
		
		
	}
	
	
	public static int find(int a) {
		
		if(p[a] == a) {
			return a;
		}
		
		return p[a] = find(p[a]);
		
		
	}
	
	public static boolean isUnion(int a, int b) {
		return find(a)==find(b);
	}
	
	public static boolean union(int a,int b) {
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

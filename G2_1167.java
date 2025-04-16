import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int V, dis, res;
	static ArrayList<int[]>[] node;
	static boolean[] visited;
	

	public static void main(String[] args) throws IOException {
		init();
		go();
		System.out.println(res);
	}

	private static void go() {
		visited = new boolean[V + 1];
		dfs(2, 0); 
		
		visited = new boolean[V + 1];
		res = 0;
		System.out.println(dis);
		dfs(dis, 0); 
			
		
		
	}




	private static void dfs(int v, int w) {
		visited[v] = true;
		
		if(w > res) {
			res = w;
			dis = v;
		}
		
		for(int[] next : node[v]) {
			int nv = next[0];
			int nw = next[1];
			
			if(!visited[nv]) {
				dfs(nv, w + nw);
			}
			
			
		}
		
	}






	static void init() throws IOException {
		V = Integer.parseInt(br.readLine());
		
		node = new ArrayList[V + 1];
	
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			node[num] = new ArrayList<>();
			
			while(true) {
				int x = Integer.parseInt(st.nextToken());
				if (x == -1) break;
				int y = Integer.parseInt(st.nextToken());
				node[num].add(new int[] {x, y});
			}
		}
		
		
		
	}

}

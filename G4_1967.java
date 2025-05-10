import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int  N, fall, res;
	static boolean[] visited;   
	static ArrayList<int[]>[] node;
	public static void main(String[] args) throws IOException {
			init();
			go();
			System.out.println(res);
	}

	

	


	private static void go() {
		fall = 0;
		res = -1;
		dfs(1, 0);
		
		visited = new boolean[10_001];
		res = -1;
		dfs(fall, 0);
	}






	private static void dfs(int v, int w) {
		visited[v] = true;
		
		if(res < w) {
			res = w;
			fall = v;
		}
		
		for(int[]cur : node[v]) {
			int nv = cur[0];
			int nw = cur[1];
		
			if(!visited[nv]) {
				dfs(nv, w + nw);
			}
		}
		
	}






	static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		
		node = new ArrayList[10_001];
		visited = new boolean[10_001];
		
		for(int i = 1; i <= 10_000; i++) {
			node[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			node[start].add(new int[] {from, weight});
			node[from].add(new int[] {start, weight});
		}
	}
}

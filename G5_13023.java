import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int N, M ,result;
	public static void main(String[] args) throws IOException {
		init();
		
		for(int i = 0; i < N; i++) {
			if(result == 1) break;
			dfs(i, 0);
		}
		System.out.println(result);
	}

	private static void dfs(int v, int depth) {
		if(depth == 4) {
			result = 1; 
			return;
		}
		
		visited[v] = true;
		for(int nv : graph[v]) {
			if(!visited[nv]) {
				dfs(nv , depth + 1);
			}
		}
		visited[v] = false;
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = 0;
		graph = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			graph[i].add(j);
			graph[j].add(i);
		}
	}
}

package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_1260 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder dfsRuslt = new StringBuilder();
	static StringBuilder bfsRuslt = new StringBuilder();
	
	static int N, M, V;
	static ArrayList<Integer>[] graph;
	static Queue<Integer> queue;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		init();
		visited = new boolean[N + 1];
		dfs(V);
		visited = new boolean[N + 1];
		bfs(V);
	
		System.out.println(dfsRuslt);
		System.out.println(bfsRuslt);
	}
	private static void bfs(int v) {
		queue = new LinkedList<>();
		queue.offer(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			bfsRuslt.append(cur).append(" ");
			
			for(int nv : graph[cur]) {
				if(!visited[nv]) {
					visited[nv] = true;
					queue.offer(nv);
				}
			}
		}
	}
	private static void dfs(int v) {
		dfsRuslt.append(v).append(" ");
		visited[v] = true;
		
		for(int nv : graph[v]) {
			if(!visited[nv]) {
				dfs(nv);
			}
		}
		
	}
	private static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int m = 0;  m< M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			graph[i].add(j);
			graph[j].add(i);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		
	}
}

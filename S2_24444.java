import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
			
	public static int N, M, V, idx;
	public static boolean[] visited;
	public static ArrayList<Integer>[] graph;
	public static int[] result;
	public static void main(String[] args) throws IOException {
		init();
		bfs();
		for(int i = 1; i<= N; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(V);
		visited[V] = true;

		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			result[cur] = idx;
			idx++;
			for(int nv : graph[cur]) {
				if(!visited[nv]) {
					visited[nv] = true;
					queue.offer(nv);
				}
				
			}
			
		}
		
		
	}
	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		result = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		idx = 1;
		for(int m = 0; m < M; m++) {
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

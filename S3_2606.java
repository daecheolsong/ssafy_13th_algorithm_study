package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N + 1]; //그래프 초기화
		visited = new boolean[N + 1]; // 1부터 사용
		
		//1부터 사용
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//양방향 연결
			graph[a].add(b);
			graph[b].add(a);
		}
		
		dfs(1); // 1번부터 감영
		sb.append(count);
		System.out.println(count);
		
	}
	
	private static void dfs(int node) {
		visited[node] = true; //방문처리
	
		for(int next : graph[node]) {
			if(!visited[next]) {
				count++;
				dfs(next);
			}
		}
	
	}
}
import java.io.*;
import java.util.*;

public class Main {
	
	public static class Node {
		int e;
		int cost;
		public Node(int e, int cost) {
			super();
			this.e = e;
			this.cost = cost;
		}
	}
	
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int N, node;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 인접 리스트 사용
		list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if(to == -1) break;
				int weight = Integer.parseInt(st.nextToken());
				list[from].add(new Node(to, weight));
			}
			
		}
		
		// 임의의 정점(1) 에서 최대 지름 탐색
		visited = new boolean[N+1];
		dfs(1, 0);
		
		// 끝 정점에서 최대 지름 탐색 -> 트리의 최대 지름 반환
		visited = new boolean[N+1];
		dfs(node, 0);
		
		System.out.println(max);
		
	}

	private static void dfs(int v, int len) {
		// TODO Auto-generated method stub
		if(max<len) {
			max = len;
			node = v;
		}
		
		visited[v] = true;
		
		for(Node next : list[v]) {
			if(visited[next.e]) continue;
			
			dfs(next.e, next.cost+len);
		}
		
		
	}

}

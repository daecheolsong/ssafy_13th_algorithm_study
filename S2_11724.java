import java.io.*;
import java.util.*;

public class S2_11724 {
	static int n, t;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
			graph[y].add(x);
		}
		
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	static void dfs(int num) {
		visited[num] = true;
		for (int next : graph[num]) {
			if(!visited[next]) {
				dfs(next);
			}
		}
	}

}

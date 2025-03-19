import java.util.*;
import java.io.*;

public class G4_2458 {
	static int N, M;
	static List<Integer>[] higher;
	static List<Integer>[] lower;
	static int result;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
			result = 0;
			N = Integer.parseInt(st.nextToken());
			higher = new ArrayList[N];
			lower = new ArrayList[N];
			M = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				higher[i] = new ArrayList<>();
				lower[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				higher[a].add(b);
				lower[b].add(a);
			}
			
			for (int i = 0; i < N; i++) {
				boolean[] visited = new boolean[N];
				int count = dfs(i, higher, visited) + dfs(i, lower, visited);
				if (count == N-1) result++;
			}
			
			System.out.println(result);
			

	}
	
	static int dfs(int node, List<Integer>[] graph, boolean[] visited) {
		visited[node] = true;
		int count = 0;
		
		for (int next : graph[node]) {
			if(!visited[next]) {
				count+= 1+dfs(next, graph, visited);
			}
		}
		
		return count;
	}

}

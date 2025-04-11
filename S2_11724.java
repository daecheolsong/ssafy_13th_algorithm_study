import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean visited[];
	static ArrayList<Integer>[] A;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i < N+1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		int count = 0;
		for (int i = 1; i < N+1; i++) {
			if(!visited[i]) {
				count++;
				dfs(i);
				
			}
		}
		System.out.println(count);
	}
	private static void dfs(int v) {
		if(visited[v]) {
			return;
		}
		visited[v] = true;
		for(int i : A[v]) {
			if(visited[i] == false) {
				dfs(i);
			}
		}
	}
}

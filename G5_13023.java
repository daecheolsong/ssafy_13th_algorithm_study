import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static boolean found;
	static int N, M;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		
		// 인접행렬 만들기
		list = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		// 모든 정점에 중에서 깊이가 4인 관계가 있으면 1 출력
		
		found = false;
		for (int i = 0; i < N; i++) {
			dfs(i,0);
			if(found) break;
			
			//Arrays.fill(visited, false);
			visited = new boolean[N];
		}
		
		if(found) System.out.println(1);
		else System.out.println(0);
	}

	private static void dfs(int Node, int depth) {
		
		if(found) return;
		
		if(depth == 4) {
			found = true;
			return;
		}
		
		visited[Node] = true;
		for (int i : list[Node]) {
			if(!visited[i]) {
				dfs(i, depth+1);
			}
		}
		
		// 백트래킹
		visited[Node] = false;
	}

}

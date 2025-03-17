import java.io.*;
import java.util.*;

public class Main {
	// N - 정점(동기의 수), M - 간선 (친구 정보의 길이) -> N * N = 2500
	static int N, M, from, to, cnt;
	static int[][] adjMatrix;
	static boolean[] visited;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		// 인접행렬 사용
		//System.setIn(new FileInputStream("1번_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adjMatrix = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()); 
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		
//		for(int[] am : adjMatrix) {
//			System.out.println(Arrays.toString(am));
//		}
		
		dfs(1, 0);
		
		// 간선의 차수(너비)1, 2 까지 정점의 개수 카운트 - 친구의 친구 까지 카운트
		for (int i = 2; i < visited.length; i++) {
			if(visited[i]) cnt++;
		}
		System.out.println(cnt);
		
	}

	private static void dfs(int start, int depth) {
		if(depth==2) {
			return;
		}
		for (int i = 1; i < N+1; i++) {
			if(adjMatrix[start][i] == 1 ) {
				visited[i] = true;
				dfs(i, depth+1);
			}
		}
	}
}

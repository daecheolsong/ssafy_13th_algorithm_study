import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[][] visited;
	static int[][] map;
	static int[] dr = {0,1,0,-1}; // 동남서북 
	static int[] dc = {1,0,-1,0}; 
	static int N, M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M];
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i ][j] = str.charAt(j) - '0';
				//System.out.print(map[i+1][j+1]+" ");
			}
			//System.out.println();
		}
		
		
		int depth = bfs(0, 0);
		
		System.out.println(depth);
	}

	private static int bfs(int r, int c) {
		// TODO Auto-generated method stub
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {r, c, 1});
		visited[r][c] = true;
		
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int curR = cur[0];
			int curC = cur[1];
			int curD = cur[2];
			//cur[0] cur[1]
			if(curR == N-1 && curC == M-1) return curD;
			
			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				
				if(isIN(nr,nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					queue.offer(new int[] {nr, nc, curD+1});
					visited[nr][nc] = true;
				}
			}
		}
		return -1;
	}

	private static boolean isIN(int nr, int nc) {
		return 0<=nr && nr < N && 0<=nc && nc < M;
	}
}

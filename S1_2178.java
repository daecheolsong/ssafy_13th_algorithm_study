import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M,result;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0}; 
	public static void main(String[] args) throws IOException {
		init();
		
		System.out.println(bfs(0,0));
	}
	private static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = cr + dx[d];
				int nc = cc + dy[d];
				
				if(isVaild(nr,nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
					q.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
					map[nr][nc] = map[cr][cc] + 1;
				}
			}
			
		}
		return map[N-1][M-1];
	}



	private static boolean isVaild(int nr, int nc) {
		if(nr >= 0 && nc >= 0 && nr < N && nc < M) return true;
		return false;
	}
	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
			}
	}	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, map[][], max;
	static boolean visited[][];
	static int[] dx = {-1, 1, 0, 0}
			   , dy = {0, 0, -1, 1};
			
	public static void main(String[] args) throws IOException {
			init();
			go();
			System.out.println(max);
	}
	
	private static void go() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M;  j++) {
				visited[i][j] = true;
				dfs(i , j, map[i][j], 1);
				visited[i][j] = false;
	
				tmino(i, j);
			}
		}
	}

	private static void tmino(int x, int y) {
		for (int i = 0; i < 4; i++) {
	        int sum = map[x][y]; 
	        boolean isOut = false;
	        for (int d = 0; d < 4; d++) {
	        	 if (d == i) continue;

	            int nx = x + dx[d];
	            int ny = y+ dy[d];

	            if (!isin(nx, ny)) {
	                isOut = true;
	                break;
	            }
	            sum += map[nx][ny];
	        }

	        if (!isOut) {
	            max = Math.max(max, sum);
	        }
	    }
		
	}

	
	// 500*500*15
	private static void dfs(int i, int j, int sum, int depth) {
		if (depth == 4) {
			max = Math.max(sum, max);
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			
			if(isin(nx, ny) && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny, sum + map[nx][ny], depth + 1);
				visited[nx][ny] = false;
				}
		}
		
		
	}

	
	private static boolean isin(int x, int y) {
		if(0 <= x && x < N && 0 <= y && y < M) return true;
		return false;
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		max = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}

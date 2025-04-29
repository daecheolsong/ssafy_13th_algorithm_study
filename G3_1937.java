import java.util.*;
import java.io.*;

public class G3_1937 {
	
	static int result = 0;
	static int[][] grid;
	static int[][] dp;
	static int n;
	static int[] dx = {-1, 0,1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		grid = new int[n][n];
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result = Math.max(result, dfs(i, j));
			}
		}
		
		System.out.println(result);
	}
	
	static int dfs(int x, int y) {
		if(dp[x][y] != 0) return dp[x][y];
		
		dp[x][y] = 1;
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(valid(nx, ny) && grid[nx][ny] > grid[x][y]) {
				dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
			}
		}
		
		return dp[x][y];
	}
	
	static boolean valid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

}

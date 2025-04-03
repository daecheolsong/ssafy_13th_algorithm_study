import java.io.*;
import java.util.*;

public class G5_17070 {
	
	static int n;
	static int [][] map;
	static int answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n + 1][n + 1];
		
		for(int i = 1; i <= n; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1, 2);
		
		System.out.println(answer);
		
	}
	
	public static void dfs(int d, int r, int c) {
		
		if(r == n  && c == n) {
			answer ++;
			return;
		}
		
		
		if(d == 0) {
			if(isIn(r, c + 1) && map[r][c + 1] == 0) {
				dfs(0, r, c + 1);	
			}
			if(isIn(r + 1, c + 1) && map[r + 1][c + 1] == 0 && map[r + 1][c] == 0 && map[r][c + 1] == 0) {
				dfs(2, r + 1, c + 1);	
			}
		}
		else if(d == 1) {
			if(isIn(r + 1, c) && map[r + 1][c] == 0) {
				dfs(1, r + 1, c);	
			}
			if(isIn(r + 1, c + 1) && map[r + 1][c + 1] == 0 && map[r + 1][c] == 0 && map[r][c + 1] == 0) {
				dfs(2, r + 1, c + 1);	
			}
		}
		else if(d == 2) {
			if(isIn(r, c + 1) && map[r][c + 1] == 0) {
				dfs(0, r, c + 1);	
			}
			if(isIn(r + 1, c) && map[r + 1][c] == 0) {
				dfs(1, r + 1, c);	
			}
			if(isIn(r + 1, c + 1) && map[r + 1][c + 1] == 0 && map[r + 1][c] == 0 && map[r][c + 1] == 0) {
				dfs(2, r + 1, c + 1);	
			}
		}
		
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 1 && r <= n && c >= 1 && c <= n;
	}

}

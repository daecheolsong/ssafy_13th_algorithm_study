import java.util.*;
import java.io.*;

public class SW_2112 {
	static int D, W, K;
	static int[][] grid;
	static int result;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			grid = new int[D][W];
			result = Integer.MAX_VALUE;
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0,0);
			System.out.println("#" + tc + " " + result);
		}
		
	}
	
	static void dfs(int x, int insert) {
		int[] temp = new int[W];
		if(insert >= result) return;
		if (x==D) {
			int sum = 0;
			for (int i = 0; i < W; i++) {
				int count = 1;
				for (int j = 1; j < D; j++) {
					if (grid[j][i] == grid[j-1][i]) {
						count++;
					}
					else count = 1;
					
					if (count >= K) {
						sum++;
						break;
					}
				}
			}
			if (sum != W) {
				return;
			}
			else {
				if (insert < result) {
					result = insert;
				}
				return;
			}
		}
		
		for (int j = 0; j < W; j++) {
			temp[j] = grid[x][j];
		}
		
		dfs(x+1, insert); //안넣은 경우
		
		for (int j = 0; j < W; j++) {
			grid[x][j] = 0;
		}
		
		dfs(x+1, insert + 1); //A를 넣은 경우
		
		for (int j = 0; j < W; j++) {
			grid[x][j] = 1;
		}
		
		dfs(x+1, insert + 1); //B를 넣은 경우
		
		for (int j = 0; j < W; j++) {
			grid[x][j] = temp[j];
		}
	}

}

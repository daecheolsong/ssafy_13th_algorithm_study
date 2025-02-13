import java.util.*;
import java.io.*;

public class SW_4014 {
	
	static int N;
	static int X;
	static int[][] grid;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T ; test_case++) {
			int result = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			grid = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				if (check(i,0,1) == 1) {
					//System.out.println("가로: x " + i + "y " + 0);
					result ++;
				}
				//result += check(i, 0, 1);
			}

			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				if (check(0,i,0) == 1) {
					//System.out.println("세로: x " + 0 + "y " + i);
					result ++;
				}
				//result += check(0, i, 0);
			}
			
			System.out.println("#"+test_case + " " + result);
		}
	}
	
	static int check(int x, int y, int dir) {
		if (dir == 1) {
			for (int j = 0; j < N; j++) {
				if (j+1 < N && grid[x][j] != grid[x][j+1]) {
					if (grid[x][j]-1 == grid[x][j+1]) {
						for (int k = 1; k < X; k++) {
							if ((j+k+1 > N-1) || (grid[x][j+1] != grid[x][j+1+k]) || visited[x][j+1+k]) {
								return 0;
							}
						}
						visited[x][j+1] = true;
						for (int k = 1; k < X; k++) {
							visited[x][j+1+k] = true;
						}
					}
					if (grid[x][j]+1 == grid[x][j+1]) {
						for (int k = 1; k < X; k++) {
							if ((j-k < 0) || (grid[x][j] != grid[x][j-k]) || visited[x][j-k]) {
								return 0;
							}
						}
						visited[x][j] = true;
						for (int k = 1; k < X; k++) {
							visited[x][j-k] = true;
						}
					}
					if (Math.abs(grid[x][j] - grid[x][j+1]) >= 2) {
						return 0;
					}
				}
			}
			return 1;
		}
		
		if (dir == 0) {
			for (int j = 0; j < N; j++) {
				if (j+1 < N && grid[j][y] != grid[j+1][y]) {
					if (grid[j][y]-1 == grid[j+1][y]) {
						for (int k = 1; k < X; k++) {
							if ((j+k+1 > N-1) || (grid[j+1][y] != grid[j+k+1][y]) || visited[j+1+k][y]) {
								return 0;
							}
						}
						visited[j+1][y] = true;
						for (int k = 1; k < X; k++) {
							visited[j+k+1][y] = true;
						}
					}
					if (grid[j][y]+1 == grid[j+1][y]) {
						for (int k = 1; k < X; k++) {
							if ((j-k < 0) || (grid[j][y] != grid[j-k][y])|| visited[j-k][y]) {
								return 0;
							}
						}
						visited[j][y] = true;
						for (int k = 1; k < X; k++) {
							visited[j-k][y] = true;
						}
					}
					if (Math.abs(grid[j][y] - grid[j+1][y]) >= 2) {
						return 0;
					}
				}
			}
			return 1;
		}
		return 0;
	}

}

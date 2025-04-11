import java.util.*;
import java.io.*;

public class CT_ruins {
	static int K, M;
	static int[][] grid;
	static int[][] temp;
	static Queue<Integer> remain = new LinkedList<>();
	static int max_j, max_r, max_x, max_y;
	static boolean[][] visited;
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int num;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		grid = new int[5][5];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			remain.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int k = 0; k < K; k++) {
			max_j = 0;
			max_r = 0;
			max_x = 0;
			max_y = 0;
			for(int i = 1; i <= 3; i++) {
				for (int j = 1; j <= 3; j++) {
					rotation(j, i);
				}
			}
			
//			System.out.println(max_x + " " + max_y + " " + max_r + " " + max_j);
			
			rotation_max(max_x, max_y, max_r);
			
//			for(int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				System.out.print(grid[i][j] + " ");
//			}
//			System.out.println();
//			}
//			
			
			boolean erased;
			while(true) {
				visited = new boolean[5][5];
				erased = false;

				fill();
				
//				for(int i = 0; i < 5; i++) {
//					for (int j = 0; j < 5; j++) {
//						System.out.print(grid[i][j] + " ");
//					}
//					System.out.println();
//					}
//				
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if(!visited[i][j] && grid[i][j] != 0) {
							visited[i][j] = true;
							num = 1;
							int val = grid[i][j];
							dfs_n(grid, val, i, j, 1);
							if(num >= 3) {
								max_j += num;
								visited = new boolean[5][5];
								dfs_c(val, i, j, 1);
								erased = true;
							}
						}
					}
				}
				
				if(!erased) break;
			}

			if(max_j == 0) {
				break;
			}
			
			sb.append(max_j + " ");
			
		}
		
		System.out.println(sb);
		
	}
	
	static void rotation(int x, int y) {
		int num_90 = 0;
		int num_180 = 0;
		int num_270 = 0;
		temp = new int[5][5];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp[i][j] = grid[i][j];
			}
		}
		
		//90도
		for(int i = 0; i <= 1; i++) {
			temp[x+i][y+1] = grid[x-1][y+i];
			temp[x+1][y-i] = grid[x+i][y+1];
			temp[x-i][y-1] = grid[x+1][y-i];
			temp[x-1][y+i] = grid[x-i][y-1];
		}
		
		visited = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(!visited[i][j]) {
					num = 1;
					int val = temp[i][j];
					dfs_n(temp, val, i, j, 1);
					if(num >= 3) {
						num_90 += num;
					}
				}
			}
		}
		
		
		if (max_j < num_90) {
			max_j = num_90;
			max_r = 90;
			max_x = x;
			max_y = y;
		}
		
		if (max_j == num_90 && max_r > 90) {
			max_j = num_90;
			max_r = 90;
			max_x = x;
			max_y = y;
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp[i][j] = grid[i][j];
			}
		}
		
		//180도
		for(int i = 0; i <= 1; i++) {
			temp[x+1][y-i] = grid[x-1][y+i];
			temp[x-i][y-1] = grid[x+i][y+1];
			temp[x-1][y+i] = grid[x+1][y-i];
			temp[x+i][y+1] = grid[x-i][y-1];
		}
		
		visited = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(!visited[i][j]) {
					num = 1;
					int val = temp[i][j];
					dfs_n(temp, val, i, j, 1);
					if(num >= 3) {
						num_180 += num;
					}
				}
			}
		}
		
		if (max_j < num_180) {
			max_j = num_180;
			max_r = 180;
			max_x = x;
			max_y = y;
		}
		
		if (max_j == num_180 && max_r > 180) {
			max_j = num_180;
			max_r = 180;
			max_x = x;
			max_y = y;
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp[i][j] = grid[i][j];
			}
		}
		
		//270도
		for(int i = 0; i <= 1; i++) {
			temp[x-i][y-1] = grid[x-1][y+i];
			temp[x-1][y+i] = grid[x+i][y+1];
			temp[x+i][y+1] = grid[x+1][y-i];
			temp[x+1][y-i] = grid[x-i][y-1];
		}
		
		visited = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(!visited[i][j]) {
					num = 1;
					int val = temp[i][j];
					dfs_n(temp, val, i, j, 1);
					if(num >= 3) {
						num_270 += num;
					}
				}
			}
		}
		
		if (max_j < num_270) {
			max_j = num_270;
			max_r = 270;
			max_x = x;
			max_y = y;
		}
		
//		System.out.println("현재: " + x + " " + y + " " + num_90 + " " + num_180 + " " + num_270);
		
	}
	
	static void rotation_max(int x, int y, int r) {
		temp = new int[5][5];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp[i][j] = grid[i][j];
			}
		}
		
		if(r == 90) {
			//90도
			for(int i = 0; i <= 1; i++) {
				temp[x+i][y+1] = grid[x-1][y+i];
				temp[x+1][y-i] = grid[x+i][y+1];
				temp[x-i][y-1] = grid[x+1][y-i];
				temp[x-1][y+i] = grid[x-i][y-1];
			}
			
		}
		

		else if(r == 180) {
			//180도
			for(int i = 0; i <= 1; i++) {
				temp[x+1][y-i] = grid[x-1][y+i];
				temp[x-i][y-1] = grid[x+i][y+1];
				temp[x-1][y+i] = grid[x+1][y-i];
				temp[x+i][y+1] = grid[x-i][y-1];
			}
			
		}
		
		else if(r == 270) {
			//270도
			for(int i = 0; i <= 1; i++) {
				temp[x-i][y-1] = grid[x-1][y+i];
				temp[x-1][y+i] = grid[x+i][y+1];
				temp[x+i][y+1] = grid[x+1][y-i];
				temp[x+1][y-i] = grid[x-i][y-1];
			}
		}
		
		

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				grid[i][j] = temp[i][j];
			}
		}
		
		visited = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(!visited[i][j]) {
					num = 1;
					int val = grid[i][j];
					dfs_n(grid, val, i, j, 1);
					if(num >= 3) {
						visited = new boolean[5][5];
						dfs_c(val, i, j, 1);
					}
				}
			}
		}
		
	}
	
	
	
	static void dfs_n(int[][] temp, int n, int x, int y, int count) {
		visited[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (valid(nx, ny) && temp[nx][ny] == n && !visited[nx][ny]) {
				dfs_n(temp, n, nx, ny, count+1);
				num++;
			}
		}
	}
	
	static void dfs_c(int n, int x, int y, int count) {
		grid[x][y] = 0;
		visited[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (valid(nx, ny) && grid[nx][ny] == n && !visited[nx][ny]) {
				dfs_c(n, nx, ny, count+1);
			}
		}
	}
	
	static void fill() {
		for (int i = 0; i < 5; i++) {
			for (int j = 4; j >= 0; j--) {
				if (grid[j][i] == 0) {
					if (remain.isEmpty()) return;
					grid[j][i] = remain.poll();
				}
			}
		}
	}
	
	static boolean valid(int x, int y) {
		return x >= 0 && x < 5 && y >= 0 && y < 5;
	}

}

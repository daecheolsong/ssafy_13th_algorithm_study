import java.util.*;
import java.io.*;

public class SW_2105 {

	static int[][] grid;
	static int N;
	static ArrayList<Integer> list;
	static boolean[][] visited;
	static int result;
	static int[] dx = {-1,-1, 1, 1};
	static int[] dy = {-1, 1, 1, -1};
	static int sx, sy;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			grid = new int[N][N];
			result = -1;
			for (int i = 0; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					list = new ArrayList<>();
					visited = new boolean[N][N];
					sx = i;
					sy = j;
					list.add(grid[i][j]);
					visited[i][j] = true;
					dfs(i, j, 0);
				}
			}
			System.out.println("#" + test_case + " " + result);
		}

	}
	
	static void dfs(int x, int y, int dir) {
		for (int d = dir; d < 4; d++) {
			if ((x + dx[d] >= 0) && (x + dx[d] < N) && (y + dy[d] >= 0) && (y + dy[d] < N)) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx == sx && ny == sy && list.size() > 3) {
                    if (result < list.size()) {
                    	result = list.size();
                    }
                    return;
                }
				
				if (!visited[nx][ny] && !list.contains(grid[nx][ny])) {
					list.add(grid[nx][ny]);
					visited[nx][ny] = true;
					dfs(nx, ny, d);
					visited[nx][ny] = false;
					list.remove(list.size() - 1);
	            }
			}
		}
	}

}

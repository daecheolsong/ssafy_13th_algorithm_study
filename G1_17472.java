import java.util.*;
import java.io.*;

public class G1_17472 {
	static int N, M, result;
	static int[][] grid;
	static boolean[][] island;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static List<int[]> lines = new ArrayList<>();
	static int[] island2;
	static int islandCount = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		island = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int num_is = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] != 0 && island[i][j] == false) {
					dfs(i, j, num_is);
					num_is++;
				}
			}
		}
		islandCount = num_is-1;
		
		bfs();
		
		result = kruskal();
		
		System.out.println(result);

	}
	
	static void dfs(int x, int y, int num) {
		island[x][y] = true;
		grid[x][y] = num;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < N && ny >= 0 && ny < M && !island[nx][ny] && grid[nx][ny] != 0) {
				dfs(nx, ny, num);
			}
		}
	}
	
	static void bfs() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] > 0) {
                    for (int d = 0; d < 4; d++) {
                        int nx = i, ny = j, length = 0;
                        while (true) {
                            nx += dx[d];
                            ny += dy[d];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;
                            if (grid[nx][ny] == grid[i][j]) break;
                            if (grid[nx][ny] > 0) {
                                if (length >= 2) {
                                    lines.add(new int[]{grid[i][j], grid[nx][ny], length});
                                }
                                break;
                            }
                            length++;
                        }
                    }
                }
            }
        }
    }
	
	static int kruskal() {
		island2 = new int[islandCount+1];
		for (int i = 1; i <= islandCount; i++) {
			island2[i] = i;
		}
		
		lines.sort(Comparator.comparing(e->e[2]));
		
		int cost = 0, count = 0;
		for (int[] line:lines) {
			if (union(line[0], line[1])) {
				cost += line[2];
				count++;
				if (count == islandCount-1) {
					return cost;
				}
			}
		}
		return -1;
	}
	
	static boolean union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		if (ra == rb) return false;
		island2[rb] = ra;
		return true;
	}
	
	static int find(int x) {
		if (island2[x] == x) return x;
		return island2[x] = find(island2[x]);
	}

}

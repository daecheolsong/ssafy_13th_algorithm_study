import java.util.*;
import java.io.*;

public class S1_14940 {
	static int N, M;
	static int[][] grid, distance;
	static int sx, sy;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		distance = new int[N][M];
		visited = new boolean[N][M];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int  j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 2) {
					sx = i;
					sy = j;
				}
			}
		}
		
		
		bfs();
		
		for (int i = 0; i < N; i++) {
			for (int  j = 0; j < M; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					distance[i][j] = -1;
				}
				System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(sx, sy));
		visited[sx][sy] = true;
		distance[sx][sy] = 0;
		
		while (!queue.isEmpty()) {
			Point current = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nx = current.x + dx[d];
				int ny = current.y + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
				if (grid[nx][ny] == 0) continue;
				if (visited[nx][ny]) continue;
				
				queue.add(new Point(nx, ny));
				distance[nx][ny] = distance[current.x][current.y]+1;
				visited[nx][ny] = true;
			}
		}
	}
}

class Point{
	public int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


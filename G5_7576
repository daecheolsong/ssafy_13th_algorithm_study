import java.util.*;
import java.io.*;

public class G5_7576 {
	static int M, N;
	static int[][] grid;
	static Queue<Point> queue;
	static int result = 0;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 1) {
					queue.add(new Point(i, j));
				}
			}
		}
		
		bfs();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(result);
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nx = current.x + dx[d];
				int ny = current.y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || grid[nx][ny] == -1) continue;
				if (grid[nx][ny] == 0) {
					grid[nx][ny] = grid[current.x][current.y] + 1;
					queue.add(new Point(nx, ny));
					result = Math.max(grid[nx][ny]-1, result);
				}
			}
		}
	}

}

class Point {
	public int x;
	public int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

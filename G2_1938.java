import java.util.*;
import java.io.*;

public class G2_1938 {
	static int N;
	static int[][] grid;
	static boolean[][][] visited;
	static MyPoint[] b_list = new MyPoint[3];
	static MyPoint[] e_list = new MyPoint[3];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] turn0_dx = {-1, -1, -1, 1, 1, 1};
	static int[] turn0_dy = {-1, 0, 1, 1, 0, -1};
	static int[] turn1_dx = {-1, 0, 1, 1, 0, -1};
	static int[] turn1_dy = {-1, -1, -1, 1, 1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		visited = new boolean[N][N][2];
		int b_idx = 0;
		int e_idx = 0;
		
		for (int i = 0; i < N; i++) {
			String text = br.readLine();
			for (int j = 0; j < N; j++) {
				char t = text.charAt(j);
				if (t == 'B') {
					b_list[b_idx++] = new MyPoint(i, j);
					grid[i][j] = 2;
				}
				else if (t == 'E') {
					e_list[e_idx++] = new MyPoint(i, j);
					grid[i][j] = 3;
				}
				else if (t == '1') {
					grid[i][j] = 1;
				}
			}
		}
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<State> queue = new LinkedList<>();
		int bx = b_list[1].x;
		int by = b_list[1].y;
		int bdir = b_list[0].x == bx ? 0 : 1; //0: 가로, 1: 세로
		int ex = e_list[1].x;
		int ey = e_list[1].y;
		int edir = e_list[0].x == ex ? 0 : 1; //0: 가로, 1: 세로
		
		queue.add(new State(bx, by, bdir, 0));
		
		while (!queue.isEmpty()) {
			State cur = queue.poll();
			if (cur.x == ex && cur.y == ey && cur.dir == edir) {
				return cur.count;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if (check(nx, ny, cur.dir) && !visited[nx][ny][cur.dir]) {
					visited[nx][ny][cur.dir] = true;
					queue.add(new State(nx, ny, cur.dir, cur.count+1));
				}
			}
			
			if (rot_check(cur.x, cur.y, cur.dir)) {
				int ndir = 1-cur.dir;
				if (!visited[cur.x][cur.y][ndir]) {
					visited[cur.x][cur.y][ndir] = true;
					queue.add(new State(cur.x, cur.y, ndir, cur.count+1));	
				}
			}
		}
		return 0;
	}
	
	static boolean check(int x, int y, int dir) {
		if (dir == 0) { // 가로
			if (x < 0 || x >= N || y-1 < 0 || y-1 >= N || grid[x][y-1]==1) return false;
			if (x < 0 || x >= N || y < 0 || y >= N || grid[x][y]==1) return false;
			if (x < 0 || x >= N || y+1 < 0 || y+1 >= N || grid[x][y+1]==1) return false;
		}
		if (dir == 1) { // 세로
			if (x-1 < 0 || x-1 >= N || y < 0 || y >= N || grid[x-1][y]==1) return false;
			if (x < 0 || x >= N || y < 0 || y >= N || grid[x][y]==1) return false;
			if (x+1 < 0 || x+1 >= N || y < 0 || y >= N || grid[x+1][y]==1) return false;
		}
		
		return true;
	}
	
	static boolean rot_check(int x, int y, int dir) {
		if (dir == 0) {
			for (int d = 0; d < 6; d++) {
				int nx = x + turn0_dx[d];
				int ny = y + turn0_dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || grid[nx][ny] == 1) return false;
			}
		}
		
		if (dir == 1) {
			for (int d = 0; d < 6; d++) {
				int nx = x + turn1_dx[d];
				int ny = y + turn1_dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || grid[nx][ny] == 1) return false;
			}
		}
		
		return true;
	}

}

class State {
	public int x;
	public int y;
	public int dir;
	public int count;
	
	public State(int x, int y, int dir, int count) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.count = count;
	}
}

class MyPoint {
	public int x;
	public int y;
	
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

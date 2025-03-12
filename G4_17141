import java.util.*;
import java.io.*;

public class G4_17141 {
	static int N, M;
	static int[][] grid;
	static int[][] r_grid;
	static int sum;
	static int result=Integer.MAX_VALUE;
	static ArrayList<Point> list;
	static ArrayList<Point> selected = new ArrayList<>();
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][N];
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 2) {
					list.add(new Point(i, j)); //놓을 수 있는 자리 list
				}
			}
		}
		
		select(0, 0);
		System.out.println(result == Integer.MAX_VALUE? -1 : result); //초기값그대로인지 확인
	}
	
	static void select(int idx, int count) {
		if (count == M) { //M만큼 select 했다면?
			go(); //실행
			return;
		}
		if (idx >= list.size()) return;
		selected.add(list.get(idx)); //현재 idx의 point select
		select(idx+1, count+1); //select 했으므로 count+1
		selected.remove(selected.size()-1); //백트래킹
		select(idx+1, count); //현재 idx를 select 하지 않았다면?
		
	}
	
	static void go() {
		Queue<Point> queue = new LinkedList<>();
		r_grid = new int[N][N];
		visited = new boolean[N][N];
		
		sum = 0;
		
		for (Point p:selected) {
			queue.add(p); //큐에 select 추가
			visited[p.x][p.y] = true; //방문처리
		}
		
		while(!queue.isEmpty()) {
			Point current = queue.poll(); 
			int x = current.x;
			int y = current.y;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || grid[nx][ny] == 1) continue;
				r_grid[nx][ny] = r_grid[x][y]+1;
				queue.add(new Point(nx, ny));
				visited[nx][ny] = true;
				sum = Math.max(r_grid[nx][ny], sum);
			}
		}
		
		if (checkFull()) {
			result = Math.min(result, sum);
		}
		
	}
	
	static boolean checkFull() { //채워지지 않은 칸이 있는지 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] != 1 && !visited[i][j]) return false;
			}
		}
		
		return true;
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

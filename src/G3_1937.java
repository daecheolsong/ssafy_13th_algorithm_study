import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_1937 {
	static class Node{
		int x;
		int y;
		int cost;
		public Node(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		StringTokenizer st;
		for(int i = 0 ; i< N ; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j =0 ;j<N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int sol = 0;
		for(int i = 0 ; i< N ; i++) {
			for(int j = 0 ;j< N ; j++) {
				visited = new int[N][N];
				sol = Math.max(sol,  dfs(j,i));
				
			}
		}
		
		System.out.println(sol);
	}
	public static int N;
	public static int[][] map;
	public static int[][] visited;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static int dfs(int x , int y) {
		
			if(visited[y][x] !=0) return visited[y][x];
			visited[y][x] = 1;
			for(int i = 0 ; i < 4 ; i++) {				
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			if(!isRange(nextX, nextY)) {
				continue;
			}
			if(map[nextY][nextX] > map[y][x]) {
				visited[y][x] = Math.max(visited[y][x], dfs(nextX, nextY)+1);
			}
			
			
			}
			return visited[y][x];
		
		
	}
	
	public static boolean isRange(int x, int y) {
		return x>=0 && y>=0 && x<N && y<N;
	}

}

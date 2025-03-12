import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_10971 {
	
	public static int N;
	
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		StringTokenizer st;
		
		for(int i =0 ; i< N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j< N ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		sol = Integer.MAX_VALUE;
		for(int start = 0; start < N ;start++) {
			visited = new boolean[N];
			dfs(start,start,0,0);
		}
		
		System.out.println(sol);
	}
	
	public static int sol;
	
	public static void dfs(int now , int start, int cost,int count) {
		if(now==start&&count==N) {
			
			sol = Math.min(sol, cost);
			return;
		}
		
		if(count>=N) {
			return;
		}
		
		for(int to =0; to<N ; to++) {
			
			if(map[now][to]!=0&&!visited[to]) {
				visited[to] = true;
				dfs(to,start,cost+map[now][to],count+1);
				visited[to] = false;
			}
			
		}
		
	}

}

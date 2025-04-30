import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_1520 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
		    Arrays.fill(dp[i], -1);
		}
		
		for(int i = 0 ; i< N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dfs(0,0));
	}
	
	static int N, M;
	static int[][] map;
	static int[][] dp;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	static boolean isRange(int x, int y) {
		return x>=0 && y>=0 && x<M && y<N;
	}
	
	public static int dfs(int x, int y) {
		
		if(y==N-1 && x==M-1) {
			return 1;
		}
		if(dp[y][x]!=-1) {
			return dp[y][x];
		}
		dp[y][x]=0;
		
		for(int i = 0; i< 4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			
			if(!isRange(nextX, nextY)) {
				continue;
			}
			
			if(map[nextY][nextX]<map[y][x]) {
				dp[y][x]+= dfs(nextX,nextY);
			}
		}
		
		return dp[y][x];
		
	}

}

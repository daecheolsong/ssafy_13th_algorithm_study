import java.util.*;
import java.io.*;

public class SW_1949 {
	
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0}, dy = {0, 1, 0, -1};
	static int N, K, maxLength, mountains[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			maxLength  = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			mountains = new int[N][N];
			visited = new boolean[N][N];
			int max = 0;
			
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					mountains[j][k] = Integer.parseInt(st.nextToken());
					if (mountains[j][k] > max) {
						max = mountains[j][k];
					}
				}
			}
			for (int i=0; i<N; i++) {
				for (int j=0; j <N; j++) {
					if (mountains[i][j] == max) {
						visited[i][j] = true;
						dfs(i,j, max, 1, 0);
						visited[i][j]=false;
					}
				}
			}
			System.out.println("#"+test_case+" "+maxLength);
		}
		
	}
	
	public static void dfs(int x, int y, int height, int length, int shave) {
		for (int d = 0; d < 4; d++) {
			if (maxLength < length) {
				maxLength = length;
			}
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
				continue;
			}
			if (height <= mountains[nx][ny]) {
				if (shave == 0) {
					if (height > mountains[nx][ny]-K) {
						visited[nx][ny] = true;
						dfs(nx,ny,height-1,length+1, shave+1);
						visited[nx][ny] = false;
					}
				}
				
			}
			else {
				visited[nx][ny] = true;
				dfs(nx, ny, mountains[nx][ny],length+1, shave);
				visited[nx][ny]=false;
			}
		}
	}

}

import java.util.*;
import java.io.*;

public class G5_2096 {
	static int N;
	static int[][] grid;
	static int[][] dp_min;
	static int[][] dp_max;
	static int[] dy = {-1, 0, 1};
	static int min = Integer.MAX_VALUE;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new int[N][3];
		dp_min = new int[N][3];
		dp_max = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				dp_min[i][j] = Integer.MAX_VALUE;
			}
		}
		
		go_dp();
		
		for (int i = 0; i < 3; i++) {
			if(dp_min[N-1][i] < min) min = dp_min[N-1][i];
			if(dp_max[N-1][i] > max) max = dp_max[N-1][i];
		}
		
		System.out.println(max + " " + min);
	}
	
	static void go_dp() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if(i==0) {
					dp_min[i][j] = grid[i][j];
					dp_max[i][j] = grid[i][j];
				}
				else {
					for (int d = 0; d < 3; d++) {
						int nj = j + dy[d];
						if(nj >= 0 && nj < 3) {
							dp_min[i][j] = Math.min(dp_min[i][j], dp_min[i-1][nj] + grid[i][j]);
							dp_max[i][j] = Math.max(dp_max[i][j], dp_max[i-1][nj] + grid[i][j]);
						}
					}
				}
			}
		}
	}

}

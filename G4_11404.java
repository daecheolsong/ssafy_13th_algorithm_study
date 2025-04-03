import java.util.*;
import java.io.*;

public class G4_11404 {
	static int n, m;
	static int[][] dp;
	
	static void initadj() {
		for(int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == j) dp[i][j] = 0;
				else dp[i][j] = 987654321;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		dp = new int[n+1][n+1];
		initadj();
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			dp[x][y] = Math.min(dp[x][y], w);
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print((dp[i][j] == 987654321 ? 0 : dp[i][j]) + " ");
			}
			System.out.println();
		}
	}

}

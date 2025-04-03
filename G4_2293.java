import java.util.*;
import java.io.*;

public class G4_2293 {
	static int[][] dp;
	static int n, k;
	static int[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[n+1][k+1];
		list = new int[n+1];
		for (int i = 1; i <= n; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 1; i <= n; i++) {
			dp[i][0] = 1;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j < list[i]) {
					dp[i][j] = dp[i-1][j];
					continue;
				}
				else dp[i][j] = dp[i-1][j] + dp[i][j-list[i]];
			}
		}
//		
//		for (int i = 0; i <= n; i++) {
//			for (int j = 0; j <= k; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(dp[n][k]);
	}

}

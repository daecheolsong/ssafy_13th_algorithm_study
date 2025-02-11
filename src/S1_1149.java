import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N+1][3];
		
		StringTokenizer st;
		for(int i = 1; i <= N ; i++ ) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		int[][] dp = new int[N+1][3];
		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[0][2] = 0;
		
		
		for(int i = 1; i<=N ; i++) {
			
			dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+map[i][0];
			dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+map[i][1];
			dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+map[i][2];
			
		}
		
		
//		for(int i=0; i<N+1 ; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i =0 ; i<3 ; i++) {
			min = Math.min(min, dp[N][i]);
		}
		
		System.out.println(min);
		
	}

}

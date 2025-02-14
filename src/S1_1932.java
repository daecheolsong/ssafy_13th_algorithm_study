import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_1932 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		StringTokenizer st;
		int[][] dp = new int[N][N];
		
		
		for(int i=0; i<N ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		dp[0][0] = arr[0][0];
		
		for(int i=1; i< N ;i++) {
		
			for(int j = 0 ; j<=i ;j++) {
				if(j==0) {
					dp[i][0] = dp[i-1][0]+arr[i][0];
				}else if(j==i) {
					dp[i][j] = dp[i-1][j-1]+arr[i][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + arr[i][j];
				}
				
			}
			
		}
		
//		for(int i=0; i<N ; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		
		int max =0;
		
		for(int i=0 ; i<N ;i++) {
			max = Math.max(dp[N-1][i],max);
		}
		
		System.out.println(max);
		
		                                 

	}

}

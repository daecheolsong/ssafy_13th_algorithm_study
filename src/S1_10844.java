import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_10844 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[10][N+1];
		
		
		
		for(int i=1; i< 10; i++ ) {
			dp[i][1] = 1; 
		}
		
		
		
		
		for(int i=2; i <= N ; i++) {
			
			for(int j=0;j<10;j++) {
				
				if(j==9) {
					dp[j][i] = dp[j-1][i-1];
				}else if(j==0) {
					dp[j][i] = dp[j+1][i-1];
				}
				else {
					dp[j][i] = (dp[j-1][i-1] + dp[j+1][i-1]);				
				}
				
				dp[j][i]%=1000000000;
				
			}
		}
		
//		for(int i=0; i<10 ; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
//		
		long sol = 0;
		for(int i=0 ; i<=9 ;i++) {
			sol = (sol + dp[i][N])%1000000000;
		}
		
		System.out.println(sol);
	}

}

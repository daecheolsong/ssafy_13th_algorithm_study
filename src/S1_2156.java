import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N ; i++ ) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
//		int[][] dp = new int[N][2];
//		
//		dp[0][0] = arr[0];
//		
//		for(int index =1; index<N ; index++) {
//			dp[index][0] = Math.max(dp[index-1][1] , arr[index]);
//			dp[index][1] = dp[index-1][0] + arr[index];
//		}
//			
//		for(int i=0; i< N ; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
//		
//		int i =0;
		
		
		int[][] dp = new int[N][3];
		
		dp[0][1] = arr[0];
		
		for(int index = 1; index < N ; index++) {
			dp[index][0]=Math.max(dp[index-1][0],Math.max(dp[index-1][1],dp[index-1][2]));
			if(index>1) {
				dp[index][0] = Math.max(dp[index][0], dp[index-2][0]);
			}
			dp[index][1]=dp[index-1][0]+ arr[index];
			dp[index][2]=dp[index-1][1]+arr[index];
		}
		int sol =0;
		for(int i=0; i< 3 ; i++) {
			//System.out.println(Arrays.toString(dp[i]));
			sol = Math.max(sol, dp[N-1][i]);
		}
		
		System.out.println(sol);

	}

}

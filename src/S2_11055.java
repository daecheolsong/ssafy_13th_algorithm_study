import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_11055 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i< N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		
		
		for(int i=0; i< N ; i++) {
			//int maxDpSum=0;
			for(int j=0; j<i ;j++) {
				if(arr[j]<arr[i]) {
					//maxDpSum = Math.max(maxDpSum, dp[j]);
					dp[i] = Math.max(dp[j]+arr[i], dp[i]);
				}
				
			}
			
			//dp[i] = arr[i]+maxDpSum;
		}
		
		int maxSum =0;
		for(int i=0; i<N ; i++) {
			maxSum = Math.max(maxSum, dp[i]);
		}
		
		System.out.println(maxSum);
		

	}

}

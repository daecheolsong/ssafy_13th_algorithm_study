import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dp = new int[N];
		int[] arr = new int[N];
		
		for(int i=0; i < N ;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] =1;
		}
		
		
	
		for(int i=0; i<N ; i++) {
			int max =0;
			for(int j=0; j<i ;j++) {
				if(arr[j] < arr[i]) {
					max = Math.max(max, dp[j]);
					dp[i]=max+1;
				}
				
			}
		}
		
		//System.out.println(Arrays.toString(dp));
		int sol =0;
		for(int i=0; i<N ; i++) {
			sol = Math.max(sol, dp[i]);
		}
		System.out.println(sol);

	}

}

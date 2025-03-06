import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_2293 {
	
	static int n, k;
	static int[] arr, dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		dp = new int[k + 1];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < n; i++) {
			if (arr[i] > k) break;
			
			dp[arr[i]]++;
			for (int j = arr[i]; j <= k; j++) {
				dp[j] = dp[j] + dp[j - arr[i]];		
			}
		}
		
		System.out.println(dp[k]);
	}
}

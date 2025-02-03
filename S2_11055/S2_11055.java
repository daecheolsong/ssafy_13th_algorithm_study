import java.util.*;
import java.io.*;
/**
 * @author daecheolsong
 */
public class S2_11055 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [] arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		int [] dp = new int[n + 1];
		dp[1] = arr[1];
		
		
		for(int i = 2; i <= n; i ++) {
			dp[i] = arr[i]; // 비교 기준
			
			for(int j = 1; j < i ; j ++) {
				if(arr[i] > arr[j] /* 비교 기준보다 현재 수가 작으면 */) {
					dp[i] = Math.max(dp[j] + arr[i], dp[i]); // 현재수를 이제까지 더한값에 추가.
				}
			}
		}
		
		for(int i = 1; i <= n ; i ++) {
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
		
	}

}

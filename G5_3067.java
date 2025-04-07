import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_3067 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while (T --> 0) {
			int n = Integer.parseInt(br.readLine());
			int[] coins = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			
			int m = Integer.parseInt(br.readLine());
			int[] dp = new int[m + 1];
		
			for (int i = 0; i < n; i++) {
				for (int j = 1; j <= m; j++) {
					if (j - coins[i] > 0) {
						dp[j] += dp[j - coins[i]];
					} else if (j - coins[i] == 0) {
						dp[j]++;
					}
				}
			}
			
			sb.append(dp[m]).append("\n");
		}
		System.out.println(sb);
	}
}

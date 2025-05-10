import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int T, N, dp[];

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			init();
			fibo(N);
		}
		System.out.println(sb);
	}


	private static void fibo(int n) {
		if(n == 0) {
			sb.append(1).append(" ").append(0).append("\n");
			return;
		}else if(n == 1) {
			sb.append(0).append(" ").append(1).append("\n");
			return;
		}else {
			for(int i = 2; i <= N; i++) {
				dp[0] = 0;
				dp[1] = 1;
				dp[i] = dp[i - 1] + dp[i - 2]; 
			}
			sb.append(dp[n-1]).append(" ").append(dp[n]).append("\n");
			return;
		}
		
	}


	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
	}

}

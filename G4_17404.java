import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class G4_17404 {
	
	static int n;
	static int[][] arr;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][3];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n + 1][3];
		int answer = Integer.MAX_VALUE;
		for (int t = 0; t < 3; t++) {
			// 초기화
			for (int i = 0; i < 3; i++) {
				if (i == t) dp[1][i] = arr[1][i];
				else dp[1][i] = 1_000_000;
			}
			
			for (int i = 2; i <= n; i++) {
				for (int j = 0; j < 3; j++) {
					dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + arr[i][j];
				}
			} 
			
			for (int i = 0; i < 3; i++) {
				if (i == t) continue;
				answer = Math.min(dp[n][i], answer);
			}
		}
		
		System.out.println(answer);
	}
}


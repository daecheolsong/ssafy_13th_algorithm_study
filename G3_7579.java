import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_7579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());	// 확보해야하는 메모리
		int[] m = new int[n];	// 각 앱이 m 바이트 만큼 메모리 사용
		int[] c = new int[n];  	// 각 앱을 다시 실행할 경우 드는 비용
		int answer = Integer.MAX_VALUE;
		int[][] dp = new int[n][10001];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		
		// m 바이트 이상 메모리 확보 필요, 그 중의 비용 최소합
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= 10000; j++) {
				// 첫번째 앱을 확인할 경우
				if (i == 0) {
					// 확인하는 cost가 해당 앱 비용보다 클 경우 dp 업데이트
					if (j >= c[i]) dp[i][j] = m[i];
				} 
				else {
					// 확인하는 cost가 해당 앱 비용보다 클 경우 dp 업데이트
					if (j >= c[i]) {
						// 현재 앱을 포함 시키지 않을 경우와 포함한 경우의 값 비교
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i]] + m[i]);
					} 
					// 확인하는 cost가 해당 앱 비용보다 작을 경우 이전 값 가져옴 
					else {
						dp[i][j] = dp[i - 1][j];
					}
				}

				// 현재까지 확보한 메모리가 M보다 클 경우 cost 확인
				if (dp[i][j] >= M) {
					answer = Math.min(answer, j);
				}
			}
		}
		

		System.out.println(answer);
	}
}

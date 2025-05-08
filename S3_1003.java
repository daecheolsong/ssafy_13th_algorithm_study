import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N, T;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		int[][] dp = new int[41][2];
		
		// 초기값 설정
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		// DP 테이블 초기화
		for (int i = 2; i < 41; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}
		
		// 테케마다 0 출력 횟수, 1 출력 횟수 구붛내서 출력
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			sb.append(dp[N][0]+" "+dp[N][1]+"\n");
		} 
		
		System.out.println(sb);
	}

}

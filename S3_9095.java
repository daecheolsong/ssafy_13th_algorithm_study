import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 테스트 케이스 개수 입력
        int T = Integer.parseInt(br.readLine());
        
        // dp 배열 초기화 (최대 n은 10)
        int[] dp = new int[11];
        dp[1] = 1; // 1 = (1)
        dp[2] = 2; // 2 = (1+1, 2)
        dp[3] = 4; // 3 = (1+1+1, 1+2, 2+1, 3)
        
        // DP 배열 채우기
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
      
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        
        // 결과 출력
        System.out.print(sb);
    }
}

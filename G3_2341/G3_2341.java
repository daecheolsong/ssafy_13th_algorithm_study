import java.io.*;
import java.util.*;

public class G3_2341 {
    public static void main(String[] args) throws Exception {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        
        
        int[] levels = {1, 86, 172, 256};
        String[] codes = {"00", "01", "10", "11"};
        int M = 4;
        
        // dp[i][j]: 0 ~ i번째까지 고려했을 때, i번째를 levels[j]로 변환하는 경우의 최소 비용
        // 비용 = (누적 에러 합) + W * (코드 길이)
        long[][] dp = new long[N][M];
        // 각 dp값의 경로를 저장할 prev 배열 (복원에 사용)
        int[][] prev = new int[N][M];
        
        // 첫 번째 수: 무조건 2-bit 코드 사용
        for (int j = 0; j < M; j++) {
            dp[0][j] = Math.abs(input[0] - levels[j]) + (long)W * 2;
            prev[0][j] = -1; // 첫번째는 이전 상태가 없음
        }
        
        // DP 진행: i번째 수를 변환할 때, 이전 상태(i-1)의 선택에 따라 코드 길이가 달라짐
        // 만약 이전과 같은 레벨이면 1비트("0"), 다르면 1비트("1") + 2비트(새 레벨의 코드)를 사용
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = Long.MAX_VALUE;
                for (int k = 0; k < M; k++) {
                    // 전환 비용: 같은 값이면 1비트, 다르면 3비트
                    long transitionCost = (j == k ? W * 1L : W * 3L);
                    long candidate = dp[i-1][k] + Math.abs(input[i] - levels[j]) + transitionCost;
                    if (candidate < dp[i][j]) {
                        dp[i][j] = candidate;
                        prev[i][j] = k;
                    }
                }
            }
        }
        
       
        long minCost = Long.MAX_VALUE;
        int bestIndex = -1;
        for (int j = 0; j < M; j++) {
            if (dp[N-1][j] < minCost) {
                minCost = dp[N-1][j];
                bestIndex = j;
            }
        }
        
        
        int[] chosen = new int[N];
        chosen[N-1] = bestIndex;
        for (int i = N - 1; i >= 1; i--) {
            chosen[i-1] = prev[i][chosen[i]];
        }
        
     
        StringBuilder sb = new StringBuilder();
        sb.append(codes[chosen[0]]);
        for (int i = 1; i < N; i++) {
            if (chosen[i] == chosen[i-1]) {
                sb.append("0");
            } else {
                sb.append("1").append(codes[chosen[i]]);
            }
        }
        
       
        System.out.println(minCost);
        System.out.println(sb.toString());
    }
}

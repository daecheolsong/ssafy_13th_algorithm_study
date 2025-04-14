import java.util.*;
import java.io.*;

public class G5_2294 {
    static int N, M;
    static int[] dp;
    static int[] coins;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);

        dp = new int[M + 1];

        Arrays.fill(dp, 100000);
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = coin; j <= M; j++) {
                if (dp[j - coin] != 100000) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }

        if (dp[M] == 100000) {
            System.out.println(-1);  // 만들 수 없는 경우
        } else {
            System.out.println(dp[M]);  // 최소 동전 개수
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int testCase = 0; testCase < N; testCase++) {
            int M = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][M+1];
            int[][] arr = new int[2][M+1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <=M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1]=arr[0][1];
            dp[1][1] = arr[1][1];




            for (int j = 2; j <= M; j++) {
                    for (int i = 0; i < 2; i++) {
                    dp[i][j]=Math.max(Math.max(dp[i][j-2],dp[i^1][j-1]),dp[i^1][j-2])+arr[i][j];

                }
            }

                System.out.println(Math.max(dp[0][M],dp[1][M]));




        }
    }
}

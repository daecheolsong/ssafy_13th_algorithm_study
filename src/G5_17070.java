

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_17070 {

    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    map = new int[N][N];
    StringTokenizer st;

    for(int i =0 ;i <N ; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j =0; j < N ; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    int[][] dp = new int[N][N];

    int[][] dp1 = new int[N][N];

    int[][] dp2 = new int[N][N];

    dp[0][0] = 0;
    dp[0][1] = 1;


    for(int j = 1 ;j < N ; j++) {
        for(int i = 0; i< N ;i++) {

            if(map[i][j]==0) {
                if (isRange(j - 1, i)) {
                    dp[i][j] += dp[i][j - 1];
                    dp[i][j] += dp1[i][j - 1];
                }


                
                if (isRange(j - 1, i - 1)) {
                    if (map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                        dp1[i][j] += dp1[i - 1][j - 1];
                        dp1[i][j] += dp[i - 1][j - 1];
                        dp1[i][j] += dp2[i - 1][j - 1];
                    }


                }

                if (isRange(j, i - 1)) {
                    dp2[i][j] += dp1[i - 1][j];
                    dp2[i][j] += dp2[i - 1][j];
                }
            }



        }

    }
        System.out.println(dp[N-1][N-1]+dp1[N-1][N-1]+dp2[N-1][N-1]);



}




public static boolean isRange(int x , int y) {

    return x>=0 && y>=0 && x<N && y<N;

}
}

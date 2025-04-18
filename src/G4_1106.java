
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int target = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[100000+1];
        
        int[] score = new int[N+1];
        int[] count = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
            count[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <=N ; i++) {
            for(int j = score[i]; j<dp.length ; j++){

                dp[j] =Math.max(dp[j], dp[j-score[i]] + count[i]);

            }
        }

        //System.out.println(Arrays.toString(dp));



        for (int i = 0; i < dp.length; i++) {
            if(dp[i]>=target ){
                System.out.println(i);
                break;
            }
        }
    }
}

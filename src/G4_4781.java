import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_4781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            double M_double = Double.parseDouble(st.nextToken());

            if (N == 0 && M_double == 0.00) break;

            int M = (int) Math.round(M_double * 100); 

            int[] cal = new int[N];
            int[] price = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                cal[i] = Integer.parseInt(st.nextToken());
                double money = Double.parseDouble(st.nextToken());
                price[i] = (int) Math.round(money * 100); 
            }

            int[] dp = new int[M + 1];

            for (int i = 0; i < N; i++) {
                for (int j = price[i]; j <= M; j++) {
                    dp[j] = Math.max(dp[j], dp[j - price[i]] + cal[i]);
                }
            }

            System.out.println(dp[M]);
        }
    }
}

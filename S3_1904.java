import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
    static int N ,result;
    static int[] dp;
    public static void main(String[] args) throws IOException {
          init();
          dp();
        System.out.print(sb);
    }
    
    private static void dp() {

        if (N == 1) {
            sb.append(1);	
            return;
        } else if (N == 2) {
        	sb.append(2);	
            return;
        }
        
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i<= N; i++) {
        	dp[i] =(dp[i - 1] + dp [i - 2]) % 15746;
        }
        
        sb.append(dp[N]);
	}

	private static void init() throws IOException {
    	 N = Integer.parseInt(br.readLine());
    	 dp = new int[N + 1];
	}


}

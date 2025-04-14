import java.util.*;
import java.io.*;


public class G3_15483 {
	
	static int [][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		
		dp = new int [s1.length() + 1][s2.length() + 1];
		
		
		for(int i = 1; i <= s2.length(); i ++) {
			dp[0][i] = i;
		}
		
		for(int i = 1; i <= s1.length(); i ++) {
			dp[i][0] = i;
		}
	
		
		for(int i = 1; i <= s1.length(); i ++) {
			for(int j = 1; j <= s2.length(); j ++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1]; 
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]) + 1;
				}
			}
		}
		
		System.out.println(dp[s1.length()][s2.length()]);
	}
}

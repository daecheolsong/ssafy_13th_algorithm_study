import java.util.*;
import java.io.*;

public class G4_9252 {

	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String text1 = br.readLine();
		String text2 = br.readLine();
		dp = new int[text1.length()+1][text2.length()+1];
		
		LCS(text1, text2);
		LCStext(text1, text1.length(), text2.length());
		
		System.out.println(sb);

	}
	
	static void LCS(String str1, String str2) {
		int n1 = str1.length();
		int n2 = str2.length();
		int max = -1;
		for (int i = 1; i < n1 +1; i++) {
			for (int j = 1; j < n2 + 1; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		sb.append(dp[n1][n2] + "\n");
	}
	
	static void LCStext(String str, int i, int j) {
		Stack<Character> st = new Stack<>();
		while(i>0 && j > 0) {
			if(i==0 || j == 0) break;
			
			if(dp[i][j] == dp[i-1][j]) {
				i--;
			}
			else if (dp[i][j] == dp[i][j-1]) {
				j--;
			} else {
				st.push(str.charAt(i-1));
				i--;
				j--;
			}
		}
		
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
	}
 
}

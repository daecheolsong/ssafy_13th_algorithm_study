import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = br.readLine().toCharArray(); //1번 string 받음
		char[] str2 = br.readLine().toCharArray(); //2번 string 받음
		
		int[][] dp = new int[str1.length+1][str2.length+1]; //dp 배열 선언
		
		for(int i = 1; i <= str1.length; i++) { //1번 글자열 기준으로 2번 글자열과 돌면서 비교
			for(int j = 1; j <= str2.length; j++) {
				if (str1[i-1]==str2[j-1]) { //dp인덱스는 1부터 저장하게 하였으므로 str의 인덱스에서 -1
					dp[i][j] = dp[i-1][j-1] + 1; //만약 글자가 같다면 대각선 (둘 다 들어오지 않았을때의 최댓값)에서 +1
				} else { 
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]); //같은 글자가 없다면 둘중 한개가 없는 값들 중에 최댓값
				}
			}
		}
		System.out.println(dp[str1.length][str2.length]);
		
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_18427 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] map1 = new ArrayList[N];
		
		
		for(int i =0 ; i<map1.length ; i++) {
			map1[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				map1[i].add(Integer.parseInt(st.nextToken()));
			}
			
			
		}
		
		int dp[][] = new int[N+1][H+1];
		dp[0][0] = 1;
		
//		for(int i = 0; i < N ; i++) {
//			System.out.println(map1[i]);
//		}
		
			
			for(int student = 1; student<=N ; student++) {
					for(int i = 0; i<=H ; i++) {
						dp[student][i] = dp[student-1][i];
						for(int height : map1[student-1]) {
					if(i-height>=0) {
						dp[student][i] = (dp[student][i]+ dp[student-1][i-height])%10007;						
					}
				}
			}
			
		}
		System.out.println(dp[N][H]);
	}

}

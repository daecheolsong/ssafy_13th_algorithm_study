import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_14728 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		
		int[] time = new int[N+1];
		int[] score = new int[N+1];
		
		for(int i = 1; i<= N ; i++) {
			st = new StringTokenizer(br.readLine());
			
			time[i] = Integer.parseInt(st.nextToken());
			score[i] = Integer.parseInt(st.nextToken());
			
		}
		
		//int[][] dp = new int[T+1][10000+1];
		
		
//		for(int i = 1 ; i <= N ; i++) {
//			for(int j = 0; j<= T ; j++) {
//				
//				//해당 과목을 공부하지 않은 경우의 수
//				int a = dp[i-1][j];
//				
//				//해당 과목을 공부한 경우의 수
//				
//				if(j-time[i]>=0) {
//				int b = dp[i-1][j-time[i]]+score[i];
//				
//				dp[i][j] = Math.max(a, b);
//				}else {
//					dp[i][j] = a;
//				}
//				
//			}
//		}
		
		//System.out.println(dp[N][T]);
		
		int[] dp = new int[100000+1];
		
		for(int i = 1 ; i <=N ; i++) {
			for(int j = T; j>=time[i] ; j--) {
				
				dp[j] = Math.max(dp[j], dp[j-time[i]]+score[i]);
			}
		}
		
		System.out.println(dp[T]);
	}

}

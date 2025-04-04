import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_17845 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int maxTime = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[K+1][maxTime+1];
		
		int[] score = new int[K+1];
		int[] time = new int[K+1];
		
		
		for(int i = 1 ; i<= K ; i++) {
			st = new StringTokenizer(br.readLine());
			score[i] = Integer.parseInt(st.nextToken());
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1 ; i < K+1 ; i++) {
			
			for(int j = 0; j<maxTime+1 ; j++) {
				
				int a = dp[i-1][j];//포함하지 않은 경우의 가장 높은 합!1
				
				if(time[i]<=j) {// 현재 i를 포함이 가능할때
					int b = dp[i-1][j-time[i]]+score[i];
					//System.out.println(b);
					dp[i][j] = Math.max(a, b);
					
				}else {// 현재 i를 포함시키지 못할때
					
					dp[i][j] = a;
				}
				
			}
			
		}
		System.out.println(dp[K][maxTime]);
		
	}

}

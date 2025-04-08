import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] memory = new int[N+1];
		int[] cost = new int[N+1];
		int totalCost=  0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			totalCost += cost[i];
		}
		
		int[][] D = new int[N+1][10001];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= 10000; j++) {
				
				if(cost[i]<=j) {
					D[i][j] = Math.max(D[i-1][j], D[i-1][j - cost[i]] + memory[i]);
				} else {
					D[i][j] = D[i-1][j];
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int j = 0; j <= 10000; j++) {
			if(D[N][j]>=M) {
				min = j;
				break;
				
			}
		}
		System.out.println(min);
	}
}

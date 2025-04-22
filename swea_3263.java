import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, ans;
	static int[] arr; 
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			int ans = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int v = Integer.parseInt(st.nextToken());
				arr[v] = arr[v-1] + 1;
				
				if(ans < arr[v]) {
					ans = arr[v];
				}
			}
			sb.append("#").append(tc).append(" ").append(N-ans).append("\n");
			
		}
		System.out.println(sb);
	}
}

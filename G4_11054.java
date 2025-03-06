import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_11054 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp1 = new int[n];
		int[] dp2 = new int[n];
		
		for (int i = 0; i < n; i++) {
			dp1[i] = 1;
			dp2[n - 1 - i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp1[j] + 1 > dp1[i]) {
					dp1[i] = dp1[j] + 1;
				}
				
				if (arr[n - 1 - j] < arr[n - 1 - i] && dp2[n - 1 - j] + 1 > dp2[n - 1 - i]) {
					dp2[n - 1 - i] = dp2[n - 1 - j] + 1;
				}
			}
			
		}
		
		int answer = 0;
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, dp1[i] + dp2[i]);
		}
		
		System.out.println(answer - 1);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_27172 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] pos = new int[1_000_001];
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) { 
			arr[i] = Integer.parseInt(st.nextToken());
			pos[arr[i]] = i + 1;
			max = Math.max(arr[i], max);
		}
		
		int[] answer = new int[n];
		for (int x : arr) {
			for (int i = x * 2; i <= max; i += x) {
				if (pos[i] != 0) {
					answer[pos[i] - 1]--;
					answer[pos[x] - 1]++;
				}
			}
		}
		
		for (int i : answer) {
			sb.append(i).append(" ");
		}

		System.out.println(sb);
	}
}

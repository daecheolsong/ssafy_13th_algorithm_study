import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1806 {

	static int n, s;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		arr = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		int front = 0;
		int end = 1;
		int minLength = n + 1;
		while (front < n) {
			if (arr[end] - arr[front] >= s) {
				minLength = Math.min(end - front, minLength);
				front++;
			} else {
				if (end < n) {
					end++;
				} else {
					break;
				}
			}
		}
		
		System.out.println(minLength == n + 1 ? 0 : minLength);
	}
}

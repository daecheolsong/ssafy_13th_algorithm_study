import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_2110 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int start = 1;
		int end = arr[n - 1] - arr[0] + 1;
		
		while (start < end) {
			int mid = (start + end) / 2;
			int prev = arr[0];
			int count = 1;
			
			for (int i = 1; i < n; i++) {
				if (arr[i] - prev >= mid) {
					prev = arr[i];
					count++;
				}
			}
			
			if (count >= m) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		
		System.out.println(start - 1);
	}
}

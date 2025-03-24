import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_2467 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = 0;
		int max = n - 1;
		int minSum = Integer.MAX_VALUE;
		int v1 = 0, v2 = 0;
		
		while (min < max) {
			int sum = arr[min] + arr[max];
			
			if (minSum > Math.abs(sum)) {
				minSum = Math.abs(sum); 
				v1 = arr[min];
				v2 = arr[max];
			}
			
			if (sum < 0) {
				min++;
			} else {
				max--;
			}
		}
		
		System.out.println(v1 + " " + v2);
	}
}

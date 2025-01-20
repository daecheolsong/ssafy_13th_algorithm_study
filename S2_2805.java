import java.io.*;
import java.util.*;

class S2_2805 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
	
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		int min = 0;
		int max = Integer.MIN_VALUE;
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}		
		
		while (min < max) {
			int mid = (min + max) / 2;
			
			long sum = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] > mid) {
					sum += arr[i] - mid;
				}
 			}

			if (sum < m) {
				max = mid;
			} else {
				min = mid + 1;
			}			
		}
		
		System.out.print(min - 1);
	}
}

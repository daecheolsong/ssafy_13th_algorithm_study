import java.io.*;
import java.util.*;

class S2_1654 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
	
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[k];
		
		long max = 0;
		long min = 0;
		for (int i = 0; i < k; i++) {
			arr[i] = Long.parseLong(bf.readLine());
			max = Math.max(max, arr[i]);
		}
		max++;
		long answer = 0;
		while (min < max) {
			long mid = (min + max) / 2;
			long sum = 0;
			
			for (int i = 0; i < k; i++) {
				sum += arr[i] / mid;
			}
			
			if (sum >= n) {
				answer = Math.max(answer, mid);
			}
			
			/**
			 * sum < n?
			 * → mid의 크기가 크므로 max를 줄임
			 * sum > n?
			 * → mid의 크기가 작으므로 min을 키움
			 */
			if (sum < n) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		if (answer == 2147483646) {
			answer = 2147483647;
		}
		
		System.out.println(answer);
	}
}

import java.util.*;
import java.io.*;


public class G5_3079 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		int n = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());
		long max = 0;
		int [] arr = new int [n];
		for(int i = 0; i < n; i ++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		long s = 0;
		long e = max * m; // m 명이 기다릴 수 있는 최대 시간 
		long answer = Long.MAX_VALUE;
		
		while(s <= e) {
			long mid = (s + e) / 2;
			
			long sum = 0;
			for(int i = 0; i < n; i ++) {
				// overflow 주의 
				if(sum >=  m) {
					break;
				}
				sum += mid / arr[i];
			}
			// lower bound, m 이 나오는 첫 위치
			if(sum >= m) {
				e = mid - 1;
				answer = Math.min(answer, mid);
			} else {
				s = mid + 1;
				
			}
			
		}
		System.out.println(answer);
		
		
	}
	
}

import java.io.*;
import java.util.*;

public class G4_2110 {

	static int [] h;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		h = new int[n];
		
		int s = 0;
		int e = 0;
		for(int i = 0; i < n; i ++) {
			h[i] = Integer.parseInt(br.readLine());
			e = Math.max(e, h[i]);
		}
		
		Arrays.sort(h);
		
		int answer = 0;

		while(s <= e) {
			int mid = (s + e) / 2;
			
			int distance = mid; // 설치된 공유기 간격의 최소 길이
			
			int count = 1; // 설치된 공유기 수
			int start = h[0]; 
			
			for(int i = 1; i < h.length; i ++) {
				int diff = h[i] - start;
				
				// 간격의 최소길이보다 클떄만 공유기 설치
				if(diff >= distance) {
					count++;
					start = h[i];
				}
			}
			if(count < c) {
				e = mid - 1;
			} else {
				answer = mid;
				s = mid + 1;
			}
		}
		
		System.out.println(answer);
		
		
	}
}

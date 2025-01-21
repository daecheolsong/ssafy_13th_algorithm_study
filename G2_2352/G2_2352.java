import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> ascend = new ArrayList<>();
		ascend.add(arr[0]);
		
		for(int i = 1; i < n ; i ++) {
			if(arr[i] <= ascend.get(ascend.size() - 1)) {
				int s = 0;
				int e = ascend.size() - 1;
				
				while(s < e) {
					int mid = (s + e) / 2;
					if(ascend.get(mid) >= arr[i]) {
						e = mid;
					} else {
						s = mid + 1;
					}
 				}
				
				int pos = s;
				ascend.set(pos, arr[i]);
				continue;
			} 
			ascend.add(arr[i]);
		}
		System.out.println(ascend.size());
	}
	
}
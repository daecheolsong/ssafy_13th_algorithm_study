import java.util.*;
import java.io.*;

public class Main {
	/**
	 * 6
	 * 4 2 6 3 1 5
	 * 증가수열 만들 시, 현재 증가 수열 마지막원소보다 현재원소가 크다면 증가수열에 추가해주고,
	 * 그렇지 않다면 현재 증가 수열에서 현재원소가 들어갈 곳을 이분탐색으로 찾아 대체합니다.
	 * 길이만 구하면 되기 때문에, 현재 증가수열 첫번째원소보다 더 작은 원소를 넣을시, 첫번째 원소를 대체 하더라도
	 * 길이가 변하지 않고, 어차피 현재 증가수열이라는 전제는 유지 되기 때문에 논리적으로 문제가 되지 않습니다. 
	 * @param args
	 * @throws Exception
	 */
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
import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class SWEA_14510 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc ++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			
			int [] arr = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			int maxHeight = 0;
		
			for(int i = 0; i < n; i ++) {
				arr[i] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, arr[i]);
			}
			
			int sum = 0; // 총 성장해야할 길이
			int requireOdd = 0; // 실제 성장해야할 길이의 홀수의 개수, 홀수가 존재하면 그 개수만큼 홀수날이 필요합니다.
			for(int i = 0; i < n ; i ++) {
				if(arr[i] > 0) {
					int diff = Math.abs(maxHeight - arr[i]); // 각 나무당 성장해야할 길이
					sum += diff; 
					if(diff % 2 == 1) {
						requireOdd ++;
					}
				}
			}
	
			int answer = 0;
			int idle = (sum / 3) * 2 + sum % 3; // 총 성장해야할 길이로부터 도출한 모두 성장해야하는데 필요한 날의 최소값, 이상적으로 모든 성장에 소요되는 날
	
			int idleOdd = idle / 2 + idle % 2; // 이상적으로 모든 성장에 소요되는 날에서 홀수날의 개수
			// 성장해야할 길이가 짝수인 경우는 고려하지 않아도 된다. 필요한 홀수날 만큼 짝수날도 고려하기 때문
			
			if(requireOdd <= idleOdd) { // 실제 성장해야할 길이의 홀수의 개수(실제 필요한 홀수 날)보다 이상적인 날에서 필요한 홀수날의 개수가 크면
				answer = idle; // 이상적으로 필요한 소요되는 날이 정답
			} else {
				answer = requireOdd * 2 - 1; // 실제 성장해야할 길이의 홀수의 개수에서 2배(짝수날과 한쌍) 값에서 짝수날 하루를 뺸값이 정답.
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
		
	}
	
}

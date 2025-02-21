package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1225_신준호 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < 10; t++) {
			int T = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[8];
			int[] result = new int[8];
			for(int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
 			 int minus = 1;
			while(true) {
				
				result[7] = arr[0] - minus;
				if(result[7] <= 0) {
					for(int i = 1; i <= 7; i++) {
						result[i - 1] = arr[i];
						result[7] = 0;
					}
					break;
				}
				
				for(int i = 1; i <= 7; i++) {
					result[i - 1] = arr[i];
				}
				
				minus++;
				if(minus == 6) minus = 1;
				for(int i = 0; i< 8; i++) {
					arr[i] = result[i];
				}
			}
			sb.append("#"+T+" ");
			for (int i = 0; i < 8; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

}

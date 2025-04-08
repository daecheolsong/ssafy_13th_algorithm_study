package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {


	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int sum = 0;
					for(int nr = i; nr < i + M; nr++) {
						for(int nc = j; nc < j + M; nc++) {
							if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
							sum += map[nr][nc];	
							}
						}
					}
					max = Math.max(max, sum);
				}
			}
			sb.append("#"+t+" "+max+"\n");
		}
		System.out.println(sb);
	}

}
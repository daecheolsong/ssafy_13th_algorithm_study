import java.io.*;
import java.util.*;

public class Solution {
	static int T,N,K;
	static int[] Vulk, Value;
	static int[][] D;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			init();
			
			for (int i = 1; i <= N; i++) {
				for (int w = 1; w <= K; w++) {
					
					if(Vulk[i] <= w) {
						D[i][w] = Math.max(D[i-1][w], D[i-1][w-Vulk[i]]+Value[i]);
					}else {
						D[i][w] = D[i-1][w]; 
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(D[N][K]).append("\n");
		}
		System.out.println(sb);
	}

	private static void init() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 물건 개수
		K = Integer.parseInt(st.nextToken()); // 가방의 부피
		
		Vulk = new int[N+1];
		Value = new int[N+1];
		D = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			Vulk[i] = Integer.parseInt(st.nextToken());
			Value[i] = Integer.parseInt(st.nextToken());
		}
	}

}

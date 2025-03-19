import java.util.*;
import java.io.*;


public class SW_2117 {
	
	static int result;
	static int[][] houses;
	static int N, M;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			houses = new int[N][N];
			result = 0;
			int count = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					houses[i][j] = Integer.parseInt(st.nextToken());
					if (houses[i][j] == 1) {
						count++;
					}
				}
			}
			
			result = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (count == result) break; //모든 집이 탐색 완료된 경우 종료
					checkhouse(i,j);
				}
			}
			System.out.println("#" + test_case + " " + result);
		}

	}
	
	static void checkhouse(int r, int c) {
		for (int k = 0; k <= N+1; k++) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j  < N; j++) {
					if ((Math.abs(i-r) + Math.abs(j-c)) <= k - 1) {
						if (houses[i][j] == 1) {
							cnt++;
						}
					}
				}
			}
			int cost = k * k + (k - 1) * ( k - 1);
			if (cost <= cnt * M) {
				if (result < cnt) {
					result = cnt;
				}
			}
		}
	}

}

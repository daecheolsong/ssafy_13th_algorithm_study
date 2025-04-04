import java.io.*;
import java.util.*;

public class G3_1520 {
	
	static int m; 
	static int n; 
	static int [][] map;
	static int [][] dp;  
	static int [] mvr = {0, 0, 1, -1 }; 
	static int [] mvc = {1, -1, 0, 0 }; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); 
		n = Integer.parseInt(st.nextToken()); 
		
	
		map = new int[m][n];
		dp = new int[m][n];
		
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		// dp 배열을 -1로 초기화 (-1은 아직 계산 안 한 상태 표시)
		for(int i = 0; i < m; i++) {
			Arrays.fill(dp[i], -1);
		}
	
		
		System.out.println(move(0, 0));
		
	}
	

	public static int move(int r, int c) {

		if(r == m - 1 && c == n - 1) {
			return 1; // 경로 1개 완성
		}
		
		// 이미 계산한 적이 있는 위치면, 저장된 값 바로 리턴
		if(dp[r][c] != -1) {
			return dp[r][c];
		}
		
		// 아직 도착점까지 가는 경로 수를 계산 안 한 상태이므로 0으로 초기화
		dp[r][c] = 0;
		
		
		for(int i = 0; i < 4; i++) {
			int nr = r + mvr[i]; 
			int nc = c + mvc[i];
			
			
			if(isIn(nr, nc) && map[nr][nc] < map[r][c]) {
				// 다음 위치에서 도착점까지 가는 경로 수를 더함
				dp[r][c] += move(nr, nc);
			}
		}
	
		// 현재 위치에서 도착점까지 갈 수 있는 총 경로 수 리턴
		return dp[r][c];
	}
	
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && r < m && c >= 0 && c < n;
	}
}

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_4485 {
	static int answer = Integer.MAX_VALUE;
	static int [] mvr = {0, 0, 1, - 1};
	static int [] mvc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = 1;
		int n = Integer.parseInt(br.readLine());
		while(n != 0) {
			answer = Integer.MAX_VALUE;
			sb.append("Problem ").append(tc++).append(": ");
			int [][] map = new int[n][n];
			
			
			for(int i = 0; i < n ; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n ; j ++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}	
			}
		
			sb.append(move(0, 0, n, map[0][0], map)).append("\n");	
			n = Integer.parseInt(br.readLine());
			
		}
		System.out.println(sb);
		
	}
	
	public static int move(int r, int c, int n, int sum, int [][] map) {
		// 현재까지 잃게된 최소 루프 금액을 우선, d[r][c] = (r, c)까지 이동했을때까지 잃게된 최소 루피 금액
		PriorityQueue<int []> pq = new PriorityQueue<>((n1, n2) -> n1[2] - n2[2]);
		int [][] d = new int[n][n];
		for(int i = 0; i < n; i ++) {
			Arrays.fill(d[i], Integer.MAX_VALUE);
		}
		
		d[r][c] = map[r][c];
		pq.add(new int[] {r , c, d[r][c]});
		
		while(!pq.isEmpty()) {
			int [] pos = pq.poll();
			r = pos[0];
			c = pos[1];
			int cost = pos[2];
			// 이 상황은 다른 길로 왔을때 잃게되는 최소루피 금액이 존재하는 경우가 존재함.
			if(cost > d[r][c]) {
				continue;
			}
			
			for(int i = 0; i < 4; i ++) {
				int nr = r + mvr[i];
				int nc = c + mvc[i];
				if(isIn(nr , nc, n)) {
					int temp = map[nr][nc] + cost;
					// 현재 위치에서 다음 위치로 이동할때 그 위치로 이동하는것이 최소 루피 금액을 잃게되는 경우
					if(temp < d[nr][nc]) {
						d[nr][nc] = temp;
						pq.add(new int[] {nr ,nc, temp});						
					}
				}
			}
		}
		return d[n- 1][n- 1];
		
	}
	
	private static boolean isIn(int r, int c, int n) {
		return c >= 0 && c < n  && r >= 0 && r < n;
	}
	
}

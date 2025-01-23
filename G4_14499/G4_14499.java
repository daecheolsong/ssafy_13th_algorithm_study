import java.io.*;
import java.util.*;


public class G4_14499 {
	
	static int [] mvr = {0, 0, 0, -1, 1};
	static int [] mvc = {0, 1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int dr = Integer.parseInt(st.nextToken());
		int dc = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(st.nextToken());
		
		int [][] map = new int[n][m];
		
		for(int i = 0; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		
		int [][] dice = new int[4][3];
		
		dice[0][1] = 4;
		dice[1][0] = 2;
		dice[1][1] = 1;
		dice[1][2] = 3;
		dice[2][1] = 5;
		dice[3][1] = 6;
		
		int [] side = new int[7];
		
		for(int i = 0; i < k; i ++) {
			int d = Integer.parseInt(st.nextToken());
			
			if(!isIn(dr + mvr[d], dc + mvc[d], n, m)) {
				continue;
			}
			
			rollDice(dice, d);
			// 다음 주사위 위치
			int [] nextPos = move(dr, dc, d, n, m);
			dr = nextPos[0];
			dc = nextPos[1];
			
			if(map[dr][dc] == 0) {
				map[dr][dc] = side[dice[1][1]];
			} else {
				side[dice[1][1]] = map[dr][dc];
				map[dr][dc] = 0;
			}
			System.out.println(side[dice[3][1]]);
			
		}
		
		
	}
	
	public static boolean isIn(int r, int c, int n, int m) {
		return r >=0 && r < n && c >= 0 && c < m;
	}
	/**
	 * 주사위 위치를 이동합니다.
	 * @param r
	 * @param c
	 * @param d
	 * @param n
	 * @param m
	 * @return
	 */
	public static int [] move(int r, int c, int d, int n, int m) {

		r = Math.min(r + mvr[d], n);
		c = Math.min(c + mvc[d], m);
		return new int[] {r, c};
	}
	
	/**
	 * 방향으로 주사위를 굴림에 따라 주사위 전개도를 갱신합니다. 
	 * @param dice
	 * @param d
	 */
	
	public static void rollDice(int [][] dice, int d) {
		
		if(d == 1) {

			int [] arr = new int[4];
			int idx = 0;
			int diceIdx = 1;
			for(int i = 0; i < 2; i ++) {
				arr[idx++] =  dice[1][diceIdx++];
			}
			arr[idx++] = dice[3][1];
			arr[idx++] = dice[1][0];
			
			for(int i = 0; i < 3; i ++) {
				dice[1][i] = arr[i]; 
			}
			dice[3][1] = arr[3];
		}
		
		if(d == 2) {

			int [] arr = new int[4];
		
			for(int i = 0; i < 2; i ++) {
				arr[i + 1] =  dice[1][i];
			}
			arr[0] = dice[3][1];
			arr[3] = dice[1][2];
			
			for(int i = 0; i < 3; i ++) {
				dice[1][i] = arr[i]; 
			}
			dice[3][1] = arr[3];
			
		}
		
		if(d == 3) {
			int [] arr = new int[4];
			int idx = 3;
			for(int i = 0; i < 4; i ++) {
				arr[i] = dice[idx][1];
				idx = (idx + 1) % 4;
			}
			for(int i = 0; i < 4; i ++) {
				dice[i][1] = arr[i];
			}
			
		}
		
		
		if(d == 4) {
			int [] arr = new int[4];
			int idx = 1;
			for(int i = 0; i < 4; i ++) {
				arr[i] = dice[idx][1];
				idx = (idx + 1) % 4;
			}
			for(int i = 0; i < 4; i ++) {
				dice[i][1] = arr[i];
			}
				
		}
		
	}
}

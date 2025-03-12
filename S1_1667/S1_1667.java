import java.io.*;
import java.util.*;


public class S1_1667 {
	
	static int n;
	static int [][] map;
	static int [] mvr = {0, 0, 1, -1};
	static int [] mvc = {1, -1, 0, 0};
	static int [][] v;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		v = new int[n][n];
		
		for(int i = 0; i < n; i ++) {
			String line = br.readLine();
			for(int j = 0; j < n; j ++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		int areaSize = 0;
		List<Integer> answer = new ArrayList<>();
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < n; j ++) {
				if(map[i][j] != 0 && v[i][j] == 0) {
					areaSize ++;
					answer.add(bfs(i,j));
				}
			}
		}
		System.out.println(areaSize);
		Collections.sort(answer);
		for(int i : answer) {
			System.out.println(i);
		}
		
	}
	
	
	public static int bfs(int r, int c) {
		v[r][c] = 1;
		Queue<int []> q = new LinkedList<>();
		q.add(new int[] {r,c});
		int count = 1;
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			
			for(int i = 0; i < 4; i ++) {
				int nr = cur[0] + mvr[i];
				int nc = cur[1] + mvc[i];
				
				if(isIn(nr, nc) && v[nr][nc] == 0 && map[nr][nc] != 0) {
					v[nr][nc] = 1;
					count++;
					q.add(new int[] {nr, nc});
				}
			}
		}
		return count;
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}
	
}

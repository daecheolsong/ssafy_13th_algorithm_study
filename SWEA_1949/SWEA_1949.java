import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class SWEA_1949 {
	static int [] mvr = {1, -1, 0, 0};
	static int [] mvc = {0, 0, 1, -1};
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc ++) {
			sb.append("#").append(tc).append(" ");
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int [][] map = new int[n][n];
			
			int maxHeight = 0;
			for(int i = 0; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < n; j ++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(maxHeight, map[i][j]);
				}
			}
			
			List<int []> startList = new ArrayList<>(); // 시작지점, 최고점 높이
			List<int []> constructionList = new ArrayList<>(); // 공사지점
		
			for(int i = 0; i < n; i ++) {
				for(int j = 0; j < n; j ++) {
					if(map[i][j] == maxHeight) {
						startList.add(new int[] {i, j});
					}
					constructionList.add(new int[] {i, j});
				}
			}
			
			
			for(int [] startPos : startList) {
				int sr = startPos[0];
				int sc = startPos[1];
				for(int [] constructPos : constructionList) {
					int [][] v = new int[n][n];
					int csr = constructPos[0];
					int csc = constructPos[1];
					if(sr == csr && sc == csc) {
						continue;
					}
					v[sr][sc] = 1;
					search(sr, sc, k, map, csr, csc, 1, v);
				}
			}
			
			sb.append(answer).append("\n");
			
		}
		System.out.println(sb);
		
	}
	
	public static void search(int r, int c, int k, int [][] map, int csr, int csc, int move, int [][] v) {

		int blockCnt = 0;
		for(int i = 0; i < 4; i ++) {
			int nr = r + mvr[i];
			int nc = c + mvc[i];
		
			if(isIn(nr, nc, map.length)) {
				if(isConstructionSite(nr, nc, csr, csc) && isLowerAfterConstruction(r, c, nr, nc, k, map) && v[nr][nc] == 0) {
					v[nr][nc] = 1;
					int cut = doConstruction(r, c, nr, nc, k, map);
					map[nr][nc] -= cut;
					search(nr, nc, k, map, csr, csc, move + 1, v);
					map[nr][nc] += cut;
					v[nr][nc] = 0;
				} else if(isLower(r, c, nr, nc, map) && v[nr][nc] == 0) {
					v[nr][nc] = 1;		
					search(nr, nc, k, map, csr, csc, move + 1, v);
					v[nr][nc] = 0;
				} else {
					blockCnt ++;
				}
			} else {
				blockCnt++;
			}
		}
		if(blockCnt == 4) {
			answer = Math.max(answer, move);
		}
	}
	// 공사후 이동가능한지 판단후 가능하다면, 깎을수 있는 최소한으로만 깎습니다.
	// k 만큼 깎아버리면, 그 다음 이동가능한 곳이 그만큼 사라지므로 주의해야 합니다.
	private static int doConstruction(int sr, int sc, int tr, int tc, int k , int [][] map) {
		if(map[sr][sc] == map[tr][tc]) {
			return 1;
		}
		return Math.abs(map[sr][sc] - map[tr][tc]) + 1;
	}
	// 공사후 이동가능한지 판단
	private static boolean isLowerAfterConstruction(int sr, int sc, int tr, int tc, int k, int [][] map) {
		return map[sr][sc] > map[tr][tc] - k; 
	}
	
	private static boolean isConstructionSite(int r, int c, int csr, int csc) {
		return r == csr && c == csc;
	}
	
	
	private static boolean isLower(int sr, int sc, int tr, int tc, int [][] map) {
		return map[sr][sc] > map[tr][tc];
	}
	
	private static boolean isIn(int r, int c, int n) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}
	
}

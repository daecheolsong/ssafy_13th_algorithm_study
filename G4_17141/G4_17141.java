import java.io.*;
import java.util.*;


public class G4_17141 {
	public static int [] mvr = {0, 0, 1, -1};
	public static int [] mvc = {1, -1, 0, 0};
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [][] arr = new int[n][n];
		List<int []> list = new ArrayList<>();
		
		for(int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j ++) {
				int c = Integer.parseInt(st.nextToken());
				arr[i][j] = c == 1 ? -1 : c == 2 ? -2 : c;
				if(arr[i][j] == -2) {
					list.add(new int[] {i ,j});
				}
			}				
		}
		
		int [][] cases = new int[m][2];
		virusInstall(m, 0, 0, list, cases, arr);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	/**
	 * m 개의 virus 가 놓일수 있는 조합을 만들어 m 개의 virus가 놓일때  virus가 복제를 시작합니다.
	 * @param m
	 * @param next
	 * @param depth
	 * @param list virus가 놓일 수 있는 좌표들 
	 * @param cases virus 가 m 개가 선택됬을때, 바이러스 좌표의 모든 조합중 하나의 좌표들이 담은 배열
	 * @param arr
	 */
	public static void virusInstall(int m , int next, int depth, List<int []> list, int [][] cases, int [][] arr) {
		
		if(depth == m) {
			int [][] oneCaseMap = new int[arr.length][arr.length];
			
			for(int i = 0; i < oneCaseMap.length; i ++) {
				for(int j = 0; j < oneCaseMap.length; j ++) {
					int c = arr[i][j];
					oneCaseMap[i][j] = c == -2 ? 0 : c;
				}
			}
			
			for(int i = 0; i < oneCaseMap.length; i ++) {
				for(int j = 0; j < oneCaseMap.length; j ++) {
					int c = arr[i][j];
					oneCaseMap[i][j] = c == -1 ? c : Integer.MAX_VALUE;
				}
			}
			// 복제 시작, 각 경우의 수에 대한 결과 생성
			start(oneCaseMap, cases);
			// 각 경우의 수에 대한 결과에 대하여 최소 시간 구하기
			int curMin = 0;
			for(int i = 0; i < oneCaseMap.length; i ++) {
				for(int j = 0; j < oneCaseMap.length; j ++) {
					if(curMin < oneCaseMap[i][j]) {
						curMin = oneCaseMap[i][j];
					}
				}
			}
			answer = Math.min(curMin, answer);
			return;
		}
		
		for(int i = next; i < list.size(); i ++) {
			cases[depth] = list.get(i);
			virusInstall(m, i + 1, depth + 1, list, cases, arr);
		}
		
	}
	/**
	 * virus가 복제를 시작합니다. bfs를 이용하여 m 개의 바이러스가 놓였을때, 최종결과를 만듭니다.
	 * @param oneCaseMap
	 * @param cases
	 */
	
	public static void start(int [][] oneCaseMap, int [][] cases) {
			
		for(int i = 0; i < cases.length; i ++) {
			int [] dust = cases[i];
			int r = dust[0];
			int c = dust[1];
			int [][] v = new int[oneCaseMap.length][oneCaseMap.length];
			v[r][c] = 1;
			Queue<int []> q = new LinkedList<>();
			q.add(new int[] {r, c, 0});
			while(!q.isEmpty()) {
				int [] cur = q.poll();
				for(int d = 0; d < 4; d ++) {
					int nr = cur[0] + mvr[d];
					int nc = cur[1] + mvc[d];
					if(!isIn(nr,nc,oneCaseMap.length) || v[nr][nc] != 0 || oneCaseMap[nr][nc] == -1) {
						continue;
					}
					oneCaseMap[nr][nc] = Math.min(cur[2] + 1, oneCaseMap[nr][nc]);
					v[nr][nc] = 1;
					q.add(new int[] {nr, nc, cur[2] + 1});
				}
			}
			oneCaseMap[r][c] = -2;
		}
		return;
	
	}
	
	public static boolean isIn(int r, int c, int n ) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}
	
}

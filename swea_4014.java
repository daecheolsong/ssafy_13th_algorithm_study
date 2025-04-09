import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	/*
	 *  2차원 배열 맵
	 *  가로 / 세로 방향 탐색 
	 */
	static int T, N, X, cnt;
	static int[] arr;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cnt = 0;
		
		init(br);
		
		search();
		
		System.out.println(cnt);
	}

	private static void search() {
		// 가로 탐색
		for (int r = 0; r < N; r++) {
			boolean[] visited = new boolean[N];
			OUTER:
			for (int c = 0; c < N; c++) {
				
				int nc = c+1;
				
				if(!isValid(nc)) break;
				
				if(Math.abs(map[r][c] - map[r][nc]) > 1) { 
					break;
				}
				
				if(map[r][c] - map[r][nc] == 1) { //다음 위치가 1 작은 경우 -> 오른쪽으로 활주로
					if(isValid(nc + X - 1)) { // 만들 수 있을때
						for (int i = nc+1; i <= nc+X-1; i++) {
							if(!isValid(i)) break OUTER;
							if(map[r][nc] != map[r][i])break;
							c = nc+X-1; // 경사로가 만들어 지면, 경사로 끝으로 이동
							visited[c] = true;
							continue OUTER;
						}
					}else{ // 없을때
						break;
					};
				
				}
				
				if(map[r][c] - map[r][nc] == -1) { //다음 위치가 1 작은 경우 -> 오른쪽으로 활주로
					if(!visited[c]) { // 만들 수 있을때
						for (int i = nc-2; i <= nc-X+1; i--) {
							if(!isValid(i)) break OUTER;
							if(map[r][nc] != map[r][i])break;
							c = nc; // 경사로가 만들어 지면, 경사로 끝으로 이동
							visited[c] = true;
							continue OUTER;
						}
					}else{ // 없을때
						break;
					};
				
				}
				
				
				
				
				if(map[r][c] - map[r][nc] == -1) { //다음 위치가 1 큰 경우 -> 왼쪽으로 활주로
					for (int i = nc-2; i <= nc-X+1; i--) {
						if(map[r][c] != map[r][i] && nc>=N && nc<0 && !visited[i])	break;
						
					}
					visited[nc-X+1] = true;
				}
				
				if(c == N-1) cnt++; // N-1에 도달하면 활주로 건설 가능
			}
		}
		

		
		// 세로 탐색
		for (int c = 0; c < N; c++) {
			for (int r = 0; r < N; r++) {
				boolean[] visited = new boolean[N];
				int nc = c+1;
				if(Math.abs(map[r][c] - map[r][nc]) > 1) { // 높이가 같을 때
					break;
				}
				if(map[r][c] - map[r][nc] == 1) { //다음 위치가 1 작은 경우 -> 오른쪽으로 활주로
					for (int i = nc+1; i <= nc+X-1; i++) {
						if(map[r][nc] != map[r][i] && nc>=N && nc<0 && !visited[i])break;
						
					}
					c = nc+X-1; // 경사로가 만들어 지면, 경사로 끝으로 이동
					visited[c] = true;
				}
				if(map[r][c] - map[r][nc] == -1) { //다음 위치가 1 큰 경우 -> 왼쪽으로 활주로
					for (int i = nc-2; i <= nc-X+1; i--) {
						if(map[r][c] != map[r][i] && nc>=N && nc<0 && !visited[i])	break;
						
					}
					visited[nc-X+1] = true;
				}
				
				if(c == N-1) cnt++; // N-1에 도달하면 활주로 건설 가능
			}
		}
		
		
		
	}



	

	private static boolean down(int r, int c, int nc) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean isValid(int nc) {
		if(0<= nc || nc < N ) return true;
		return false;
		
	}

	private static void init(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 지도의 한 변의 크기
		X = Integer.parseInt(st.nextToken()); // 경사로의 길이
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
	}
	
	/*
	 * 경사로 설치 가능한지 어떻게 확인 할래? 안되는 경우 생각
	 * 
	 * 1. 가로 / 세로 방향 활주로 경우 나누기
	 * 2. 현재 위치와 다음 위치 값(높이) 비교 r, nr 관리
	 *  2-1. 높이가 같은 경우, 다음으로 넘어가
	 *  2-2. 높이가 다른 경우 : 높이 차가 2 이상이면 탈출
	 *  2-3. 높이 차가 1인 경우 : 다음 위치가 1 크면 -> 활주로는 왼쪽, 1 작으면 활주로는 오른쪽
	 * 3. 경사로 겹치는 경우 -> 방문 처리로 해결
	 * 4. r 이 N-1 에 도달하면 카운트 +1
	 * 5. 카운트된 정답 출력
	 */

}

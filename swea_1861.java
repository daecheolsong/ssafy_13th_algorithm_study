package swea;

import java.io.*;
import java.util.*;

public class Solution_1861 {
	
	static int tc, N, max, maxNum;
	static int[][] a;
	static int[] startMax;
	// 상하좌우
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			
			a = new int[N+2][N+2]; //외곽을 0 처리하기 위해 n+2
			startMax = new int[N*N+1];
			
			// 방 번호 입력
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dfs(i,j,1,a[i][j]);
				}
			}
			
			max = 0;
			maxNum = 0;
			// 방의 개수가 최대인 시작점 찾기 (여러 개라면 작은 값 기준)
			for (int i = startMax.length-1; i > 0; i--) { // 작은 값을 구하기 위해 점차 줄어드는 반복문
				if(startMax[i] >= max) {
					max = startMax[i];
					maxNum = i;
				}
			}
			System.out.println("#"+t+" "+maxNum+" "+max);
		}
	}

	private static void dfs(int x, int y, int cnt, int start) {
		
		int cur = a[x][y]; // start 값 저장
		
		for (int i = 0; i < 4; i++) {
			int next = a[x + dx[i]][y + dy[i]];
			// 외곽이 아니고 차이가 1이라면
			if(next != 0 && next - cur == 1) {
				dfs(x+dx[i], y+dy[i], cnt+1, start);
			}
			
		}
		
		// start 에서 갈 수 있는 최대 방 수
		if(cnt > startMax[start]) {
			startMax[start] = cnt;
		}
	}
}

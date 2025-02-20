package swea;

import java.io.*;
import java.util.*;

public class swea_1954 {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 4방 탐색 (우, 하, 좌, 상)
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int r = 0, c = 0, dir = 0;
			
			if(n==1) {
				System.out.println("#"+(t+1));
				System.out.println(1);
			}else {
				int[][] map = new int[n][n];
				boolean[][] visited = new boolean[n][n];
				
				for (int i = 1; i <= n * n; i++) {				
					map[r][c] = i; // 초기 위치에 값 할당
					visited[r][c] = true; // 방문처리
					// 다음 위치 계산
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					
					// 다음 위치가 범위를 벗어나거나 이미 방문한 경우 방향 변경
					if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) {
						dir = (dir+1) % 4;
						nr = r + dr[dir];
						nc = c + dc[dir];
					}
					r=nr;
					c=nc;
				}
				System.out.println("#"+(t+1));
				for(int i=0; i<n; i++) {					
					for(int j=0; j<n; j++) {
						System.out.print(map[i][j]+" ");
					}
					System.out.println();
				}
				
			}			
		}

	}

}

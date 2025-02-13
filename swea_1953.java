import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1953 {

	static int n; // 세로 크기
	static int m; // 가로 크기
	static int r; // 맨홀 세로 위치
	static int c; // 맨홀 가로 위치
	static int l; // 탈출 후 소요된 시간
	static int max;
	static int[][] map;
	static boolean[][] visit;
	
	// 상하좌우, 상하, 좌우, 상우, 하우, 하좌, 상좌
	static int[][] dx = {{}, {-1 ,1, 0, 0}, {-1, 1}, {0, 0}, {-1, 0}, {1, 0}, {1, 0}, {-1, 0}};
	static int[][] dy = {{}, {0, 0, -1, 1}, {0, 0}, {-1, 1}, {0, 1}, {0, 1}, {0, -1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
			
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
	
			max = 1;
			map = new int[n][m];
			visit = new boolean[n][m];
						
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c, 1});
		visit[r][c] = true;
		
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int time = q.peek()[2];
			q.poll();
			
			if (time == l) {
				continue;
			}
			
			for (int i = 0; i < dx[map[x][y]].length; i++) {
				int cx = x + dx[map[x][y]][i];
				int cy = y + dy[map[x][y]][i];
				
				// 범위 벗어날 경우
				if (cx < 0 || cx >= n || cy < 0 || cy >= m) {
					continue;
				}
				
				// 터널이 없거나 방문했을 경우
				if (map[cx][cy] == 0 || visit[cx][cy]) {
					continue;
				}
								
				// 현재 위치에서 이동할 수 있는 터널 확인
				// -> 이동할 터널과 현재 터널이 연결되어 있는지?
				for (int j = 0; j < dx[map[cx][cy]].length; j++) {
					if ((dx[map[x][y]][i] == -dx[map[cx][cy]][j]) && (dy[map[x][y]][i] == -dy[map[cx][cy]][j])) {
						visit[cx][cy] = true;
						max++;
						q.add(new int[] {cx, cy, time + 1});
						break;
					}
				}
			}
		}
	}
}

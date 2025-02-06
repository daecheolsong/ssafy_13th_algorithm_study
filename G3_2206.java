import java.io.*;
import java.util.*;

public class G3_2206 {
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int n, m;
	static int[][] arr;
	static int[][] map;
	static boolean[][][] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		map = new int[n][m];
		visit = new boolean[n][m][2];
		
		for (int i = 0; i < n; i++) {
			String s = bf.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j) - '0';
				map[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, 1, 0});
		visit[0][0][0] = true;
		map[0][0] = 1;
		
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int current = q.peek()[2];
			int check = q.peek()[3];
			q.poll();
			
			if (x == n - 1 && y == m - 1) {
				System.out.println(current);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if (cx < 0 || cx >= n || cy < 0 || cy >= m) {
					continue;
				}
				
				if (arr[cx][cy] == 0) {
					if (!visit[cx][cy][0] && check == 0) {
						q.add(new int[] {cx, cy, current + 1, 0});
						visit[cx][cy][0] = true;
					} else if (!visit[cx][cy][1] && check == 1) {
						q.add(new int[] {cx, cy, current + 1, 1});
						visit[cx][cy][1] = true;
					}
				} else if (arr[cx][cy] == 1) {
					if (check == 0) {
						q.add(new int[] {cx, cy, current + 1, 1});
						visit[cx][cy][1] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}
}

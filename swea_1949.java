import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1949 {

	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] arr;
	static boolean[][] visit;
	static int n, k;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
			
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			max = 0;
			
			arr = new int[n][n];
			visit = new boolean[n][n];
			
			int maxValue = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					maxValue = Math.max(maxValue, arr[i][j]);
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == maxValue) {
						visit[i][j] = true;
						dfs(i, j, false, 1);
						visit[i][j] = false;
					}
				}
			} 
			
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int x, int y, boolean check, int count) {
		max = Math.max(count, max);

		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (cx < 0 || cx >= n || cy < 0 || cy >= n) {
				continue;
			}
			
			// 방문하지 않은 곳 중 현재 위치보다 낮은 곳으로 이동
			if (arr[cx][cy] < arr[x][y] && !visit[cx][cy]) {
				visit[cx][cy] = true;
				dfs(cx, cy, check, count + 1);
				visit[cx][cy] = false;
			} 
			// 방문하지 않은 곳 중 현재 위치보다 높은 곳을 깎고 현재 위치보다 낮다면 이동
			else if (arr[cx][cy] >= arr[x][y] && !check && !visit[cx][cy]) {
				visit[cx][cy] = true;
				for (int j = 1; j <= k; j++) {
					if (arr[cx][cy] - j < arr[x][y]) {
						arr[cx][cy] -= j;
						dfs(cx, cy, true, count + 1);
						arr[cx][cy] += j;
					}
				}
				visit[cx][cy] = false;
			}	
		}
	}
}

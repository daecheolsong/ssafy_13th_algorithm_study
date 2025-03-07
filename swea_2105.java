package Day0307;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2105 {

	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };
	static boolean[] isSelected;
	static int tc, N, MAX, map[][];
	static final int INF = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception, IOException {
		System.setIn(new FileInputStream("src/Day0307/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			MAX = INF; // 테스트 케이스마다 Max 값 최소값으로 초기화

			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					isSelected = new boolean[101];
					isSelected[map[i][j]] = true;
					dfs(i, j, i, j, 1, 0); // 출발

				}
			}

			if (MAX == INF) sb.append(-1).append('\n');
			else sb.append(MAX).append('\n');
		}
		System.out.println(sb);
	}

	private static void dfs(int r, int c, int rr, int cc, int cnt, int prevDir) {

		for (int d = prevDir; d < 4; d++) {
			int nr = rr + dr[d];
			int nc = cc + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;

			if (nr == r && nc == c && prevDir >= 2) { // 출발 했던 좌표 & 왼쪽 위 or 오른쪽 위 대각선으로 돌아왔을 때 투어 끝!!
				MAX = Math.max(MAX, cnt);
				return;
			}

			if (!isSelected[map[nr][nc]]) {
				isSelected[map[nr][nc]] = true; // 같은 숫자의 디저트 먹었는지 flag
				dfs(r, c, nr, nc, cnt + 1, d);
				isSelected[map[nr][nc]] = false; // flag 원복

			}
		}
	}

}

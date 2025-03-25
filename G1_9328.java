import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1_9328 {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int n, m, answer;
	static boolean[][] visit;
	static char[][] map;
	static List<Character> key;
	static Queue<int[]> q;
	
	/**
	 * . 빈공간
	 * * 벽
	 * $ 문서
	 * A 문
	 * a 열쇠
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int T = 0; T < t; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			visit = new boolean[n][m];
			key = new ArrayList<>();
			q = new ArrayDeque<>();
			answer = 0;
			
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			String keys = br.readLine();
			
			if (!keys.equals("0")) {
				keys = keys.toUpperCase();
				for (int i = 0; i < keys.length(); i++) {
					key.add(keys.charAt(i));
				}
			}
			
			for (int i = 0; i < n; i++) {
				if (map[i][0] != '*') {
					q.add(new int[] {i, 0});
					visit[i][0] = true;
				}
				if (map[i][m - 1] != '*') {
					q.add(new int[] {i, m - 1});
					visit[i][m - 1] = true;;
				}
			}
			
			for (int i = 1; i < m - 1; i++) {
				if (map[0][i] != '*') {
					q.add(new int[] {0, i});
					visit[0][i] = true;
				}
				if (map[n - 1][i] != '*') {
					q.add(new int[] {n - 1, i});
					visit[n - 1][i] = true;
				}
			}
			
			bfs();
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	/**
	 * 열쇠 먹으면 해당 문 열림
	 */
	
	static void bfs() {
		int count = 0;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
						
			// 문서라면 answer++
			if (map[x][y] == '$') answer++;
			// 열쇠라면 리스트에 추가
			if (map[x][y] >= 'a' && map[x][y] <= 'z') key.add(Character.toUpperCase(map[x][y]));
			// 문인데 열쇠가 없을 경우 다시 큐에 추가
			if ((map[x][y] >= 'A' && map[x][y] <= 'Z') && !key.contains(map[x][y])) {
				q.add(new int[] {x, y});
				count++;
				
				// 열지 못하는 문만 남았을 경우
				if (q.size() <= count) {
					break;
				}
				continue;
			}
			
			count = 0;
			
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				// 범위 벗어나거나, 방문했거나, 벽일때(*) continue
				if (!isIn(cx, cy) || visit[cx][cy] || map[cx][cy] == '*') continue;
				
				visit[cx][cy] = true;
				q.add(new int[] {cx, cy});
			}
		}
	}
	
	static boolean isIn(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}

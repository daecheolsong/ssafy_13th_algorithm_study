import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class G2_16946 {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int n, m;	
	static boolean[][] visit;
	static int[][] arr, group;
	static List<Integer> list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		group = new int[n][m];
		visit = new boolean[n][m];
		list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		int value = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0 && !visit[i][j]) {
					bfs(i, j, value);
					++value;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					boolean[] check = new boolean[list.size() + 1];
					for (int k = 0; k < 4; k++) {
						int cx = i + dx[k];
						int cy = j + dy[k];
						
						if (!isIn(cx, cy) || arr[cx][cy] == 1 || group[cx][cy] == 0 || check[group[cx][cy]]) continue;
						
						arr[i][j] += list.get(group[cx][cy] - 1);
						check[group[cx][cy]] = true;
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(arr[i][j] % 10);
			}
			sb.append("\n");
		}
		 
		System.out.println(sb);
	}
	
	// 각 0 구역마다 번호 부여하고 방문하지 않은 0 구역만 count 더해줌
	static void bfs(int startX, int startY, int value) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {startX, startY});
		group[startX][startY] = value;
		visit[startX][startY] = true;
		
		int count = 0;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			count++;
			
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if (!isIn(cx, cy) || visit[cx][cy] || arr[cx][cy] != 0) continue;
				
				group[cx][cy] = value;
				visit[cx][cy] = true;
				q.add(new int[] {cx, cy});
			}
		}
		list.add(count);
	}
	
	static boolean isIn(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m; 
	}
}

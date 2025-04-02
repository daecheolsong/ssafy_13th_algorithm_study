import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_17141 {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	// 0 빈칸, 1은 벽, 2는 바이러스
	static int[][] arr;
	static int n, m, answer = Integer.MAX_VALUE;
	static boolean[][] visit;
	static boolean[] pick; 
	static List<Node> virus;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		visit = new boolean[n][n];
		virus = new ArrayList<>();
				
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					arr[i][j] = 0;
					virus.add(new Node(i, j));
				}
			}
		}
		
		pick = new boolean[virus.size()];
		
		dfs(0, 0);
		
		System.out.println(answer);
	}
	
	// m만큼 바이러스 놓기
	static void dfs(int depth, int index) {
		if (depth == m) {	
			bfs();
			return;
		}
		
		if (index >= virus.size()) return;
		
		int x = virus.get(index).x;
		int y = virus.get(index).y;
		
		pick[index] = true;
		dfs(depth + 1, index + 1);
		pick[index] = false;
		
		dfs(depth, index + 1);
	}
	
	// 바이러스 진행
	static void bfs() {		
		Queue<int[]> q = new ArrayDeque<>();
		int totalTime = 0;
		visit = new boolean[n][n];

		for (int i = 0; i < virus.size(); i++) {
			if (pick[i]) {
				int x = virus.get(i).x;
				int y = virus.get(i).y;
				
				q.add(new int[] {x, y, 0});
				visit[x][y] = true;
			}
		}
		
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int time = q.peek()[2];
			q.poll();
						
			totalTime = Math.max(totalTime, time);
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if (!isIn(cx, cy) || visit[cx][cy] || arr[cx][cy] != 0) continue;
				
				visit[cx][cy] = true;
				q.add(new int[] {cx, cy, time + 1});
			}
		}
		
		check(totalTime);
	}
	
	// 빈칸인데 방문을 안했을 경우 -1
	static void check(int totalTime) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0 && !visit[i][j]) {
					answer = answer == Integer.MAX_VALUE ? -1 : answer;
					return;
				}
			}
		}
		
		if (answer == -1) 
			answer = totalTime;
		else 
			answer = Math.min(answer, totalTime); 
	}
	
	static boolean isIn(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
	
	static class Node{
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}


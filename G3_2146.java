import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_2146 {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int n, answer = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int value = 2;
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					group(i, j, value);
					value++;
				}
			}
		}
	
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != 0) {
					build(i, j, arr[i][j]);
				}
			}
		}
		
		System.out.println(answer - 1);
	}
	
	static void group(int sx, int sy, int value) {
		Queue<Node> q = new ArrayDeque<>();
		arr[sx][sy] = value;
		visit[sx][sy] = true;
		q.add(new Node(sx, sy, 0));
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x;
			int y = node.y;
			
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if (!isIn(cx, cy) || visit[cx][cy] || arr[cx][cy] == 0) continue;
				
				arr[cx][cy] = value;
				visit[cx][cy] = true;
				q.add(new Node(cx, cy, 0));
			}
		}
	}
	
	static void build(int sx, int sy, int groupValue) {
		Queue<Node> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][n];
		visit[sx][sy] = true;
		q.add(new Node(sx, sy, 0));
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x;
			int y = node.y;
			int count = node.count;
			
			if (arr[x][y] != 0 && arr[x][y] != groupValue) {
				answer = Math.min(answer, count);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if (!isIn(cx, cy) || visit[cx][cy] || arr[cx][cy] == groupValue) continue;
				
				visit[cx][cy] = true;
				q.add(new Node(cx, cy, count + 1));
			}
		}
	}
	
	static boolean isIn(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
	
	static class Node {
		int x;
		int y;
		int count;
		
		Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}

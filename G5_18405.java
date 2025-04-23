import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_18405 {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int n, k, answer, s;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		bfs();
		
		System.out.println(arr[x - 1][y - 1]);
	}
	
	static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != 0) pq.add(new Node(i, j, 1, arr[i][j]));
			}
		}
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int x = node.x;
			int y = node.y;
			int time = node.time;
			int value = node.value;
			
			if (time > s) return;
			
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if (!isIn(cx, cy) || arr[cx][cy] != 0) continue;
				
				arr[cx][cy] = value;
				pq.add(new Node(cx, cy, time + 1, value));
			}
		}
	}
	
	static boolean isIn(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int time;
		int value;
		
		public Node(int x, int y, int time, int value) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			if (this.time == o.time) return this.value - o.value;
			return this.time - o.time;
		}
	}
}


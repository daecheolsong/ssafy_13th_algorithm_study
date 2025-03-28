import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class G1_17472 {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int n, m, groupCount;
	static int[][] arr, graph;
	static int[] parents;
	static boolean[][] visit;
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit = new boolean[n][m];
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		// 1. 그룹 찾기
		int value = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					visit[i][j] = true;
					arr[i][j] = value;
					findGroup(i, j, value);
					value++;
					groupCount++;
				}
			}
		}
		
		// 2. 각 그룹에서 연결되는 비용 확인
		graph = new int[groupCount][groupCount];
		for (int i = 0; i < groupCount; i++) Arrays.fill(graph[i], Integer.MAX_VALUE);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) continue;
				
				for (int d = 0; d < 4; d++) {
					connectGroup(i, j, d, arr[i][j], 0);		
				}
			}
		}
						
		for (int i = 0; i < groupCount; i++) {
			for (int j = 0; j < groupCount; j++) {
				if (i == j) continue;
		
				pq.add(new Edge(i, j, graph[i][j]));
			}
		}

		// 3. 크루스칼 알고리즘 사용
		parents = new int[groupCount];
		for (int i = 0; i < groupCount; i++) parents[i] = i;

		int count = 0;
		int answer = 0;
		
		while (!pq.isEmpty()) {
			if (count == groupCount - 1) break;
			if (count < groupCount - 1 && pq.peek().cost == Integer.MAX_VALUE) {
				answer = -1;
				break;
			}
				
			Edge edge = pq.poll();
			
			if (find(edge.u) != find(edge.v)) {
				answer += edge.cost;
				count++;
				union(edge.u, edge.v);
			}
				
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < groupCount; i++) {
			set.add(find(i));
			if (set.size() == 2) break;
		}
		if (set.size() != 1) answer = -1;
		
		
		System.out.println(answer);
	}
	
	// 그룹 번호 정해줌
	static void findGroup(int startX, int startY, int value) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {startX, startY});
		
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if (!isIn(cx, cy) || visit[cx][cy] || arr[cx][cy] == 0) continue;
				
				visit[cx][cy] = true;
				arr[cx][cy] = value;
				q.add(new int[] {cx, cy});
			}
		}
	}
	
	// 하나의 그룹에서 다른 그룹 갈 수 있는 최소 비용 확인
	static void connectGroup(int x, int y, int d, int groupValue, int weight) {
		if (arr[x][y] > groupValue) {
			if (weight == 2) return;
			int a = groupValue - 2;
			int b = arr[x][y] - 2;
			graph[a][b] = Math.min(graph[a][b], weight - 1);
			return;
		}
		
		if (arr[x][y] > 0 && arr[x][y] < groupValue) return;
		
		int cx = x + dx[d];
		int cy = y + dy[d];
		
		if (isIn(cx, cy) && arr[cx][cy] != groupValue)
			connectGroup(cx, cy, d, groupValue, weight + 1);
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA != rootB) parents[rootB] = rootA;
	}
	
	static int find(int a) {
		if (parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean isIn(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
	
	static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int cost;
		
		Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
}

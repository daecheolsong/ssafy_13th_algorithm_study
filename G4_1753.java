import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_신규원 {
	static class Node implements Comparable<Node> {
		int no, weight;

		public Node(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static List<Node>[] adj; // 배열의 각 요소가 Node 객체를 저장하는 리스트
	static int[] D; // 시작 정점에서의 거리 저장하는 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); // 정점
		int E = Integer.parseInt(st.nextToken()); // 간선
		int K = Integer.parseInt(br.readLine()); // 시작 정점

		adj = new ArrayList[V + 1]; // 인접리스트
		D = new int[V + 1]; // 시작정점에서의 거리

		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
			D[i] = INF;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // 출발
			int v = Integer.parseInt(st.nextToken()); // 도착
			int w = Integer.parseInt(st.nextToken()); // 가중치(비용)

			adj[u].add(new Node(v, w));
		}

		dijkstra(K);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(D[i] == INF ? "INF" : D[i]).append("\n");
		}
		System.out.print(sb);
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		D[start] = 0; // 시작 정점 0
		pq.offer(new Node(start, 0)); // pq에 시작 정점 넣기

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int nowIndex = now.no;
			int nowCost = now.weight;

			if (nowCost > D[nowIndex]) // 새로운 정점의 거리 > 기존 정점의 거리이면 패스  
				continue;

			for (Node next : adj[nowIndex]) {
				int newCost = D[nowIndex] + next.weight; // 현재까지 정점의 거리 값(D[])에 + 인접한 정점에 가중치 
				if (newCost < D[next.no]) { // 인접한 정점까지의 누적 가중치가 D[]에서 값보다 작으면 업데이트
					D[next.no] = newCost;
					pq.offer(new Node(next.no, newCost)); // 인접한 정점을 pq에 넣기
				}
			}
		}
	}
}

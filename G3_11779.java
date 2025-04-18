import java.io.*;
import java.util.*;

public class G3_11779 {	
	
	static int n, m, answer;
	static List<Node>[] graph;
	static int[] dist;
	static int start, end;
	static String nums;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		graph = new ArrayList[n + 1];
		dist = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c, ""));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra();
		
		st = new StringTokenizer(nums);
		
		sb.append(dist[end]).append("\n").append(st.countTokens()).append("\n");		
		sb.append(nums);
		System.out.println(sb);
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.w - o2.w));
		dist[start] = 0;
		pq.add(new Node(start, 0, start + " "));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int v = node.v;
			int w = node.w;
			String s = node.s;
			
			if (v == end && dist[v] == w) {
				nums = s;
			}
			
			if (dist[v] < w) continue;
			
			for (Node next : graph[v]) {
				if (dist[next.v] > w + next.w) {
					dist[next.v] = w + next.w;
					pq.add(new Node(next.v, dist[next.v], s + next.v + " "));
				}
			}
		}
	}
	
	static class Node{
		int v;			// 다음 정점
		int w;			// 현재까지 비용
		String s;
		
		public Node(int v, int w, String s) {
			this.v = v;
			this.w = w;
			this.s = s;
		}
	}
}

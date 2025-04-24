import java.io.*;
import java.util.*;

public class G4_18223 {

	static List<Node>[] list;
	static int[] dist1, dist2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		dist1 = new int[v + 1];
		dist2 = new int[v + 1];
		list = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
			dist1[i] = Integer.MAX_VALUE;
			dist2[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		// 1 ~ v, p ~ v 구하기
		dijkstra(1, v, dist1);
		dijkstra(p, v, dist2);
		
		System.out.println(dist1[v] == dist1[p] + dist2[v] ? "SAVE HIM" : "GOOD BYE");
	}
	
	static void dijkstra(int start, int end, int[] dist) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		pq.add(new Node(start, 0));
		
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int v = node.v;
			int cost = node.cost;
			
			if (v == end) break;
			
			for (Node next : list[v]) {
				if (dist[next.v] > next.cost + cost) {
					dist[next.v] = next.cost + cost;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}
	
	static class Node {
		int v;
		int cost;
		
		public Node(int v, int cost) {
			super();
			this.v = v;
			this.cost = cost;
		}
	}
}

import java.util.*;

import java.io.*;

public class G4_21924 {
	
	static class Edge implements Comparable<Edge>{
		int from,to;
		long weight;
		public Edge(int from , int to, long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	
	static void make() {
		parents = new int[V+1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		if (aRoot > bRoot) parents[aRoot] = bRoot;
		else parents[bRoot] = aRoot;
		return true;
	}
	
	static int V, E;
	static int[] parents;
	static List<Edge> edgelist = new ArrayList<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		make();
		
		long sum = 0;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			long w = Long.parseLong(st.nextToken());
			edgelist.add(new Edge(x, y, w));
			sum+=w;
		}
		
		Collections.sort(edgelist);
		
		long result = 0;
		int count = 0;
		for (Edge edge : edgelist) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++count == V-1) {
					break;
				}
			}
		}
		
		if (count < V - 1) {
		    System.out.println(-1);
		    return;
		}
		
		System.out.println(sum-result);

	}

}

import java.util.*;
import java.io.*;

public class G4_1197 {
	
	static int N, M, result;
	
	static int[] parents;
	
	static class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static void init() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	static void union(int a, int b, int c) {
		int rootA = find(a);
		int rootB = find(b);
	
		
		if(rootA != rootB) {
			if(rootA < rootB) {
				parents[rootB] = rootA;
			}
			else {
				parents[rootA] = rootB;
			}
			
			result += c;
		}
	}
	
	static int find(int n) {
		if (parents[n] == n) return n;
		
		return parents[n] = find(parents[n]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		
		init();
		
		Queue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			pq.add(new Edge(from, to, weight));
		}
		
		for (int i = 0; i < M; i++) {
			Edge curr = pq.poll();
			union(curr.from, curr.to, curr.weight);
		}
		
		System.out.println(result);
		
	}

}

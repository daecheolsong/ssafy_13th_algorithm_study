import java.util.*;
import java.io.*;

public class G2_1167 {
	
	static int V;
	static List<Node>[] list;
	static boolean[] visited; 
	static int result = 0;
	static int maxDist = 0;
    static int farthestNode = 0;
	
	static class Node {
	    int to, weight;
	    Node(int to, int weight) {
	        this.to = to;
	        this.weight = weight;
	    }
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			while(true) {
				int m = Integer.parseInt(st.nextToken());
				if(m == -1) break;
				int l = Integer.parseInt(st.nextToken());
				list[n].add(new Node(m, l));
			}
		}
		
		visited = new boolean[V+1];
		visited[1] = true;
		dfs(1, 0);
		
		visited = new boolean[V+1];
		maxDist = 0;
		dfs(farthestNode, 0);
		
		System.out.println(maxDist);
	}
	
	static void dfs(int n, int d) {
		
		visited[n] = true;
		
		if (d > maxDist) {
            maxDist = d;
            farthestNode = n;
        }
		
		for (Node m : list[n]) {
			if (!visited[m.to]) {
				dfs(m.to, d+m.weight);
			}
		}
	}

}

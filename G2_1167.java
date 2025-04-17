import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class G2_1167 {	
	
	static int n, node, answer;
	static List<Node>[] tree;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n + 1];
				
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			tree[index ] = new ArrayList<>();
			while (true) {
				int v = Integer.parseInt(st.nextToken());
				if (v == -1) break;
				int cost = Integer.parseInt(st.nextToken());
				
				tree[index].add(new Node(v, cost)); 
			}
		}
		
		visit = new boolean[n + 1];
		dfs(1, 0);
		
		visit = new boolean[n + 1];
		dfs(node, 0);
		
		System.out.println(answer);
	}
	
	static void dfs(int x, int len) {
		if (len > answer) {
			answer = len;
			node = x;
		}
		
		visit[x] = true;
		
		for (int i = 0; i < tree[x].size(); i++) {
			Node n = tree[x].get(i);
			if (!visit[n.v]) {
				dfs(n.v, n.cost + len);
				visit[n.v] = true;
			}
		}
	}
	
	static class Node {
		int v;
		int cost;
		
		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}
}

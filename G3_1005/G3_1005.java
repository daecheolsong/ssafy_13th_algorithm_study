import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_1005 {

	static int t;
	static int v;
	static int e;
	static int w;
	static int[] cost;
	static Node[] nodeList;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			cost = new int[v + 1];
			nodeList = new Node[v + 1];
			dp = new int[v + 1];

			for (int i = 1; i <= v; i++) {
				nodeList[i] = new Node(i);
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= v; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				nodeList[from].outDegree.add(nodeList[to]);
				nodeList[to].inDegree.add(nodeList[from]);
			}
			w = Integer.parseInt(br.readLine());

			Queue<Node> q = new LinkedList<>();
			for (int i = 1; i <= v; i++) {
				if (nodeList[i].inDegree.isEmpty()) {
					q.add(nodeList[i]);
					dp[i] = cost[i];
				}
			}

			while (!q.isEmpty()) {
				Node cur = q.poll();
				for (Node out : cur.outDegree) {
					dp[out.idx] = Math.max(cost[out.idx] + dp[cur.idx], dp[out.idx]);
					out.inDegree.remove(cur);
					if (out.inDegree.isEmpty()) {
						q.add(out);
					}
				}
			}
			sb.append(dp[w]).append("\n");
		}
		System.out.println(sb);
	}

	static class Node {
		List<Node> inDegree = new ArrayList<>();
		List<Node> outDegree = new ArrayList<>();

		int idx;

		public Node(int idx) {
			this.idx = idx;
		}
	}

}

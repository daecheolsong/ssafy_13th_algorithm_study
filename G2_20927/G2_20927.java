import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class G2_20927 {

	static int[] degree;
	static int[] curDegree;
	static int[] p;
	static int n;
	static int m;
	static List<Edge> edgeList = new ArrayList<>();
	static List<Edge> temp = new ArrayList<>();
	static List<Edge> answer;
	static int minCost = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		degree = new int[n + 1];
		curDegree = new int[n + 1];

		p = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			degree[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(from, to, cost));
		}
		Collections.sort(edgeList, (e1, e2) -> e1.cost - e2.cost);

		search(0, 0, 0);
		StringBuilder sb = new StringBuilder();
		if (minCost == Integer.MAX_VALUE) {
			sb.append("NO\n");
		} else {
			sb.append("YES\n");
			for (Edge e : answer) {
				sb.append(e.from).append(" ").append(e.to).append("\n");
			}
		}
		System.out.println(sb);
	}

	public static void search(int cur, int cnt, int cost) {
		if (cnt == n - 1) {
			for (int i = 1; i <= n; i++) {
				p[i] = i;
			}

			for (Edge e : temp) {
				union(e.from, e.to);
			}

			for (int i = 2; i <= n; i++) {
				if (find(1) != find(i)) {
					return;
				}
			}

			if (minCost > cost) {
				minCost = cost;
				answer = new ArrayList<>(temp);
			}
			return;
		}

		if (cur >= edgeList.size()) {
			return;
		}

		search(cur + 1, cnt, cost);

		Edge e = edgeList.get(cur);
		int v1 = e.from;
		int v2 = e.to;

		if (curDegree[v1] < degree[v1] && curDegree[v2] < degree[v2]) {
			temp.add(e);
			curDegree[v1]++;
			curDegree[v2]++;
			search(cur + 1, cnt + 1, cost + e.cost);
			temp.remove(e);
			curDegree[v1]--;
			curDegree[v2]--;
		}
	}

	public static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);

		if (v1 > v2) {
			p[v1] = v2;
		} else {
			p[v2] = v1;
		}
	}

	public static int find(int v) {
		if (p[v] == v) {
			return v;
		}
		return p[v] = find(p[v]);
	}

	static class Edge {
		int from;
		int to;
		int cost;

		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

	}
}

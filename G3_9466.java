import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_9466 {
	
	static int[] graph;
	static boolean[] visit, finish;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			graph = new int[n + 1];
			visit = new boolean[n + 1];
			finish = new boolean[n + 1];
			count = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				int a = Integer.parseInt(st.nextToken());
				graph[i] = a;
			}
			
			for (int i = 1; i <= n; i++) {			
				dfs(i);
			}
			
			sb.append(n - count).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int now) {
		if (visit[now]) return;
		
		visit[now] = true;
		int next = graph[now];
		
		if (!visit[next]) dfs(next);
		else if (!finish[next]) {
			count++;
			
			for (int i = next; i != now; i = graph[i]) count++;
		}
		
		finish[now] = true;
	}
}

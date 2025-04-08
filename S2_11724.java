import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static ArrayList<Integer>[] node;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		node = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for(int i = 1; i < N + 1; i++) {
			node[i] = new ArrayList<>();
		}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			node[i].add(j);
			node[j].add(i);
		}

		int count = 0;
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				count++;
				dfs(i);
			}
		}
		System.out.println(count);
	}

	private static void dfs(int depth) {
		if(visited[depth]) {
			return;
		}
		visited[depth] = true;
		for(int i : node[depth]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
		
	}
}

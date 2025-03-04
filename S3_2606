import java.util.*;
import java.io.*;

public class S3_2606 {
	static int count = 0;
	static boolean[] visited;
	static int N;
	static int[][] list;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		list = new int[N+1][N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer (br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x][y] = 1;
			list[y][x] = 1;
		}
		
		dfs(1);
		System.out.println(count-1);
	}
	
	static void dfs(int idx) {
		if (visited[idx] == true) return;
		visited[idx] = true;
		count++;
		for (int i = 1; i < N+1; i++) {
			if (list[idx][i] == 1 && i != idx) {
				dfs(i);
			}
		}
	}

}

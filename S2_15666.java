import java.util.*;
import java.io.*;

public class S2_15666 {

	static int N, M;
	static int[] list, arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		list = new int[N];
		arr = new int[M];
		
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);
				
		dfs(0, 0);
		
		System.out.println(sb);

	}
	
	static void dfs(int num, int dep) {
		if (dep == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		int before = -1;
		for (int i = num; i < N; i++) {
			if (before != list[i]) {
				before = list[i];
				arr[dep] = list[i];
				dfs(i, dep+1);
			}
		}
	}

}
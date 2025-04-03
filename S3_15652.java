import java.util.*;
import java.io.*;

public class S3_15652 {
	static int N, M;
	static int[] result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		dfs(1, 0);
	}
	
	public static void dfs(int idx, int dep) {
		if (dep==M) {
			for (int val: result) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = idx; i <= N; i++) {
			result[dep] = i;
			dfs(i, dep+1);
		}
	}

}

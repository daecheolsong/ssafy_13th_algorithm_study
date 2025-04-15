import java.util.*;
import java.io.*;

public class G2_20303 {

	static int N, M, K;
	static int[] dp;
	static int[] friends;
	static int[] candy;
	static int[] size;
	static List<info> parts = new ArrayList<>();
	
	static void init() {
		for (int i = 1; i <= N; i++) {
			friends[i] = i;
			size[i] = 1;
		}
	}
	
	static int find(int n) {
		if(friends[n] == n) return n;

		return friends[n] = find(friends[n]);
	}
	
	static void union(int n, int m) {
		int rootn = find(n);
		int rootm = find(m);
		
		if(rootn == rootm) return;
		else {
			if(rootn < rootm) {
				friends[rootm] = rootn;
				candy[rootn] += candy[rootm];
				size[rootn] += size[rootm];
			}
			else {
				friends[rootn] = rootm;
				candy[rootm] += candy[rootn];
				size[rootm] += size[rootn];
				}
		}
	}
	
	static class info {
		int num;
		int candies;
		
		public info(int num, int candies) {
			this.num = num;
			this.candies = candies;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		friends = new int[N+1];
		dp = new int[K+1];
		candy = new int[N+1];
		size = new int[N+1];
		
		init();
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			candy[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			union(n, m);
		}
		
		for (int i = 1; i <= N; i++) {
			friends[i] = find(i);
		}
		
		for (int i = 1; i <= N; i++) {
			if(friends[i] == i) {
				parts.add(new info(size[i], candy[i]));
			}
		}
		
		for (info o : parts) {
			for (int k = K-1; k >= o.num; k--) {
				dp[k] = Math.max(dp[k], o.candies + dp[k-o.num]);
			}
		}
		
		System.out.println(dp[K-1]);
		
	}

}

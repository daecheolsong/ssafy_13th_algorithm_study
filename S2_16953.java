import java.util.*;
import java.io.*;

public class S2_16953 {
	
	static Long N, M;
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		dfs(N, 1);
		System.out.println(count == 0 ? -1 :  count);
	}
	
	static void dfs(long n, int c) {
		if (n == M) {
			count = c;
			return;
		}
		
		else {
			if(n*2 <= M) {
				dfs(n*2, c+1);
			}
			
			if(n*10+1 <= M) {
				dfs(n*10+1, c+1);
			}
		}
	}

}

import java.io.*;
import java.util.*;
public class S1_1080 {
	
	static int [][] src;
	static int [][] target;
	static int n;
	static int m;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
	
		src = new int[n][m];
		target = new int[n][m];
		
		for(int i = 0; i< n; i ++) {
			String [] input  = br.readLine().split("");
			for(int j = 0; j < m; j ++) {
				src[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for(int i = 0; i< n; i ++) {
			String [] input  = br.readLine().split("");
			for(int j = 0; j < m; j ++) {
				target[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int answer = 0;
		
		for(int i = 0; i <= n - 3; i ++) {
			for(int j = 0; j <= m - 3; j ++) {
				if (src[i][j] == target[i][j]) {
					continue;
				}
				for(int k = i; k < i + 3; k ++) {
					for(int l = j; l < j + 3; l ++) {
						src[k][l] = src[k][l] == 0 ? 1 : 0;
					}
				}
				answer ++;
			}
		}
		
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < m; j ++) {
				if(src[i][j] != target[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(answer);
	}
	
	public static boolean isSame() {
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < m; j ++) {
				if(src[i][j] != target[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
}
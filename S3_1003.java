import java.io.*;
import java.util.*;

public class S3_1003 {
	static int x, y, n;
	static int[][] grid;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		x = 0;
		y = 0;
		grid = new int[41][2];
		StringBuilder sb = new StringBuilder();
		
//		fib(0);
		
		grid[0][0] = 1;
		grid[0][1] = 0;
		grid[1][0] = 0;
		grid[1][1] = 1;
		
		for (int i = 2; i <= 40; i++) {
			grid[i][0] = grid[i-1][0] + grid[i-2][0];
			grid[i][1] = grid[i-1][1] + grid[i-2][1];
		}
		
		
		for (int i = 0; i < n; i++) {
			int j = Integer.parseInt(br.readLine());
			sb.append(grid[j][0]+" "+grid[j][1]+"\n");
		}
		
		System.out.print(sb);
	}
	
//	static int fib(int n) {
//		if (n==0) {
//			grid[n][0]++;
//			return 0;
//		}
//		else if (n==1) {
//			grid[n][1]++;
//			return 1;
//		}
//		else {
//			return fib(n-1) + fib(n-2);
//		}
//	}

}

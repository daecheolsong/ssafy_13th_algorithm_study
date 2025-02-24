import java.util.*;
import java.io.*;
public class S4_1018 {
	static int N, M;
	static int result = Integer.MAX_VALUE;
	static char[][] grid;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				grid[i][j] = line.charAt(j);
			}
		}
		
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				check(i,j);
				check2(i,j);
			}
		}
		
		System.out.println(result);
	}
	
	static void check(int x, int y)  {
		int count = 0;
		for (int i = x; i < x+8; i++) {
			for (int j = y; j < y+8; j++) {
				if ((i + j) % 2 == 0) {
					if (grid[i][j] == 'W') {
						count++;
					}
				}
				else {
					if (grid[i][j] == 'B') {
						count++;
					}
				}
			}
		}
		result = Math.min(count, result);
	}
	
	static void check2(int x, int y)  {
		int count = 0;
		for (int i = x; i < x+8; i++) {
			for (int j = y; j < y+8; j++) {
				if ((i + j) % 2 == 0) {
					if (grid[i][j] == 'B') {
						count++;
					}
				}
				else {
					if (grid[i][j] == 'W') {
						count++;
					}
				}
			}
		}
		result = Math.min(count, result);
	}

}

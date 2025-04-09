import java.util.*;
import java.io.*;

public class G3_14890 {

	static int N, L;
	static int[][] grid;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		grid = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			count += put(i, 0, 0);
//			System.out.println(i + " " + count);
		}
		
		for (int i = 0; i < N; i++) {
			count += put(0, i, 1);
//			System.out.println(i + " " + count);
		}
		
		System.out.println(count);
	}
	
	
	static int put(int x, int y, int d) {
		if (d == 0) { //가로
			int last_n = 1;
			int last = grid[x][0];
			boolean godown = false;
			
			for (int i = 1; i < N; i++) {
				if (grid[x][i] == last) {
					last_n++;
				}
				else if (grid[x][i] > last) {
					if (godown && last_n < 2*L) return 0;
					if (last_n < L) return 0;
					if (grid[x][i] - last > 1) return 0;
					last_n = 1;
					last = grid[x][i];
					godown = false;
				}
				else if (grid[x][i] < last) {
					if(godown && last_n < L) return 0;
					if (last - grid[x][i] > 1) return 0;
					last = grid[x][i];
					last_n = 1;
					godown = true;
				}
			}
			
			if(godown && last_n < L) return 0;
			return 1;
		}
		
		else if (d == 1) { //세로
			int last_n = 1;
			int last = grid[0][y];
			boolean godown = false;
			
			for (int i = 1; i < N; i++) {
				if (grid[i][y] == last) {
					last_n++;
				}
				else if (grid[i][y] > last) {
					if (godown && last_n < 2*L) return 0;
					if (last_n < L) return 0;
					if (grid[i][y] - last > 1) return 0;
					last_n = 1;
					last = grid[i][y];
					godown = false;
				}
				else if (grid[i][y] < last) {
					if(godown && last_n < L) return 0;
					if (last - grid[i][y] > 1) return 0;
					last = grid[i][y];
					last_n = 1;
					godown = true;
				}
			}
			
			if(godown && last_n < L) return 0;
			return 1;
		}
		
		return 0;
	}

}

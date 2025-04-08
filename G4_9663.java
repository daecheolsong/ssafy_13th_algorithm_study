
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	

	static int N, result;
	static int[] queens; 
	public static void main(String args[]) throws IOException {
		init();
		backTraking(0);
		System.out.println(result);
	}

    
	
	private static void backTraking(int row) {
		// TODO Auto-generated method stub
		if (row == N) {
			result++;
			return;
		}
		
		for(int col = 0; col < N; col++) {
			if(isCheck(row, col)) {
				queens[row] = col;
				backTraking(row + 1);
			}
		}
	}
	



	private static boolean isCheck(int row, int col) {
		for(int i = 0; i < row; i++) {
			if (queens[i] == col) return false;
			if(Math.abs(queens[i]- col) ==  Math.abs(i - row)) return false; // 대각선
		}
		return true;
	}



	private static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		result = 0;
		queens = new int[N];

		
	}
}

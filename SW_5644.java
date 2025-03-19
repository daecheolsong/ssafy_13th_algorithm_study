import java.io.*;
import java.util.*;

public class SW_5644 {
	static int M, A;
	static int[] A_move, A_position;
	static int[] B_move, B_position;
	static int[][] bc_list;
	static int result;
	static int[] dx = {0,0,1,0,-1};
	static int[] dy = {0,-1,0,1,0};

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		A_position = new int[2];
		B_position = new int[2];

		
		for (int test_case = 1; test_case<=T; test_case++) {

			A_position[0] = A_position[1] = 1;
			B_position[0] = B_position[1] = 10;
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			A_move = new int[M+1];
			B_move = new int[M+1];
			
			bc_list = new int[A][4];
			result = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < M+1; i++) {
				A_move[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < M+1; i++) {
				B_move[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				bc_list[i][0] = Integer.parseInt(st.nextToken());
				bc_list[i][1] = Integer.parseInt(st.nextToken());
				bc_list[i][2] = Integer.parseInt(st.nextToken());
				bc_list[i][3] = Integer.parseInt(st.nextToken());
			}
			
			move();
			System.out.println("#"+test_case+" "+result);
		}
	}
	
	static void move() {
		for (int i = 0; i < M+1; i++) {
			A_position[0] += dx[A_move[i]];
			A_position[1] += dy[A_move[i]];
			B_position[0] += dx[B_move[i]];
			B_position[1] += dy[B_move[i]];
			
			result+=getMax();
		}
		return;
	}
	
	static int check(int a, int x, int y) {
		return Math.abs(bc_list[a][0]-x)+Math.abs(bc_list[a][1]-y) <= bc_list[a][2] ? bc_list[a][3] : 0;
	}
	
	static int getMax() {
		int max = 0;
		for (int a = 0; a < A; a++) {
			for (int b = 0; b < A; b++) {
				int sum = 0;
				int amountA = check(a, A_position[0], A_position[1]);
				int amountB = check(b, B_position[0], B_position[1]);
				
				if (a!=b) sum = amountA + amountB;
				else sum = Math.max(amountA,  amountB);
				
				if (max < sum) max = sum;
			}
			
		}
		return max;
	}

}

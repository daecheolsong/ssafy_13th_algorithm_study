package BOJ;

import java.io.*;
import java.util.*;

public class S3_15654 {
	static int N, M;
	static int[] input, numbers;
	static boolean[] isSelected;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isSelected = new boolean[N];
		numbers = new int[M];
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		//System.out.println(Arrays.toString(input));
		perm(0);
	}

	private static void perm(int cnt) {
		if(cnt==M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = input[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
}

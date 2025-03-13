package Day0313;

import java.io.*;
import java.util.*;

public class S3_15651 {
	static int N, M;
	static int[] numbers, input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			numbers[cnt] = i+1;
			perm(cnt+1);
		}
		
	}

}

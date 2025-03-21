import java.io.*;
import java.util.*;

public class S3_15656 {
	static int N, R;
	static int[] numbers, input;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		numbers = new int[R];
		input = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if(cnt==R) {
			for (int i = 0; i < R; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < input.length; i++) {
			numbers[cnt] = input[i];
			perm(cnt+1);
		}
	}
}

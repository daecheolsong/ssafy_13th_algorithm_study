package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
	static int[][] d = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		int N = Integer.parseInt(br.readLine());
		int[] people = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int result = 0;
		Arrays.sort(people);
		for(int i = 0; i < N; i ++) {
			sum += people[i];
			result += sum;
		}
		sb.append(result);
		System.out.println(sb);
	}

}
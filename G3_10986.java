package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] S = new long[N];
		long[] C = new long[M];
		long count = 0;
		
		st = new StringTokenizer(br.readLine());
		S[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 0; i < N; i++) {
			int remainder = (int) (S[i] % M); // 나머지가 같은 값 기억하기
			
			
			//나머지가 0인거 count하기
			if(remainder == 0) count++;
			
			//나머지 같은 인덱스 개수 카운팅하기 why? 같은 나머지 수가 2개 이상이면 빼서 M으로 나눌 수 있음
			C[remainder]++;
			
		}
		
		for (int i = 0; i < M; i++) {
			if (C[i] > 1) { // 나머지가 같은게 2개 이상일 경우만
				// 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
				// nCr의 조합을 구하는 수 지만 r이 2로 고정이고 n값이 같은 나머지의 수다.
				count += (C[i] * (C[i] - 1)) / 2;
			}
		}
		System.out.println(count);
	}
}
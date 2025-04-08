import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1940 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int i = 0;
		int j = N-1;
		int count = 0; // 1로 시작하는 이유는 N값은 계산하지 않을거기 때문
		int sum = 0;
		while(i < j) {
			sum = arr[i] + arr[j];
			if(sum > M) {
				j--;
			}else if (sum < M) {
				i++;
			}else {
				count++;
				i++;
				j--;
			}
		}
		System.out.println(count);

	}

}

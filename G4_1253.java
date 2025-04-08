package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_1253 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		long[] arr = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int count = 0;
		for (int M = 0; M < N; M++) {
			long find = arr[M];
			int i = 0;
			int j = N - 1;

			while (i < j) {
				if (arr[i] + arr[j] == find) {
					if (i != M && j != M) {
						count++;
						break;
					} else if (i == M) {
						i++;
					} else if (j == M) {
						j--;
					}
				} else if (arr[i] + arr[j] < find) {
					i++;
				} else {
					j--;
				}
			}
		}
		System.out.println(count);
	}
}

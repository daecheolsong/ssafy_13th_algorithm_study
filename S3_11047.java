import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coin = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		int count = 0;
		int idx = 0;
		while (true) {
			if (K >= coin[idx]) {
				while (true) {
					count += K / coin[idx];
					K %= coin[idx];
					if(K <= coin[idx]) break;
				}
			}
			if (K == 0)
				break;
			// K보다 작은 동전을 찾을때
			idx++;
		}

		sb.append(count);
		System.out.println(sb);

	}
}

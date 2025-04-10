import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class G4_1034 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] rows = new String[N];
		Map<String, Integer> rowCount = new HashMap<>();

		for (int i = 0; i < N; i++) {
			rows[i] = br.readLine();
			rowCount.put(rows[i], rowCount.getOrDefault(rows[i], 0) + 1);
		}

		int K = Integer.parseInt(br.readLine());

		int maxOnRows = 0;

		for (String row : rowCount.keySet()) {
			int zeroCount = 0;

			for (int j = 0; j < M; j++) {
				if (row.charAt(j) == '0') {
					zeroCount++;
				}
			}

			// 꺼진 램프 수 ≤ K && (K - 꺼진 램프 수)가 짝수
			if (zeroCount <= K && (K - zeroCount) % 2 == 0) {
				maxOnRows = Math.max(maxOnRows, rowCount.get(row));
			}
		}

		System.out.println(maxOnRows);
	}
}

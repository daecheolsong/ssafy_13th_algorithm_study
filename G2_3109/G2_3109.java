import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_3109 {
	static int n;
	static int m;
	static int[][] map;
	static int[] mvr = { -1, 0, 1 };
	static int[] mvc = { 1, 1, 1 };
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				char c = line.charAt(j);
				map[i][j] = c == '.' ? 0 : 1;
			}
		}

		for (int i = 0; i < n; i++) {
			if (connect(i, 0)) {
				answer++;
			}

		}
		System.out.println(answer);

	}

	public static boolean connect(int r, int c) {
		map[r][c] = 2;
		if (c == m - 1) {
			return true;
		}

		for (int i = 0; i < 3; i++) {

			int nr = r + mvr[i];
			int nc = c + mvc[i];

			if (isIn(nr, nc) && map[nr][nc] == 0) {
				if (connect(nr, nc)) {
					return true;
				}
			}
		}
		return false;

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}

}

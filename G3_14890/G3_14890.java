
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_14890 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int answer = 0;

		int[][] horizontalCheckMap = new int[N][N];
		int[][] VerticalCheckMap = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				horizontalCheckMap[i][j] = Integer.parseInt(st.nextToken());
				VerticalCheckMap[j][i] = horizontalCheckMap[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			int cnt = 1;
			int j;

			for (j = 0; j < N - 1; j++) {
				if (isSameSlope(horizontalCheckMap, i, j)) {
					cnt++;
				} else if (isIncliningSlopeNeeded(horizontalCheckMap, i, j) && isIncliningSlopeLengthSufficient(cnt, L)) {
					cnt = 1;
				} else if (isDecliningSlopeNeeded(horizontalCheckMap, i, j) && isDecliningSlopeLengthSufficient(cnt, L)) {
					cnt = 1 - L;
				} else {
					break;
				}
			}
			if (isPathEnd(j, N, cnt)) {
				answer++;
			}
		}

		for (int i = 0; i < N; i++) {
			int cnt = 1;
			int j;

			for (j = 0; j < N - 1; j++) {
				if (isSameSlope(VerticalCheckMap, i, j)) {
					cnt++;
				} else if (isIncliningSlopeNeeded(VerticalCheckMap, i, j) && isIncliningSlopeLengthSufficient(cnt, L)) {
					cnt = 1;
				} else if (isDecliningSlopeNeeded(VerticalCheckMap, i, j) && isDecliningSlopeLengthSufficient(cnt, L)) {
					cnt = 1 - L;
				} else {
					break;
				}
			}
			if (isPathEnd(j, N, cnt)) {
				answer++;
			}
		}

		System.out.println(answer);

	}

	public static boolean isPathEnd(int j, int N, int cnt) {
		return j == N - 1 && cnt >= 0;
	}

	public static boolean isSameSlope(int[][] map, int i, int j) {
		return map[i][j] == map[i][j + 1];
	}

	public static boolean isIncliningSlopeNeeded(int[][] map, int i, int j) {
		return map[i][j] + 1 == map[i][j + 1];
	}

	public static boolean isDecliningSlopeNeeded(int[][] map, int i, int j) {
		return map[i][j] - 1 == map[i][j + 1];
	}

	public static boolean isIncliningSlopeLengthSufficient(int cnt, int L) {
		return cnt >= L;
	}

	public static boolean isDecliningSlopeLengthSufficient(int cnt, int L) {
		return cnt >= 0;
	}

}

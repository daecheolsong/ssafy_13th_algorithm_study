import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G3_16236 {
	static int[] mvr = { -1, 0, 0, 1 };
	static int[] mvc = { 0, -1, 1, 0 };
	static int[][] map;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];

		int r = -1;
		int c = -1;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					r = i;
					c = j;
					map[i][j] = 0;
				}

			}
		}

		int moveCnt = 0;
		int eatCnt = 0;
		int size = 2;

		while (true) {
			// 우선순위 : 1.이동거리  2.제일 위쪽 3.제일 왼쪽
			PriorityQueue<int[]> pq = new PriorityQueue<>(
					(p1, p2) -> p1[2] == p2[2] ? (p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]) : p1[2] - p2[2]);
			// 현재위치 (r, c) , 이동거리
			pq.add(new int[] { r, c, 0 });
			int[][] v = new int[n][n];
			v[r][c] = 1;

			boolean isEat = false;

			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				r = cur[0];
				c = cur[1];
				
				int moveDistance = cur[2];
				// 상어를 먹을수 있으면
				if (isShark(r, c) && canEat(r, c, size)) {
					map[r][c] = 0;
					eatCnt++;
					moveCnt += cur[2]; // 이동거리 추가
					isEat = true;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nr = r + mvr[i];
					int nc = c + mvc[i];
					// 방문한 곳이 아니고, 그 자리로 이동가능하다면(아기상어보다 크기가 작거나 같으면)
					if (isIn(nr, nc) && v[nr][nc] == 0 && isSharkSmallOrEqualThanBaby(nr, nc, size)) {
						pq.add(new int[] { nr, nc, moveDistance + 1 });
						v[nr][nc] = 1;
					}
				}
			}
			// 이동가능한 곳을 모두 탐색했지만 상어를 먹지 못했다면
			if (!isEat) {
				break;
			}
			// 아기상어의 크기만큼 상어를 먹었으면
			if (size == eatCnt) {
				size++; // 아기상어 크기 증가
				eatCnt = 0;
			}
		}
		System.out.println(moveCnt);
	}

	private static boolean isSharkSmallOrEqualThanBaby(int r, int c, int size) {
		return map[r][c] <= size;
	}

	private static boolean canEat(int r, int c, int size) {
		return map[r][c] < size;
	}

	private static boolean isShark(int r, int c) {
		return map[r][c] != 0;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}
}

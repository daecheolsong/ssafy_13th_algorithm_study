package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int[][] d = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());

			// A 와 B의 경로
			int[][] move = new int[2][M];
			int[][] AP = new int[A][4]; // BC정보

			// a b 경로 받기
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					move[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 각 ap의 정보 (0부터 순서대 r , c , cover, power;
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					AP[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int sum = 0;
			int[][] p = { { 1, 1 }, { 10, 10 } };
			for (int i = 0; i <= M; i++) { // 한번 움직일때마다.
				boolean[] connectionA = new boolean[A]; // A사용자가 방문해있으면 A크기를 넣어서 구분
				boolean[] connectionB = new boolean[A]; // B사용자가 방문해있으면
				for (int j = 0; j < 2; j++) { // A B사용자
					if (i != 0) {
						p[j][0] += d[move[j][i - 1]][0];
						p[j][1] += d[move[j][i - 1]][1];
					}
					for (int k = 0; k < A; k++) {
						int[] bc = AP[k]; // bc 4개 값을 의미
						if (bc[2] >= Math.abs(bc[0] - p[j][0]) + Math.abs(bc[1] - p[j][1])) {
							if (j == 0)
								connectionA[k] = true;
							if (j == 1)
								connectionB[k] = true;
						}
					}

				}
				int currMax = 0;
				for (int j = 0; j < A; j++) {
					for (int k = 0; k < A; k++) {
						if (A == 1 && (connectionA[j] || connectionB[k])) {
							currMax = connectionA[j] ? AP[j][3] : AP[k][3];
						}
						if ((!connectionA[j] && !connectionB[k]) || j == k) {
							continue;
						}
						int power1 = connectionA[j] ? AP[j][3] : 0;
						int power2 = connectionB[j] ? AP[k][3] : 0;
						int curr = power1 + power2;
						currMax = Math.max(currMax, curr);
					}
				}
				sum += currMax;
				
			}
			sb.append("#"+t+" "+sum).append("\n"); 
		}
		System.out.println(sb);
	}

}
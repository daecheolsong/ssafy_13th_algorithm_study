import java.io.*;
import java.util.*;

public class Main {

    static int T, N, d, cnt;
    static int[][] X;
    static int[] temp1, temp2;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < T + 1; tc++) {
            init();
            /*
             * 1. 각도 양수(시계 방향) / 음수(반시계 방향) 구분 2. 절대값 변환 후, d % 45 횟수 카운트 (45도 1회, 90도 2회
             * ..) 3. 시계 / 반시계 방향에 따른 돌리기 구현, 카운트 횟수 만큼 돌리기 3-1. 주 대각선 -> 가운데 열 / 주 대각선 ->
             * 가운데 행 3-2. 가운데 열 -> 부 대각선 / 가운데 행 -> 부 대각선 3-3. 부 대각선 -> 가운데 행 / 부 대각선 -> 가운데
             * 열 3-4. 가운데 행 -> 주 대각선 / 가운데 열 -> 주 대각선
             */

            if (d >= 0) { // 시계 방향
                cnt = d / 45;
                for (int c = 0; c < cnt; c++) {
                    for (int i = 0; i < N; i++) {
                        temp1[i] = X[i][i]; // temp1 에 주대각선 1,7,13,19,25
                        temp2[i] = X[i][N / 2]; // temp2 에 가운데 열 3,8,13,18,23
                        X[i][N / 2] = temp1[i]; // temp1 (주 대각선) -> 가운데 열
                        temp1[i] = X[N - 1 - i][i]; // temp1 에 부대각선 21,17,13,9,5
                        X[i][N - 1 - i] = temp2[i]; // temp2 ( 가운데 열) -> 부대각선
                        temp2[i] = X[N / 2][i]; // temp2 에 가운데 행 11,12,13,14,15
                        X[N / 2][i] = temp1[i]; // temp1 (부대각선) -> 가운데 행
                        X[i][i] = temp2[i]; // temp2 (가운데 행) -> 주대각선
                    }
                }
            } else { // 반시계 방향
                cnt = Math.abs(d) / 45;
                for (int c = 0; c < cnt; c++) {
                    for (int i = 0; i < N; i++) {
                        temp1[i] = X[i][i]; // temp1 에 주대각선 1,7,13,19,25
                        temp2[i] = X[N / 2][i]; // temp2 에 가운데 행 11,12,13,14,15
                        X[N / 2][i] = temp1[i]; // temp1 (주 대각선) -> 가운데 행
                        temp1[i] = X[i][N - 1 - i]; // temp1 에 부대각선 5,9,13,17,21
                        X[N - 1 - i][i] = temp2[i]; // temp2 ( 가운데 행) -> 부대각선
                        temp2[i] = X[i][N / 2]; // temp2 에 가운데 열
                        X[i][N / 2] = temp1[i]; // temp1 (부대각선) -> 가운데 열
                        X[i][i] = temp2[i]; // temp2 (가운데 열) -> 주대각선
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(X[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        X = new int[N][N];
        temp1 = new int[N];
        temp2 = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                X[i][j] = Integer.parseInt(st.nextToken());
                // System.out.print(X[i][j]+" ");
            }
            // System.out.println();
        }
    }

}

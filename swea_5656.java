import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
		/*
		 * 1. 쏘는 위치 정보가 담긴 크기 N인 배열 (W개 중 N개 중복순열 만큼 반복)
		 * 2. 배열 순서대로 쏘기
		 * 3. 맨 위 벽돌 위치 확인, 맨 위 벽돌부터 전파
		 * 4. 전파 위치 범위 확인 (벽돌에 적힌 숫자 -1 만큼 상하좌우 일직선으로 전파)
		 * 5. 범위에 있던 벽돌 제거 x N번 반복
		 * 6. 제거 후, 중력 적용 x N번 반복
		 * 6. N번 반복 쏜 후, 남은 벽돌 수 카운트
		 * 7. 쏘는 위치 정보 중, 남은 벽돌 수가 최솟값 구하기
		 */

    static int N, W, H, min;
    static int[] input;          // 중복순열 저장 배열
    static int[][] map, copy;    // 원본 맵, 복사용 맵
    static Queue<int[]> queue;   // 전파 처리용 큐
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            input = new int[N];
            perm(0);
            System.out.println("#" + tc + " " + min);
        }
    }

    static void perm(int depth) {
        if (min == 0) return; // 이미 최소가 0이면 종료
        
        if (depth == N) {
            // 맵 복사
            copy = new int[H][W];
            for (int i = 0; i < H; i++) copy[i] = map[i].clone();

            for (int i = 0; i < N; i++) {
                int col = input[i];
                int row = findTop(col);
                if (row == -1) continue;
                destroy(row, col);
                gravity();
            }

            min = Math.min(min, countBlocks());
            return;
        }

        for (int i = 0; i < W; i++) {
            input[depth] = i;
            perm(depth + 1);
        }
    }

    static int findTop(int c) {
        for (int r = 0; r < H; r++) {
            if (copy[r][c] != 0) return r;
        }
        return -1;
    }

    static void destroy(int r, int c) {
        queue = new ArrayDeque<>();
        if (copy[r][c] > 1) queue.offer(new int[]{r, c, copy[r][c]});
        else copy[r][c] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int range = cur[2];
            copy[cur[0]][cur[1]] = 0;

            for (int d = 0; d < 4; d++) {
                int nr = cur[0];
                int nc = cur[1];
                for (int k = 1; k < range; k++) {
                    nr += dr[d];
                    nc += dc[d];
                    if (nr < 0 || nc < 0 || nr >= H || nc >= W) break;
                    if (copy[nr][nc] == 0) continue;
                    if (copy[nr][nc] > 1) queue.offer(new int[]{nr, nc, copy[nr][nc]});
                    else copy[nr][nc] = 0;
                }
            }
        }
    }

    static void gravity() {
        for (int c = 0; c < W; c++) {
            Stack<Integer> stack = new Stack<>();
            for (int r = H - 1; r >= 0; r--) {
                if (copy[r][c] != 0) stack.push(copy[r][c]);
                copy[r][c] = 0;
            }

            int r = H - 1;
            while (!stack.isEmpty()) {
                copy[r--][c] = stack.pop();
            }
        }
    }

    static int countBlocks() {
        int cnt = 0;
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                if (copy[i][j] != 0) cnt++;
        return cnt;
    }
}

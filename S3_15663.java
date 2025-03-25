package BOJ;
import java.io.*;
import java.util.*;

public class S3_15663 {
    static int N, M;
    static int[] input, numbers;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        numbers = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input); // 중복 제거를 쉽게 하기 위해 정렬
        perm(0);
        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(numbers[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int prev = -1; // 중복 제거를 위한 이전 값 저장
        for (int i = 0; i < N; i++) {
            if (!visited[i] && input[i] != prev) { // 중복 방지
                visited[i] = true;
                numbers[cnt] = input[i];
                prev = input[i];

                perm(cnt + 1);

                visited[i] = false;
            }
        }
    }
}

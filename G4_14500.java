import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_14500 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] arr;
    static boolean[][] visit;
    static int n, m;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visit[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void dfs(int x, int y, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx < 0 || cx >= n || cy < 0 || cy >= m) {
                continue;
            }

            if (!visit[cx][cy]) {
                if (depth == 2) {
                    visit[cx][cy] = true;
                    dfs(x, y, sum + arr[cx][cy], depth + 1);
                    visit[cx][cy] = false;
                }

                visit[cx][cy] = true;
                dfs(cx, cy, sum + arr[cx][cy], depth + 1);
                visit[cx][cy] = false;
            }
        }
    }
}
